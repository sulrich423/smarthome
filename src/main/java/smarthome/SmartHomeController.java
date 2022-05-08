package smarthome;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import smarthome.alexa.DirectiveName;
import smarthome.alexa.request.AdjustRangeValueRequest;
import smarthome.alexa.request.ReportStateRequest;
import smarthome.alexa.request.SetRangeValueRequest;
import smarthome.alexa.request.TurnOffRequest;
import smarthome.alexa.request.TurnOnRequest;
import smarthome.alexa.request.UnspecifiedRequest;
import smarthome.alexa.response.DiscoverResponse;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint;
import smarthome.alexa.response.RangeValueResponse;
import smarthome.alexa.response.ReportStateResponse;
import smarthome.alexa.response.TurnOffResponse;
import smarthome.alexa.response.TurnOnResponse;
import smarthome.service.ServiceCall;
import smarthome.service.action.Action;

public class SmartHomeController implements RequestStreamHandler {

  private static ObjectMapper mapper = new ObjectMapper();

  @Override
  public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) {
    String input = inputStreamToString(inputStream);
    DirectiveName requestType = determineRequestType(input);
    System.out.println("requestType: " + requestType);
    switch (requestType) {
    case DISCOVER:
      doDiscoverAppliancesResponse(outputStream);
      break;
    case TURN_ON:
      TurnOnRequest turnOnRequest = readValue(input, TurnOnRequest.class);
      doTurnOn(turnOnRequest.getDirective().getEndpoint().getEndpointId(),
          turnOnRequest.getDirective().getHeader().getCorrelationToken(), outputStream);
      break;
    case TURN_OFF:
      TurnOffRequest turnOffRequest = readValue(input, TurnOffRequest.class);
      doTurnOff(turnOffRequest.getDirective().getEndpoint().getEndpointId(),
          turnOffRequest.getDirective().getHeader().getCorrelationToken(), outputStream);
      break;
    case SET_RANGE_VALUE:
      SetRangeValueRequest setRangeValueRequest = readValue(input, SetRangeValueRequest.class);
      doSetRangeValue(setRangeValueRequest.getDirective().getEndpoint().getEndpointId(),
          setRangeValueRequest.getDirective().getHeader().getCorrelationToken(),
          setRangeValueRequest.getDirective().getPayload().getRangeValue(), outputStream);
      break;
    case ADJUST_RANGE_VALUE:
      AdjustRangeValueRequest adjustRangeValueRequest = readValue(input, AdjustRangeValueRequest.class);
      doAdjustRangeValue(adjustRangeValueRequest.getDirective().getEndpoint().getEndpointId(),
          adjustRangeValueRequest.getDirective().getHeader().getCorrelationToken(),
          adjustRangeValueRequest.getDirective().getPayload().getRangeValueDelta(),
          adjustRangeValueRequest.getDirective().getPayload().getRangeValueDeltaDefault(), outputStream);
      break;
    case REPORT_STATE:
      ReportStateRequest reportStateRequest = readValue(input, ReportStateRequest.class);
      doReportState(reportStateRequest.getDirective().getEndpoint().getEndpointId(),
          reportStateRequest.getDirective().getHeader().getCorrelationToken(), outputStream);
      break;
    default:
      break;
    }
  }

  private DirectiveName determineRequestType(String input) {
    UnspecifiedRequest request = readValue(input, UnspecifiedRequest.class);

    return request.getDirective().getHeader().getName();
  }

  private void doDiscoverAppliancesResponse(OutputStream output) {
    List<Endpoint> discoveredAppliances = Configuration.DISCOVERABLE_DEVICES;
    DiscoverResponse.Event.Payload payload = new DiscoverResponse.Event.Payload(discoveredAppliances);
    DiscoverResponse response = new DiscoverResponse(payload);
    writeValue(output, response);
  }

  private void doTurnOn(String endpointId, String correlationToken, OutputStream output) {
    Configuration.DEVICE_ACTION_MAPPING.get(endpointId).parallelStream()
        .map(Action::getOnCall)
        .forEach(this::executeAction);

    TurnOnResponse turnOnResponse = new TurnOnResponse(correlationToken, endpointId);
    writeValue(output, turnOnResponse);
  }

  private void doTurnOff(String endpointId, String correlationToken, OutputStream output) {
    Configuration.DEVICE_ACTION_MAPPING.get(endpointId).parallelStream()
        .map(Action::getOffCall)
        .forEach(this::executeAction);

    TurnOffResponse turnOffResponse = new TurnOffResponse(correlationToken, endpointId);
    writeValue(output, turnOffResponse);
  }

  private void doSetRangeValue(String endpointId, String correlationToken, Integer value, OutputStream output) {
    Configuration.DEVICE_ACTION_MAPPING.get(endpointId).parallelStream()
        .map(action -> action.getSetRangeCall(value))
        .forEach(this::executeAction);

    RangeValueResponse rangeValueResponse = new RangeValueResponse(correlationToken, endpointId, value);
    writeValue(output, rangeValueResponse);
  }

  private void doAdjustRangeValue(String endpointId, String correlationToken, Integer delta,
      Boolean rangeValueDeltaDefault, OutputStream output) {
    Integer oldValue = Configuration.DEVICE_STATE_MAPPING.get(endpointId).requestState();

    Configuration.DEVICE_ACTION_MAPPING.get(endpointId).parallelStream()
        .map(action -> action.getAdjustRangeCall(oldValue, delta))
        .forEach(this::executeAction);

    Integer newValue = Configuration.DEVICE_STATE_MAPPING.get(endpointId).requestState();

    RangeValueResponse rangeValueResponse = new RangeValueResponse(correlationToken, endpointId, newValue);
    writeValue(output, rangeValueResponse);
  }

  private void doReportState(String endpointId, String correlationToken, OutputStream output) {
    StateReport stateReport = Configuration.DEVICE_STATE_MAPPING.get(endpointId);
    Integer value = stateReport.requestState();

    ReportStateResponse reportStateResponse = new ReportStateResponse(correlationToken, endpointId, stateReport.getInstance(),
        stateReport.getInterface(), stateReport.getRetrievableProperty(), value);
    writeValue(output, reportStateResponse);
  }

  private void executeAction(ServiceCall action) {
    ClientBuilder.newClient()
        .register(JacksonJsonProvider.class)
        .register(HttpAuthenticationFeature.basic(Configuration.USERNAME, Configuration.PASSWORD))
        .target(action.getUrl())
        .request()
        .buildPost(Entity.entity(action.getPayload(), MediaType.APPLICATION_JSON_TYPE))
        .invoke();
  }

  private String inputStreamToString(InputStream inputStream) {
    try {
      return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    } catch (IOException e) {
      return "";
    }
  }

  private <T> T readValue(String input, Class<T> clazz) {
    try {
      System.out.println(input);
      return mapper.readValue(input, clazz);
    } catch (IOException e) {
    }
    return null;
  }

  private void writeValue(OutputStream outputStream, Object response) {
    try {
      String debug = mapper.writeValueAsString(response);
      System.out.println(debug);
      mapper.writeValue(outputStream, response);
    } catch (IOException e) {
    }
  }
}

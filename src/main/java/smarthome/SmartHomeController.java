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

import smarthome.alexa.request.SetPercentageRequest;
import smarthome.alexa.request.TurnOffRequest;
import smarthome.alexa.request.TurnOnRequest;
import smarthome.alexa.request.UnspecifiedRequest;
import smarthome.alexa.response.DiscoverResponse;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoints;
import smarthome.alexa.response.PercentageResponse;
import smarthome.alexa.response.TurnOffResponse;
import smarthome.alexa.response.TurnOnResponse;
import smarthome.service.ServiceCall;
import smarthome.service.action.Action;

public class SmartHomeController implements RequestStreamHandler {

  private static ObjectMapper mapper = new ObjectMapper();

  @Override
  public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) {
    String input = inputStreamToString(inputStream);
    String requestType = determineRequestType(input);
    System.out.println("requestType: " + requestType);
    switch (requestType) {
    case "Discover":
      doDiscoverAppliancesResponse(outputStream);
      break;
    case "TurnOn":
      TurnOnRequest turnOnRequest = readValue(input, TurnOnRequest.class);
      doTurnOn(turnOnRequest.getDirective().getEndpoint().getEndpointId(),
          turnOnRequest.getDirective().getHeader().getCorrelationToken(), outputStream);
      break;
    case "TurnOff":
      TurnOffRequest turnOffRequest = readValue(input, TurnOffRequest.class);
      doTurnOff(turnOffRequest.getDirective().getEndpoint().getEndpointId(),
          turnOffRequest.getDirective().getHeader().getCorrelationToken(), outputStream);
      break;
    case "SetPercentage":
      SetPercentageRequest setPercentageRequest = readValue(input, SetPercentageRequest.class);
      doSetPercentage(setPercentageRequest.getDirective().getEndpoint().getEndpointId(),
          setPercentageRequest.getDirective().getHeader().getCorrelationToken(),
          setPercentageRequest.getDirective().getPayload().getPercentage(),
          outputStream);
      break;
    }
  }

  private String determineRequestType(String input) {
    UnspecifiedRequest request = readValue(input, UnspecifiedRequest.class);

    return request.getDirective().getHeader().getName();
  }

  private void doDiscoverAppliancesResponse(OutputStream output) {
    List<Endpoints> discoveredAppliances = Configuration.DISCOVERABLE_DEVICES;
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

  private void doSetPercentage(String endpointId, String correlationToken, Integer value, OutputStream output) {
    Configuration.DEVICE_ACTION_MAPPING.get(endpointId).parallelStream()
        .map(a -> a.getSetPercentageCall(value))
        .forEach(this::executeAction);

    PercentageResponse setPercentageConfirmation = new PercentageResponse(correlationToken, endpointId, value);
    writeValue(output, setPercentageConfirmation);
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
      return mapper.readValue(input, clazz);
    } catch (IOException e) {
    }
    return null;
  }

  private void writeValue(OutputStream outputStream, Object response) {
    try {
      mapper.writeValue(outputStream, response);
    } catch (IOException e) {
    }
  }
}

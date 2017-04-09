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

import smarthome.request.TurnOffRequest;
import smarthome.request.TurnOnRequest;
import smarthome.request.UnspecifiedRequest;
import smarthome.response.DiscoverAppliancesResponse;
import smarthome.response.DiscoverAppliancesResponse.Payload.DiscoveredAppliances;
import smarthome.response.TurnOffConfirmation;
import smarthome.response.TurnOnConfirmation;
import smarthome.response.TurnOnConfirmation.Payload;

public class SmartHomeController implements RequestStreamHandler {

  private static ObjectMapper mapper = new ObjectMapper();

  @Override
  public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) {
    String input = inputStreamToString(inputStream);
    String requestType = determineRequestType(input);
    System.out.println("requestType: " + requestType);
    switch (requestType) {
    case "DiscoverAppliancesRequest":
      doDiscoverAppliancesResponse(outputStream);
      break;
    case "TurnOnRequest":
      TurnOnRequest.Payload turnOnPayload = readValue(input, TurnOnRequest.class).getPayload();
      doTurnOn(turnOnPayload.getAppliance().getApplianceId(), outputStream);
      break;
    case "TurnOffRequest":
      TurnOffRequest.Payload turnOffPayload = readValue(input, TurnOffRequest.class).getPayload();
      doTurnOff(turnOffPayload.getAppliance().getApplianceId(), outputStream);
      break;
    }
  }

  private String determineRequestType(String input) {
    UnspecifiedRequest request = readValue(input, UnspecifiedRequest.class);
    return request.getHeader().getName();
  }

  private void doDiscoverAppliancesResponse(OutputStream output) {
    List<DiscoveredAppliances> discoveredAppliances = Configuration.DISCOVERABLE_DEVICES;
    DiscoverAppliancesResponse.Payload payload = new DiscoverAppliancesResponse.Payload(discoveredAppliances);
    DiscoverAppliancesResponse response = new DiscoverAppliancesResponse(payload);
    writeValue(output, response);
  }

  private void doTurnOn(String applianceId, OutputStream output) {
    Configuration.DEVICE_ACTION_MAPPING.get(applianceId).parallelStream()
        .map(SwitchAction::getOnAction)
        .forEach(this::executeAction);

    TurnOnConfirmation turnOnConfirmation = new TurnOnConfirmation(new Payload());
    writeValue(output, turnOnConfirmation);
  }

  private void doTurnOff(String applianceId, OutputStream output) {
    Configuration.DEVICE_ACTION_MAPPING.get(applianceId).parallelStream()
        .map(SwitchAction::getOffAction)
        .forEach(this::executeAction);

    TurnOffConfirmation turnOffConfirmation = new TurnOffConfirmation(new TurnOffConfirmation.Payload());
    writeValue(output, turnOffConfirmation);
  }

  private void executeAction(Action action) {
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

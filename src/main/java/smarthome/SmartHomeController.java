package smarthome;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.ws.rs.client.ClientBuilder;

import org.apache.commons.io.IOUtils;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

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
    List<DiscoveredAppliances> discoveredAppliances = Lists.newArrayList(Devices.LIGHT);
    DiscoverAppliancesResponse.Payload payload = new DiscoverAppliancesResponse.Payload(discoveredAppliances);
    DiscoverAppliancesResponse response = new DiscoverAppliancesResponse(payload);
    writeValue(output, response);
  }

  private void doTurnOn(String applianceId, OutputStream output) {
    String target = null;
    if (Devices.LIGHT.getApplianceId().equals(applianceId)) {
      target = "https://replaceWithYourServiceUrl.org/api/services/shell_command/light_on?api_password=replaceWithYourPassword";
    }

    if (target != null) {
      ClientBuilder.newClient()
          .target(target)
          .request()
          .buildPost(null)
          .invoke(String.class);

      TurnOnConfirmation turnOnConfirmation = new TurnOnConfirmation(new Payload());
      writeValue(output, turnOnConfirmation);
    }
  }

  private void doTurnOff(String applianceId, OutputStream output) {
    String target = null;
    if (Devices.LIGHT.getApplianceId().equals(applianceId)) {
      target = "https://replaceWithYourServiceUrl.org/api/services/shell_command/light_off?api_password=replaceWithYourPassword";
    }

    if (target != null) {
      ClientBuilder.newClient()
          .target(target)
          .request()
          .buildPost(null)
          .invoke(String.class);

      TurnOffConfirmation turnOnConfirmation = new TurnOffConfirmation(new TurnOffConfirmation.Payload());
      writeValue(output, turnOnConfirmation);
    }

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

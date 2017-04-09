package smarthome.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.service.device.HarmonyAction;

@JsonPropertyOrder(alphabetic = true)
public class HarmonyCommandPayload implements Payload {

  @JsonProperty("device_id")
  private String deviceId;

  @JsonProperty("command")
  private String command;

  public HarmonyCommandPayload(HarmonyAction action) {
    this.deviceId = action.getDevice();
    this.command = action.getCommand();
  }

}

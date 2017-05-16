package smarthome.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
public class HarmonyCommandPayload implements Payload {

  @JsonProperty("device_id")
  private String deviceId;

  @JsonProperty("command")
  private String command;

  public HarmonyCommandPayload(String deviceId, String command) {
    this.deviceId = deviceId;
    this.command = command;
  }

}

package smarthome.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.service.device.HarmonyAction;

@JsonPropertyOrder(alphabetic = true)
public class HarmonyPayload {

  @JsonProperty("entity_id")
  private String entityId;

  @JsonProperty("device")
  private String device;

  @JsonProperty("command")
  private String command;

  public HarmonyPayload(HarmonyAction action) {
    this.entityId = action.getEntityId();
    this.device = action.getDevice();
    this.command = action.getCommand();
  }

}

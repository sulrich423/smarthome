package smarthome.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.service.device.HarmonyAction;

@JsonPropertyOrder(alphabetic = true)
public class HarmonyActivityOffPayload implements Payload {

  @JsonProperty("entity_id")
  private String entityId;

  public HarmonyActivityOffPayload(HarmonyAction action) {
    this.entityId = action.getEntityId();
  }

}

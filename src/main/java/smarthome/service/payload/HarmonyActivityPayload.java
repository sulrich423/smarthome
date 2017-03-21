package smarthome.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.service.device.HarmonyAction;

@JsonPropertyOrder(alphabetic = true)
public class HarmonyActivityPayload implements Payload {

  @JsonProperty("entity_id")
  private String entityId;

  @JsonProperty("activity")
  private String activity;

  public HarmonyActivityPayload(HarmonyAction action) {
    this.entityId = action.getEntityId();
    this.activity = action.getActivity();
  }

}

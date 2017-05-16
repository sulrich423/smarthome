package smarthome.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.service.device.HomematicAction;

@JsonPropertyOrder(alphabetic = true)
public class HomematicPayload implements Payload {

  @JsonProperty("position")
  private String position;

  public HomematicPayload(HomematicAction action) {
    this.position = action.getPosition();
  }

}

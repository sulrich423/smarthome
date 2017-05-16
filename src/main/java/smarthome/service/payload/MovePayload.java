package smarthome.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.service.device.MoveAction;

@JsonPropertyOrder(alphabetic = true)
public class MovePayload implements Payload {

  @JsonProperty("position")
  private String position;

  public MovePayload(MoveAction action) {
    this.position = action.getPosition();
  }

}

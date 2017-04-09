package smarthome.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.service.device.SocketAction;

@JsonPropertyOrder(alphabetic = true)
public class SocketPayload implements Payload {

  @JsonProperty("unitCode")
  private String unitCode;

  @JsonProperty("command")
  private String command;

  public SocketPayload(SocketAction action) {
    this.unitCode = action.getUnitCode();
    this.command = action.getCommand();
  }

}

package smarthome.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
public class SocketPayload implements Payload {

  @JsonProperty("unitCode")
  private String unitCode;

  @JsonProperty("command")
  private String command;

  public SocketPayload(String unitCode, String command) {
    this.unitCode = unitCode;
    this.command = command;
  }

}

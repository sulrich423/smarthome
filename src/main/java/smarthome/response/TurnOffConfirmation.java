package smarthome.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.Header;

@JsonPropertyOrder(alphabetic = true)
public class TurnOffConfirmation {

  @JsonProperty("header")
  private Header header;

  @JsonProperty("payload")
  private Payload payload;

  public TurnOffConfirmation(Payload payload) {
    this.header = new Header("TurnOffConfirmation", "Alexa.ConnectedHome.Control");
    this.payload = payload;
  }

  @JsonPropertyOrder(alphabetic = true)
  public static class Payload {

    public Payload() {

    }
  }
}

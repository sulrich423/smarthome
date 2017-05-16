package smarthome.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.Header;

@JsonPropertyOrder(alphabetic = true)
public class SetPercentageConfirmation {

  @JsonProperty("header")
  private Header header;

  @JsonProperty("payload")
  private Payload payload;

  public SetPercentageConfirmation(Payload payload) {
    this.header = new Header("SetPercentageConfirmation", "Alexa.ConnectedHome.Control");
    this.payload = payload;
  }

  @JsonPropertyOrder(alphabetic = true)
  public static class Payload {

    public Payload() {

    }
  }
}

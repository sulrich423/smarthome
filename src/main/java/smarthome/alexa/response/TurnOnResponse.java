package smarthome.alexa.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Context;
import smarthome.alexa.Endpoint;
import smarthome.alexa.Header;

@JsonPropertyOrder(alphabetic = true)
public class TurnOnResponse {

  @JsonProperty("context")
  private Context context;

  @JsonProperty("event")
  private Event event;

  public TurnOnResponse(String correlationToken, String endpointId) {
    this.context = new Context("Alexa.PowerController", "powerState", "ON");
    this.event = new Event(correlationToken, endpointId);
  }

  @JsonPropertyOrder(alphabetic = true)
  public static class Event {

    @JsonProperty("header")
    private Header header;

    @JsonProperty("endpoint")
    private Endpoint endpoint;

    @JsonProperty("payload")
    private Payload payload;

    public Event(String correlationToken, String endpointId) {
      this.header = new Header("Response", "Alexa", correlationToken);
      this.endpoint = new Endpoint(endpointId);
      this.payload = new Payload();
    }

    @JsonPropertyOrder(alphabetic = true)
    public static class Payload {

      public Payload() {

      }
    }

  }

}

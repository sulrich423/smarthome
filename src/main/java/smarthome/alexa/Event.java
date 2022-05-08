package smarthome.alexa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
public class Event {

  @JsonProperty
  private Header header;
  @JsonProperty
  private Endpoint endpoint;
  @JsonProperty
  private Payload payload;

  public Event(String correlationToken, String endpointId) {
    this(DirectiveName.RESPONSE, correlationToken, endpointId);
  }

  public Event(DirectiveName name, String correlationToken, String endpointId) {
    this.header = new Header(Interface.ALEXA, name, correlationToken);
    this.endpoint = new Endpoint(endpointId);
    this.payload = new EmptyPayload();
  }

}
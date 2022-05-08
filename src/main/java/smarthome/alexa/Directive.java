package smarthome.alexa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Directive<T extends Payload> {

  @JsonProperty
  private Header header;
  @JsonProperty
  private Endpoint endpoint;
  @JsonProperty
  private T payload;

  public Header getHeader() {
    return header;
  }

  public Endpoint getEndpoint() {
    return endpoint;
  }

  public T getPayload() {
    return payload;
  }

}
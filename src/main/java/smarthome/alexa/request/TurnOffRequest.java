package smarthome.alexa.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Endpoint;
import smarthome.alexa.Header;

@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnOffRequest {

  @JsonProperty("directive")
  private Directive directive;

  public Directive getDirective() {
    return directive;
  }

  @JsonPropertyOrder(alphabetic = true)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Directive {

    @JsonProperty("header")
    private Header header;

    @JsonProperty("endpoint")
    private Endpoint endpoint;

    @JsonProperty("payload")
    private Payload payload;

    public Header getHeader() {
      return header;
    }

    public Endpoint getEndpoint() {
      return endpoint;
    }

    @JsonPropertyOrder(alphabetic = true)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Payload {

    }

  }

}

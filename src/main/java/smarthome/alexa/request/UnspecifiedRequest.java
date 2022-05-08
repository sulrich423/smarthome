package smarthome.alexa.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Directive;
import smarthome.alexa.EmptyPayload;

@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnspecifiedRequest {

  @JsonProperty
  private Directive<EmptyPayload> directive;

  public Directive<EmptyPayload> getDirective() {
    return directive;
  }

}

package smarthome.alexa.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Header;

@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnspecifiedRequest {

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

    public Header getHeader() {
      return header;
    }

  }
}

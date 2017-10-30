package smarthome.alexa.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Endpoint;
import smarthome.alexa.Header;

@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdjustPercentageRequest {

  @JsonProperty("directive")
  private Directive directive;

  public AdjustPercentageRequest(Directive directive) {
    this.directive = directive;
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

    public Directive(Header header, Endpoint endpoint, Payload payload) {
      this.header = header;
      this.endpoint = endpoint;
      this.payload = payload;
    }

    @JsonPropertyOrder(alphabetic = true)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Payload {

      @JsonProperty("percentageDelta")
      private Integer percentageDelta;

      public Payload(Integer percentageDelta) {
        this.percentageDelta = percentageDelta;
      }

    }

  }
}

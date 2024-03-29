package smarthome.alexa.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Directive;
import smarthome.alexa.Payload;

@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscoverRequest {

  @JsonProperty
  private Directive<DiscoverRequestPayload> directive;

  @JsonPropertyOrder(alphabetic = true)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class DiscoverRequestPayload implements Payload {

    @JsonProperty
    private Scope scope;

    @JsonPropertyOrder(alphabetic = true)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Scope {

      @JsonProperty
      private String type;
      @JsonProperty
      private String token;

    }
  }

}

package smarthome.alexa.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Header;

@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscoverRequest {

  @JsonProperty("directive")
  private Directive directive;

  @JsonPropertyOrder(alphabetic = true)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Directive {

    @JsonProperty("header")
    private Header header;

    @JsonProperty("payload")
    private Payload payload;

    @JsonPropertyOrder(alphabetic = true)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Payload {

      @JsonProperty("scope")
      private Scope scope;

      @JsonPropertyOrder(alphabetic = true)
      @JsonIgnoreProperties(ignoreUnknown = true)
      public static class Scope {

        @JsonProperty("type")
        private String type;

        @JsonProperty("token")
        private String token;

      }
    }
  }

}

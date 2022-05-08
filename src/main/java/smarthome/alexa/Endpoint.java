package smarthome.alexa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Endpoint {

  @JsonProperty
  private String endpointId;

  public Endpoint() {
  }

  public Endpoint(String endpointId) {
    this.endpointId = endpointId;
  }

  public String getEndpointId() {
    return endpointId;
  }

  @JsonPropertyOrder(alphabetic = true)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Scope {

    @JsonProperty
    private String type;
    @JsonProperty
    private String token;

    public Scope() {

    }

    public Scope(String type, String token) {
      this.type = type;
      this.token = token;
    }
  }

  @JsonPropertyOrder(alphabetic = true)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Cookie {

  }

}

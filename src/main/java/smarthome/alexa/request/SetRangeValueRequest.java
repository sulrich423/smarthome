package smarthome.alexa.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Directive;
import smarthome.alexa.Payload;

@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetRangeValueRequest {

  @JsonProperty
  private Directive<SetRangeValuePayload> directive;

  public Directive<SetRangeValuePayload> getDirective() {
    return directive;
  }

  @JsonPropertyOrder(alphabetic = true)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class SetRangeValuePayload implements Payload {

    @JsonProperty
    private Integer rangeValue;

    public SetRangeValuePayload() {

    }

    public SetRangeValuePayload(Integer rangeValue) {
      this.rangeValue = rangeValue;
    }

    public Integer getRangeValue() {
      return rangeValue;
    }

  }

}

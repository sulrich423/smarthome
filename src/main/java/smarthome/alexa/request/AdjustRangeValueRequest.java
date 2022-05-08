package smarthome.alexa.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Directive;
import smarthome.alexa.Payload;

@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdjustRangeValueRequest {

  @JsonProperty
  private Directive<AdjustRangeValuePayload> directive;

  public Directive<AdjustRangeValuePayload> getDirective() {
    return directive;
  }

  @JsonPropertyOrder(alphabetic = true)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class AdjustRangeValuePayload implements Payload {

    @JsonProperty
    private Integer rangeValueDelta;
    @JsonProperty
    private Boolean rangeValueDeltaDefault;

    public AdjustRangeValuePayload() {

    }

    public AdjustRangeValuePayload(Integer rangeValueDelta, Boolean rangeValueDeltaDefault) {
      this.rangeValueDelta = rangeValueDelta;
      this.rangeValueDeltaDefault = rangeValueDeltaDefault;
    }

    public Integer getRangeValueDelta() {
      return rangeValueDelta;
    }

    public Boolean getRangeValueDeltaDefault() {
      return rangeValueDeltaDefault;
    }

  }

}

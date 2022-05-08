package smarthome.alexa.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Context;
import smarthome.alexa.Event;
import smarthome.alexa.Interface;
import smarthome.alexa.PropertyName;

@JsonPropertyOrder(alphabetic = true)
public class RangeValueResponse {

  @JsonProperty
  private Context context;
  @JsonProperty
  private Event event;

  public RangeValueResponse(String correlationToken, String endpointId, Integer rangeValue) {
    this.context = new Context(Interface.ALEXA_RANGE_CONTROLLER, PropertyName.RANGE_VALUE, rangeValue.toString());
    this.event = new Event(correlationToken, endpointId);
  }

}

package smarthome.alexa.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Context;
import smarthome.alexa.Event;
import smarthome.alexa.Interface;
import smarthome.alexa.PropertyName;

@JsonPropertyOrder(alphabetic = true)
public class TurnOffResponse {

  @JsonProperty
  private Context context;
  @JsonProperty
  private Event event;

  public TurnOffResponse(String correlationToken, String endpointId) {
    this.context = new Context(Interface.ALEXA_POWER_CONTROLLER, PropertyName.POWER_STATE, "OFF");
    this.event = new Event(correlationToken, endpointId);
  }

}

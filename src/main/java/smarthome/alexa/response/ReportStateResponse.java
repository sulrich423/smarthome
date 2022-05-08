package smarthome.alexa.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Context;
import smarthome.alexa.DirectiveName;
import smarthome.alexa.Event;
import smarthome.alexa.Instance;
import smarthome.alexa.Interface;
import smarthome.alexa.PropertyName;

@JsonPropertyOrder(alphabetic = true)
public class ReportStateResponse {

  @JsonProperty
  private Context context;
  @JsonProperty
  private Event event;

  public ReportStateResponse(String correlationToken, String endpointId, Instance instance, Interface namespace,
      PropertyName name, Integer value) {
    this.context = new Context(namespace, name, instance, value.toString());
    this.event = new Event(DirectiveName.STATE_REPORT, correlationToken, endpointId);
  }

}

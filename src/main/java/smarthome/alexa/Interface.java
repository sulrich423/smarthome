package smarthome.alexa;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Interface {

  ALEXA("Alexa"),
  ALEXA_DISCOVERY("Alexa.Discovery"),
  ALEXA_POWER_CONTROLLER("Alexa.PowerController"),
  ALEXA_RANGE_CONTROLLER("Alexa.RangeController");

  String value;

  private Interface(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }
}

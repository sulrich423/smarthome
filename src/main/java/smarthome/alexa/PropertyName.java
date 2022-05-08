package smarthome.alexa;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PropertyName {

  POWER_STATE("powerState"),
  RANGE_VALUE("rangeValue");

  String value;

  private PropertyName(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }
}

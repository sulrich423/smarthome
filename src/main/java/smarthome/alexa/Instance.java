package smarthome.alexa;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Instance {

  BLIND_LIFT("Blind.Lift");

  String value;

  private Instance(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }
}

package smarthome.alexa;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DirectiveName {

  DISCOVER("Discover"),
  DISCOVER_RESPONSE("Discover.Response"),
  REPORT_STATE("ReportState"),
  TURN_ON("TurnOn"),
  TURN_OFF("TurnOff"),
  SET_PERCENTAGE("SetPercentage"),
  ADJUST_PERCENTAGE("AdjustPercentage"),
  RESPONSE("Response"),
  ERROR_RESPONSE("ErrorResponse"),
  STATE_REPORT("StateReport"),
  CHANGE_REPORT("ChangeReport"),
  SET_RANGE_VALUE("SetRangeValue"),
  ADJUST_RANGE_VALUE("AdjustRangeValue");

  private String value;

  private DirectiveName(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }
}

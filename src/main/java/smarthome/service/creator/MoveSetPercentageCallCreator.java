package smarthome.service.creator;

import smarthome.service.ServiceCall;
import smarthome.service.ServiceCall.CgiScript;
import smarthome.service.payload.MovePayload;

public class MoveSetPercentageCallCreator implements SetPercentageCallCreator {

  @Override
  public ServiceCall create(double value) {
    return new ServiceCall(CgiScript.MOVE, new MovePayload(mapValue(value)));
  }

  private String mapValue(double value) {
    return String.valueOf(Math.round(255.0 * value / 100.0));
  }
}

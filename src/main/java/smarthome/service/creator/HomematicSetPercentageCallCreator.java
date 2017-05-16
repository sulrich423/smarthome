package smarthome.service.creator;

import smarthome.service.ServiceCall;
import smarthome.service.ServiceCall.CgiScript;
import smarthome.service.payload.HomematicPayload;

public class HomematicSetPercentageCallCreator implements SetPercentageCallCreator {

  @Override
  public ServiceCall create(double value) {
    return new ServiceCall(CgiScript.HOMEMATIC, new HomematicPayload(mapValue(value)));
  }

  private String mapValue(double value) {
    return String.valueOf(Math.round(100 - value) / 100.0);
  }
}

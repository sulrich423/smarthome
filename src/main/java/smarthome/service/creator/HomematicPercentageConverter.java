package smarthome.service.creator;

import smarthome.service.ServiceCall;
import smarthome.service.ServiceCall.CgiScript;
import smarthome.service.payload.HomematicPayload;

public class HomematicPercentageConverter implements PercentageConverter {

  @Override
  public ServiceCall set(Integer value) {
    return new ServiceCall(CgiScript.HOMEMATIC_STATECHANGE, new HomematicPayload(convert(value)));
  }

  @Override
  public ServiceCall adjust(Integer oldValue, Integer delta) {
    Integer newValue = oldValue + delta;
    return new ServiceCall(CgiScript.HOMEMATIC_STATECHANGE, new HomematicPayload(convert(newValue)));
  }

  private String convert(Integer value) {
    return String.valueOf(value / 100.0);
  }

}

package smarthome;

import smarthome.Action.Domain;
import smarthome.service.device.HomematicAction;
import smarthome.service.payload.HomematicPayload;

public class HomematicSetPercentageActionCreator implements SetPercentageActionCreator {

  @Override
  public Action create(double value) {
    return new Action(Domain.BLIND_PATIO, new HomematicPayload(new HomematicAction(mapValue(value))));
  }

  private String mapValue(double value) {
    return String.valueOf(Math.round(100 - value) / 100.0);
  }
}

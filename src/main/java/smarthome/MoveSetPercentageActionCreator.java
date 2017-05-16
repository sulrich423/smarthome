package smarthome;

import smarthome.Action.Domain;
import smarthome.service.device.MoveAction;
import smarthome.service.payload.MovePayload;

public class MoveSetPercentageActionCreator implements SetPercentageActionCreator {

  @Override
  public Action create(double value) {
    return new Action(Domain.BLIND_WINDOW, new MovePayload(new MoveAction(mapValue(value))));
  }

  private String mapValue(double value) {
    return String.valueOf(Math.round(255.0 * value / 100.0));
  }
}

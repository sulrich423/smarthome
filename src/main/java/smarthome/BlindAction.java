package smarthome;

import smarthome.Action.Domain;
import smarthome.service.device.HomematicAction;
import smarthome.service.device.MoveAction;
import smarthome.service.payload.HomematicPayload;
import smarthome.service.payload.MovePayload;

public class BlindAction extends AbstractAction {

  public static final BlindAction BLIND_PATIO = new BlindAction(
      new Action(Domain.BLIND_PATIO, new HomematicPayload(HomematicAction.BLINDS_ON)),
      new Action(Domain.BLIND_PATIO, new HomematicPayload(HomematicAction.BLINDS_OFF)),
      new HomematicSetPercentageActionCreator());

  public static final BlindAction BLIND_WINDOW = new BlindAction(
      new Action(Domain.BLIND_WINDOW, new MovePayload(MoveAction.BLINDS_ON)),
      new Action(Domain.BLIND_WINDOW, new MovePayload(MoveAction.BLINDS_OFF)),
      new MoveSetPercentageActionCreator());

  private final Action onAction;
  private final Action offAction;
  private final SetPercentageActionCreator setPercentageActionCreator;

  private BlindAction(Action onAction, Action offAction, SetPercentageActionCreator setPercentageActionCreator) {
    this.onAction = onAction;
    this.offAction = offAction;
    this.setPercentageActionCreator = setPercentageActionCreator;
  }

  @Override
  public Action getOnAction() {
    return onAction;
  }

  @Override
  public Action getOffAction() {
    return offAction;
  }

  @Override
  public Action getSetPercentageAction(double value) {
    return setPercentageActionCreator.create(value);
  }
}

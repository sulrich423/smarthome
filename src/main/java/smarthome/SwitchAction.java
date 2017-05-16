package smarthome;

import smarthome.Action.Domain;
import smarthome.service.device.HarmonyAction;
import smarthome.service.device.SocketAction;
import smarthome.service.payload.HarmonyActivityOnPayload;
import smarthome.service.payload.HarmonyCommandPayload;
import smarthome.service.payload.SocketPayload;

public class SwitchAction extends AbstractAction {

  public static final SwitchAction LIGHT = new SwitchAction(
      new Action(Domain.SOCKET, new SocketPayload(SocketAction.LIGHT_ON)),
      new Action(Domain.SOCKET, new SocketPayload(SocketAction.LIGHT_OFF)));

  public static final SwitchAction CABIN_LIGHT = new SwitchAction(
      new Action(Domain.SOCKET, new SocketPayload(SocketAction.CABIN_LIGHT_ON)),
      new Action(Domain.SOCKET, new SocketPayload(SocketAction.CABIN_LIGHT_OFF)));

  public static final SwitchAction TV_LIGHT = new SwitchAction(
      new Action(Domain.HARMONY_COMMAND, new HarmonyCommandPayload(HarmonyAction.TV_LIGHT_POWERTOGGLE)),
      new Action(Domain.HARMONY_COMMAND, new HarmonyCommandPayload(HarmonyAction.TV_LIGHT_POWERTOGGLE)));

  public static final SwitchAction PLAYSTATION = new SwitchAction(
      new Action(Domain.HARMONY_ACTIVITY_ON, new HarmonyActivityOnPayload(HarmonyAction.ACTIVITY_PLAYSTATION)),
      new Action(Domain.HARMONY_ACTIVITY_OFF, null));

  private final Action onAction;
  private final Action offAction;

  private SwitchAction(Action onAction, Action offAction) {
    this.onAction = onAction;
    this.offAction = offAction;
  }

  @Override
  public Action getOnAction() {
    return onAction;
  }

  @Override
  public Action getOffAction() {
    return offAction;
  }

}

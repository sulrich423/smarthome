package smarthome;

import smarthome.Action.Domain;
import smarthome.service.device.HarmonyAction;
import smarthome.service.device.SocketAction;
import smarthome.service.payload.HarmonyActivityOnPayload;
import smarthome.service.payload.HarmonyCommandPayload;
import smarthome.service.payload.SocketPayload;

public enum SwitchAction {
  LIGHT(new Action(Domain.SOCKET, new SocketPayload(SocketAction.LIGHT_ON)),
      new Action(Domain.SOCKET, new SocketPayload(SocketAction.LIGHT_OFF))), //

  CABIN_LIGHT(new Action(Domain.SOCKET, new SocketPayload(SocketAction.CABIN_LIGHT_ON)),
      new Action(Domain.SOCKET, new SocketPayload(SocketAction.CABIN_LIGHT_OFF))), //

  TV_LIGHT(new Action(Domain.HARMONY_COMMAND, new HarmonyCommandPayload(HarmonyAction.TV_LIGHT_POWERTOGGLE)),
      new Action(Domain.HARMONY_COMMAND, new HarmonyCommandPayload(HarmonyAction.TV_LIGHT_POWERTOGGLE))), //

  PLAYSTATION(new Action(Domain.HARMONY_ACTIVITY_ON, new HarmonyActivityOnPayload(HarmonyAction.ACTIVITY_PLAYSTATION)),
      new Action(Domain.HARMONY_ACTIVITY_OFF, null));

  private Action onAction;
  private Action offAction;

  private SwitchAction(Action onAction, Action offAction) {
    this.onAction = onAction;
    this.offAction = offAction;
  }

  public Action getOnAction() {
    return onAction;
  }

  public Action getOffAction() {
    return offAction;
  }

}

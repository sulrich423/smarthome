package smarthome;

import smarthome.Action.Domain;
import smarthome.Action.Service;
import smarthome.service.device.HarmonyAction;
import smarthome.service.payload.HarmonyActivityPayload;
import smarthome.service.payload.HarmonyCommandPayload;

public enum SwitchAction {
  LIGHT(new Action(Domain.SHELL_COMMAND, Service.LIGHT_ON, null),
      new Action(Domain.SHELL_COMMAND, Service.LIGHT_OFF, null)), //

  CABIN_LIGHT(new Action(Domain.SHELL_COMMAND, Service.CABIN_LIGHT_ON, null),
      new Action(Domain.SHELL_COMMAND, Service.CABIN_LIGHT_OFF, null)), //

  TV_LIGHT(new Action(Domain.REMOTE, Service.SEND_COMMAND, new HarmonyCommandPayload(HarmonyAction.TV_LIGHT_POWERTOGGLE)),
      new Action(Domain.REMOTE, Service.SEND_COMMAND, new HarmonyCommandPayload(HarmonyAction.TV_LIGHT_POWERTOGGLE))), //

  PLAYSTATION(new Action(Domain.REMOTE, Service.TURN_ON, new HarmonyActivityPayload(HarmonyAction.ACTIVITY_PLAYSTATION)),
      new Action(Domain.REMOTE, Service.TURN_OFF, new HarmonyActivityPayload(HarmonyAction.ACTIVITY_PLAYSTATION))), //

  TAGESSCHAU(new Action(Domain.REMOTE, Service.TURN_ON, new HarmonyActivityPayload(HarmonyAction.ACTIVITY_TAGESSCHAU)),
      new Action(Domain.REMOTE, Service.TURN_OFF, new HarmonyActivityPayload(HarmonyAction.ACTIVITY_TAGESSCHAU)));

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

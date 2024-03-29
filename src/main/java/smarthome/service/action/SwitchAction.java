package smarthome.service.action;

import smarthome.service.ServiceCall;
import smarthome.service.ServiceCall.CgiScript;
import smarthome.service.constants.HarmonyPayloads;
import smarthome.service.constants.SocketPayloads;

public class SwitchAction implements Action {

  public static final SwitchAction LIGHT = new SwitchAction(
      new ServiceCall(CgiScript.SOCKET, SocketPayloads.LIGHT_ON),
      new ServiceCall(CgiScript.SOCKET, SocketPayloads.LIGHT_OFF));

  public static final SwitchAction CABIN_LIGHT = new SwitchAction(
      new ServiceCall(CgiScript.SOCKET, SocketPayloads.CABIN_LIGHT_ON),
      new ServiceCall(CgiScript.SOCKET, SocketPayloads.CABIN_LIGHT_OFF));

  public static final SwitchAction TV_LIGHT = new SwitchAction(
      new ServiceCall(CgiScript.HARMONY_COMMAND, HarmonyPayloads.TV_LIGHT_POWERTOGGLE),
      new ServiceCall(CgiScript.HARMONY_COMMAND, HarmonyPayloads.TV_LIGHT_POWERTOGGLE));

  public static final SwitchAction PLAYSTATION = new SwitchAction(
      new ServiceCall(CgiScript.HARMONY_ACTIVITY_ON, HarmonyPayloads.ACTIVITY_PLAYSTATION),
      new ServiceCall(CgiScript.HARMONY_ACTIVITY_OFF, null));

  public static final SwitchAction TAGESSCHAU = new SwitchAction(
      new ServiceCall(CgiScript.HARMONY_ACTIVITY_ON, HarmonyPayloads.ACTIVITY_TAGGESSCHAU),
      new ServiceCall(CgiScript.HARMONY_ACTIVITY_OFF, null));

  public static final SwitchAction SET_TOP_BOX = new SwitchAction(
      new ServiceCall(CgiScript.HARMONY_ACTIVITY_ON_OFF, HarmonyPayloads.SET_TOP_BOX_ON),
      new ServiceCall(CgiScript.VU_PLUS_OFF, null));

  private final ServiceCall onCall;
  private final ServiceCall offCall;

  private SwitchAction(ServiceCall onCall, ServiceCall offCall) {
    this.onCall = onCall;
    this.offCall = offCall;
  }

  @Override
  public ServiceCall getOnCall() {
    return onCall;
  }

  @Override
  public ServiceCall getOffCall() {
    return offCall;
  }

  @Override
  public ServiceCall getSetRangeCall(Integer value) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ServiceCall getAdjustRangeCall(Integer oldValue, Integer delta) {
    throw new UnsupportedOperationException();
  }

}

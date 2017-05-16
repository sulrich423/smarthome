package smarthome.service.action;

import smarthome.service.ServiceCall;
import smarthome.service.ServiceCall.CgiScript;
import smarthome.service.constants.HomematicPayloads;
import smarthome.service.constants.MovePayloads;
import smarthome.service.creator.HomematicSetPercentageCallCreator;
import smarthome.service.creator.MoveSetPercentageCallCreator;
import smarthome.service.creator.SetPercentageCallCreator;

public class BlindAction implements Action {

  public static final BlindAction BLIND_PATIO = new BlindAction(
      new ServiceCall(CgiScript.HOMEMATIC, HomematicPayloads.BLINDS_ON),
      new ServiceCall(CgiScript.HOMEMATIC, HomematicPayloads.BLINDS_OFF),
      new HomematicSetPercentageCallCreator());

  public static final BlindAction BLIND_WINDOW = new BlindAction(
      new ServiceCall(CgiScript.MOVE, MovePayloads.BLINDS_ON),
      new ServiceCall(CgiScript.MOVE, MovePayloads.BLINDS_OFF),
      new MoveSetPercentageCallCreator());

  private final ServiceCall onCall;
  private final ServiceCall offCall;
  private final SetPercentageCallCreator setPercentageCallCreator;

  private BlindAction(ServiceCall onCall, ServiceCall offCall, SetPercentageCallCreator setPercentageCallCreator) {
    this.onCall = onCall;
    this.offCall = offCall;
    this.setPercentageCallCreator = setPercentageCallCreator;
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
  public ServiceCall getSetPercentageCall(double value) {
    return setPercentageCallCreator.create(value);
  }
}

package smarthome.service.action;

import smarthome.service.ServiceCall;
import smarthome.service.creator.HomematicPercentageConverter;
import smarthome.service.creator.PercentageConverter;

public class BlindAction implements Action {

  public static final BlindAction BLIND_PATIO = new BlindAction(
      new HomematicPercentageConverter());

  private final PercentageConverter percentageConverter;

  private BlindAction(PercentageConverter percentageConverter) {
    this.percentageConverter = percentageConverter;
  }

  @Override
  public ServiceCall getOnCall() {
    throw new UnsupportedOperationException();
  }

  @Override
  public ServiceCall getOffCall() {
    throw new UnsupportedOperationException();
  }

  @Override
  public ServiceCall getSetRangeCall(Integer value) {
    return percentageConverter.set(value);
  }

  @Override
  public ServiceCall getAdjustRangeCall(Integer oldValue, Integer delta) {
    return percentageConverter.adjust(oldValue, delta);
  }
}

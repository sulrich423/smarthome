package smarthome.service.action;

import smarthome.service.ServiceCall;

public interface Action {

  public ServiceCall getOnCall();

  public ServiceCall getOffCall();

  public ServiceCall getSetRangeCall(Integer value);

  public ServiceCall getAdjustRangeCall(Integer oldValue, Integer delta);

}

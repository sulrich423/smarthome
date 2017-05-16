package smarthome.service.action;

import smarthome.service.ServiceCall;

public interface Action {

  public ServiceCall getOnCall();

  public ServiceCall getOffCall();

  public ServiceCall getSetPercentageCall(double value);

}

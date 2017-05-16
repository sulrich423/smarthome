package smarthome.service.creator;

import smarthome.service.ServiceCall;

public interface SetPercentageCallCreator {

  public ServiceCall create(double value);

}

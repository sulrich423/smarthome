package smarthome.service.creator;

import smarthome.service.ServiceCall;

public interface PercentageConverter {

  public ServiceCall set(Integer value);

  public ServiceCall adjust(Integer oldValue, Integer delta);

}

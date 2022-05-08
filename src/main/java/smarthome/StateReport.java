package smarthome;

import smarthome.alexa.Instance;
import smarthome.alexa.Interface;
import smarthome.alexa.PropertyName;
import smarthome.service.ServiceCall;
import smarthome.service.ServiceCall.CgiScript;

public class StateReport {

  public static final StateReport HOMEMATIC = new StateReport(Interface.ALEXA_RANGE_CONTROLLER,
      Instance.BLIND_LIFT, PropertyName.RANGE_VALUE,
      new HomematicStateValueConverter(),
      new ServiceCall(CgiScript.HOMEMATIC_STATE, null));

  private Interface _interface;
  private Instance instance;
  private PropertyName retrievableProperty;
  private StateValueConverter stateValueConverter;
  private ServiceCall serviceCall;

  public StateReport(Interface _interface, Instance instance, PropertyName retrievableProperty,
      StateValueConverter stateValueConverter, ServiceCall serviceCall) {
    this._interface = _interface;
    this.instance = instance;
    this.retrievableProperty = retrievableProperty;
    this.stateValueConverter = stateValueConverter;
    this.serviceCall = serviceCall;
  }

  public Interface getInterface() {
    return _interface;
  }

  public Instance getInstance() {
    return instance;
  }

  public PropertyName getRetrievableProperty() {
    return retrievableProperty;
  }

  public Integer requestState() {
    String rawResult = new StateReportRequester().requestState(serviceCall);
    return stateValueConverter.convert(rawResult);
  }

}

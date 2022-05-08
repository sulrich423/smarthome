package smarthome.service;

import smarthome.Configuration;
import smarthome.service.payload.Payload;

public class ServiceCall {

  private final String url;
  private final Payload payload;

  public ServiceCall(CgiScript cgiScript, Payload payload) {
    this.url = Configuration.BASEURL + cgiScript.toString();
    this.payload = payload;
  }

  public String getUrl() {
    return url;
  }

  public Payload getPayload() {
    return payload;
  }

  public enum CgiScript {
    SOCKET, //
    HARMONY_COMMAND, //
    HARMONY_ACTIVITY_ON, //
    HARMONY_ACTIVITY_OFF, //
    HARMONY_ACTIVITY_ON_OFF, //
    HOMEMATIC_STATE, //
    HOMEMATIC_STATECHANGE, //
    VU_PLUS_OFF;

    @Override
    public String toString() {
      return name().toLowerCase();
    }
  }

}

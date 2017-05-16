package smarthome.service.constants;

import smarthome.service.payload.SocketPayload;

public class SocketPayloads {

  public static final SocketPayload LIGHT_ON = new SocketPayload("1", "1");
  public static final SocketPayload LIGHT_OFF = new SocketPayload("1", "0");
  public static final SocketPayload CABIN_LIGHT_ON = new SocketPayload("2", "1");
  public static final SocketPayload CABIN_LIGHT_OFF = new SocketPayload("2", "0");

}

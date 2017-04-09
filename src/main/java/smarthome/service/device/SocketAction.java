package smarthome.service.device;

public class SocketAction {

  public static final SocketAction LIGHT_ON = new SocketAction("1", "1");
  public static final SocketAction LIGHT_OFF = new SocketAction("1", "0");
  public static final SocketAction CABIN_LIGHT_ON = new SocketAction("2", "1");
  public static final SocketAction CABIN_LIGHT_OFF = new SocketAction("2", "0");

  private final String unitCode;

  private final String command;

  public SocketAction(String unitCode, String command) {
    this.unitCode = unitCode;
    this.command = command;
  }

  public String getUnitCode() {
    return unitCode;
  }

  public String getCommand() {
    return command;
  }

}

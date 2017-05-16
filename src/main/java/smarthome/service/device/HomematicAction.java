package smarthome.service.device;

public class HomematicAction {

  public static final HomematicAction BLINDS_ON = new HomematicAction("0");
  public static final HomematicAction BLINDS_OFF = new HomematicAction("1");

  private final String position;

  public HomematicAction(String position) {
    this.position = position;
  }

  public String getPosition() {
    return position;
  }

}

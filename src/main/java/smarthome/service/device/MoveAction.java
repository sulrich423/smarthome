package smarthome.service.device;

public class MoveAction {

  public static final MoveAction BLINDS_ON = new MoveAction("255");
  public static final MoveAction BLINDS_OFF = new MoveAction("0");

  private final String position;

  public MoveAction(String position) {
    this.position = position;
  }

  public String getPosition() {
    return position;
  }

}

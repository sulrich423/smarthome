package smarthome.service.device;

public class HarmonyAction {

  public static final HarmonyAction TV_LIGHT_POWERTOGGLE = new HarmonyAction("remote.Bedroom", "43124579", "PowerToggle");
  public static final HarmonyAction ACTIVITY_PLAYSTATION = new HarmonyAction("remote.Bedroom", "25273971");
  public static final HarmonyAction ACTIVITY_TAGESSCHAU = new HarmonyAction("remote.Bedroom", "25267422");

  private final String entityId;

  private final String device;

  private final String command;

  private final String activity;

  public HarmonyAction(String entityId, String activity) {
    this.entityId = entityId;
    this.activity = activity;
    this.device = null;
    this.command = null;
  }

  public HarmonyAction(String entityId, String device, String command) {
    this.entityId = entityId;
    this.device = device;
    this.command = command;
    this.activity = null;
  }

  public String getEntityId() {
    return entityId;
  }

  public String getDevice() {
    return device;
  }

  public String getCommand() {
    return command;
  }

  public String getActivity() {
    return activity;
  }

}

package smarthome.service.device;

public class HarmonyAction {

  public static final HarmonyAction TV_LIGHT_POWERTOGGLE = new HarmonyAction("remote.Bedroom", "43124579", "PowerToggle");

  private final String entityId;

  private final String device;

  private final String command;

  public HarmonyAction(String entityId, String device, String command) {
    this.entityId = entityId;
    this.device = device;
    this.command = command;
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
}

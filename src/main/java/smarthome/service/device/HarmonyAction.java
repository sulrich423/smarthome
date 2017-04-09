package smarthome.service.device;

public class HarmonyAction {

  public static final HarmonyAction TV_LIGHT_POWERTOGGLE = new HarmonyAction("43124579", "PowerToggle");
  public static final HarmonyAction ACTIVITY_PLAYSTATION = new HarmonyAction("25273971");

  private final String device;

  private final String command;

  private final String activity;

  public HarmonyAction(String activity) {
    this.activity = activity;
    this.device = null;
    this.command = null;
  }

  public HarmonyAction(String device, String command) {
    this.device = device;
    this.command = command;
    this.activity = null;
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

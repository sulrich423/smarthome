package smarthome;

import smarthome.service.payload.Payload;

public class Action {

  private static final String SERVICE_PREFIX = "https://replaceWithYourServiceUrl.org/api/services/";
  private static final String PASSWORD_SUFFIX = "?api_password=replaceWithYourPassword";
  private static final String PATH_SEPARATOR = "/";

  private final String url;
  private final Object payload;

  public Action(Domain domain, Service service, Payload payload) {
    this.url = SERVICE_PREFIX + domain.getKey() + PATH_SEPARATOR + service.getKey() + PASSWORD_SUFFIX;
    this.payload = payload;
  }

  public String getUrl() {
    return url;
  }

  public Object getPayload() {
    return payload;
  }

  public enum Domain {
    REMOTE("remote"), //
    SHELL_COMMAND("shell_command");

    private String key;

    private Domain(String key) {
      this.key = key;
    }

    public String getKey() {
      return key;
    }
  }

  public enum Service {
    LIGHT_ON("light_on"), //
    LIGHT_OFF("light_off"), //
    CABIN_LIGHT_ON("cabin_light_on"), //
    CABIN_LIGHT_OFF("cabin_light_off"), //
    SEND_COMMAND("send_command"), //
    TURN_ON("turn_on"), //
    TURN_OFF("turn_off");

    private String key;

    private Service(String key) {
      this.key = key;
    }

    public String getKey() {
      return key;
    }
  }
}

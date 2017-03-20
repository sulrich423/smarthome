package smarthome;

public class Service {

  private static final String SERVICE_PREFIX = "https://replaceWithYourServiceUrl.org/api/services/";
  private static final String PASSWORD_SUFFIX = "?api_password=replaceWithYourPassword";

  private final String url;
  private final Object payload;

  public Service(String command, Object payload) {
    this.url = SERVICE_PREFIX + command + PASSWORD_SUFFIX;
    this.payload = payload;
  }

  public String getUrl() {
    return url;
  }

  public Object getPayload() {
    return payload;
  }
}

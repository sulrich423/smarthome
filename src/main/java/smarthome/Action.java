package smarthome;

import smarthome.service.payload.Payload;

public class Action {

  private final String url;
  private final Payload payload;

  public Action(Domain domain, Payload payload) {
    this.url = Configuration.BASEURL + domain.getVal();
    this.payload = payload;
  }

  public String getUrl() {
    return url;
  }

  public Payload getPayload() {
    return payload;
  }

  public enum Domain {
    SOCKET("socket"), //
    HARMONY_COMMAND("harmony_command"), //
    HARMONY_ACTIVITY_ON("harmony_activity_on"), //
    HARMONY_ACTIVITY_OFF("harmony_activity_off"), //
    BLIND_WINDOW("move"), //
    BLIND_PATIO("homematic");

    private String val;

    private Domain(String val) {
      this.val = val;
    }

    public String getVal() {
      return val;
    }
  }

}

package smarthome;

import smarthome.service.payload.Payload;

public class Action {

  private final String url;
  private final Object payload;

  public Action(Domain domain, Payload payload) {
    this.url = Configuration.BASEURL + domain.getVal();
    this.payload = payload;
  }

  public String getUrl() {
    return url;
  }

  public Object getPayload() {
    return payload;
  }

  public enum Domain {
    SOCKET("socket"), //
    HARMONY_COMMAND("harmony_command"), //
    HARMONY_ACTIVITY_ON("harmony_activity_on"), //
    HARMONY_ACTIVITY_OFF("harmony_activity_off");

    private String val;

    private Domain(String val) {
      this.val = val;
    }

    public String getVal() {
      return val;
    }
  }

}

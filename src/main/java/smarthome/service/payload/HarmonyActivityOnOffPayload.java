package smarthome.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
public class HarmonyActivityOnOffPayload implements Payload {

  @JsonProperty("activity")
  private String activity;

  @JsonProperty("sleep")
  private String sleep;

  public HarmonyActivityOnOffPayload(String activity, String sleep) {
    this.activity = activity;
    this.sleep = sleep;
  }

}

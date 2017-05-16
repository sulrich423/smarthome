package smarthome.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
public class HarmonyActivityOnPayload implements Payload {

  @JsonProperty("activity")
  private String activity;

  public HarmonyActivityOnPayload(String activity) {
    this.activity = activity;
  }

}

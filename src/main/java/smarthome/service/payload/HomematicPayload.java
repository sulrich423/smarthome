package smarthome.service.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
public class HomematicPayload implements Payload {

  @JsonProperty("position")
  private String position;

  public HomematicPayload(String position) {
    this.position = position;
  }

}

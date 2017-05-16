package smarthome.alexa.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Header;

@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetPercentageRequest {

  @JsonProperty("header")
  private Header header;

  @JsonProperty("payload")
  private Payload payload;

  public Header getHeader() {
    return header;
  }

  public Payload getPayload() {
    return payload;
  }

  @JsonPropertyOrder(alphabetic = true)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Payload {

    @JsonProperty("accessToken")
    private String accessToken;

    @JsonProperty("appliance")
    private Appliance appliance;

    @JsonProperty("percentageState")
    private PercentageState percentageState;

    public String getAccessToken() {
      return accessToken;
    }

    public Appliance getAppliance() {
      return appliance;
    }

    public PercentageState getPercentageState() {
      return percentageState;
    }

    @JsonPropertyOrder(alphabetic = true)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Appliance {

      @JsonProperty("additionalApplianceDetails")
      private AdditionalApplianceDetails additionalApplianceDetails;

      @JsonProperty("applianceId")
      private String applianceId;

      public AdditionalApplianceDetails getAdditionalApplianceDetails() {
        return additionalApplianceDetails;
      }

      public String getApplianceId() {
        return applianceId;
      }

      @JsonPropertyOrder(alphabetic = true)
      @JsonIgnoreProperties(ignoreUnknown = true)
      public static class AdditionalApplianceDetails {

      }
    }

    @JsonPropertyOrder(alphabetic = true)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PercentageState {

      @JsonProperty("value")
      private double value;

      public double getValue() {
        return value;
      }
    }
  }

}

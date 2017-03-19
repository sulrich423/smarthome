package smarthome.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.Header;

@JsonPropertyOrder(alphabetic = true)
public class DiscoverAppliancesResponse {

  @JsonProperty("header")
  private Header header;

  @JsonProperty("payload")
  private Payload payload;

  public DiscoverAppliancesResponse(Payload payload) {
    this.header = new Header("DiscoverAppliancesResponse", "Alexa.ConnectedHome.Discovery");
    this.payload = payload;
  }

  @JsonPropertyOrder(alphabetic = true)
  public static class Payload {

    @JsonProperty("discoveredAppliances")
    private List<DiscoveredAppliances> discoveredAppliances;

    public Payload(List<DiscoveredAppliances> discoveredAppliances) {
      this.discoveredAppliances = discoveredAppliances;
    }

    @JsonPropertyOrder(alphabetic = true)
    public static class DiscoveredAppliances {

      @JsonProperty("actions")
      private List<String> actions;

      @JsonProperty("additionalApplianceDetails")
      private AdditionalApplianceDetails additionalApplianceDetails;

      @JsonProperty("applianceId")
      private String applianceId;

      @JsonProperty("friendlyDescription")
      private String friendlyDescription;

      @JsonProperty("friendlyName")
      private String friendlyName;

      @JsonProperty("isReachable")
      private boolean isReachable;

      @JsonProperty("manufacturerName")
      private String manufacturerName;

      @JsonProperty("modelName")
      private String modelName;

      @JsonProperty("version")
      private String version;

      public DiscoveredAppliances(List<String> actions, String applianceId, String friendlyDescription, String friendlyName) {
        this.actions = actions;
        this.applianceId = applianceId;
        this.friendlyDescription = friendlyDescription;
        this.friendlyName = friendlyName;
        this.isReachable = true;
        this.additionalApplianceDetails = new AdditionalApplianceDetails();
        this.manufacturerName = "manufacturerName";
        this.modelName = "modelName";
        this.version = "version";
      }

      public String getApplianceId() {
        return applianceId;
      }

      @JsonPropertyOrder(alphabetic = true)
      public static class AdditionalApplianceDetails {
      }
    }
  }
}

package smarthome.alexa.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import smarthome.alexa.Header;
import smarthome.alexa.response.DiscoverResponse.Event.Payload;

@JsonPropertyOrder(alphabetic = true)
public class DiscoverResponse {

  @JsonProperty("event")
  private Event event;

  public DiscoverResponse(Payload payload) {
    this.event = new Event(payload);
  }

  @JsonPropertyOrder(alphabetic = true)
  public static class Event {

    @JsonProperty("header")
    private Header header;

    @JsonProperty("payload")
    private Payload payload;

    public Event(Payload payload) {
      this.header = new Header("Discover.Response", "Alexa.Discovery");
      this.payload = payload;
    }

    @JsonPropertyOrder(alphabetic = true)
    public static class Payload {

      @JsonProperty("endpoints")
      private List<Endpoints> endpoints;

      public Payload(List<Endpoints> endpoints) {
        this.endpoints = endpoints;
      }

      @JsonPropertyOrder(alphabetic = true)
      public static class Endpoints {

        @JsonProperty("endpointId")
        private String endpointId;

        @JsonProperty("manufacturerName")
        private String manufacturerName;

        @JsonProperty("friendlyName")
        private String friendlyName;

        @JsonProperty("description")
        private String description;

        @JsonProperty("displayCategories")
        private List<String> displayCategories;

        @JsonProperty("cookie")
        private Cookie cookie;

        @JsonProperty("capabilities")
        private List<Capability> capabilities;

        public Endpoints(List<Capability> capabilities, String endpointId, String friendlyName, String description,
            List<String> displayCategories) {
          this.capabilities = capabilities;
          this.endpointId = endpointId;
          this.description = description;
          this.friendlyName = friendlyName;
          this.cookie = new Cookie();
          this.manufacturerName = "Raspberry Pi";
          this.displayCategories = displayCategories;
        }

        public String getEndpointId() {
          return endpointId;
        }

        @JsonPropertyOrder(alphabetic = true)
        public static class Cookie {
        }

        @JsonPropertyOrder(alphabetic = true)
        public static class Capability {

          @JsonProperty("type")
          private String type;

          @JsonProperty("interface")
          private String _interface;

          @JsonProperty("version")
          private String version;

          public Capability(String _interface) {
            this._interface = _interface;
            this.type = "AlexaInterface";
            this.version = "3";
          }

        }
      }
    }
  }
}
package smarthome.alexa.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import smarthome.alexa.DirectiveName;
import smarthome.alexa.Header;
import smarthome.alexa.Instance;
import smarthome.alexa.Interface;
import smarthome.alexa.PropertyName;
import smarthome.alexa.Semantics;
import smarthome.alexa.response.DiscoverResponse.Event.Payload;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint.Capability.CapabilityResources.AssetLabel.AssetValue.AssetId;

@JsonPropertyOrder(alphabetic = true)
public class DiscoverResponse {

  @JsonProperty
  private Event event;

  public DiscoverResponse(Payload payload) {
    this.event = new Event(payload);
  }

  @JsonPropertyOrder(alphabetic = true)
  public static class Event {

    @JsonProperty
    private Header header;
    @JsonProperty
    private Payload payload;

    public Event(Payload payload) {
      this.header = new Header(Interface.ALEXA_DISCOVERY, DirectiveName.DISCOVER_RESPONSE);
      this.payload = payload;
    }

    @JsonPropertyOrder(alphabetic = true)
    public static class Payload {

      @JsonProperty
      private List<Endpoint> endpoints;

      public Payload(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
      }

      @JsonPropertyOrder(alphabetic = true)
      public static class Endpoint {

        @JsonProperty
        private String endpointId;
        @JsonProperty
        private String manufacturerName;
        @JsonProperty
        private String friendlyName;
        @JsonProperty
        private String description;
        @JsonProperty
        private List<DisplayCategory> displayCategories;
        @JsonProperty
        private Cookie cookie;
        @JsonProperty
        private List<Capability> capabilities;

        public Endpoint(List<Capability> capabilities, String endpointId, String friendlyName, String description,
            List<DisplayCategory> displayCategories) {
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

        public enum DisplayCategory {
          EXTERIOR_BLIND,
          INTERIOR_BLIND,
          STREAMING_DEVICE,
          GAME_CONSOLE,
          LIGHT,
          OTHER
        }

        @JsonPropertyOrder(alphabetic = true)
        public static class Cookie {
        }

        @JsonPropertyOrder(alphabetic = true)
        @JsonInclude(Include.NON_NULL)
        public static class Capability {

          @JsonProperty
          private String type;
          @JsonProperty("interface")
          private Interface _interface;
          @JsonProperty
          private Instance instance;
          @JsonProperty
          private String version;
          @JsonProperty
          private Properties properties;
          @JsonProperty
          private CapabilityResources capabilityResources;
          @JsonProperty
          private Configuration configuration;
          @JsonProperty
          private Semantics semantics;

          public Capability(Interface _interface) {
            this(_interface, null, null, null, null, null);
          }

          public Capability(Interface _interface, Instance instance, Properties properties,
              CapabilityResources capabilityResources,
              Configuration configuration, Semantics semantics) {
            this.type = "AlexaInterface";
            this.version = "3";
            this._interface = _interface;
            this.instance = instance;
            this.properties = properties;
            this.capabilityResources = capabilityResources;
            this.configuration = configuration;
            this.semantics = semantics;
          }

          @JsonPropertyOrder(alphabetic = true)
          public static class Properties {

            @JsonProperty
            private List<Supported> supported;
            @JsonProperty
            private boolean proactivelyReported;
            @JsonProperty
            private boolean retrievable;

            public Properties(List<Supported> supported, boolean proactivelyReported, boolean retrievable) {
              this.supported = supported;
              this.proactivelyReported = proactivelyReported;
              this.retrievable = retrievable;
            }

            @JsonPropertyOrder(alphabetic = true)
            public static class Supported {

              @JsonProperty
              private PropertyName name;

              public Supported(PropertyName name) {
                this.name = name;
              }

            }

          }

          @JsonPropertyOrder(alphabetic = true)
          public static class CapabilityResources {

            @JsonProperty
            private List<Label> friendlyNames;

            public CapabilityResources(List<Label> friendlyNames) {
              this.friendlyNames = friendlyNames;
            }

            public interface Label {

              @JsonProperty("@type")
              public String getType();

            }

            @JsonPropertyOrder(alphabetic = true)
            public static class AssetLabel implements Label {

              @JsonProperty
              private AssetValue value;

              public AssetLabel(AssetId assetId) {
                this.value = new AssetValue(assetId);
              }

              @Override
              public String getType() {
                return "asset";
              }

              @JsonPropertyOrder(alphabetic = true)
              public static class AssetValue {

                @JsonProperty
                private AssetId assetId;

                public AssetValue(AssetId assetId) {
                  this.assetId = assetId;
                }

                public enum AssetId {

                  ALEXA_SETTING_OPENING("Alexa.Setting.Opening");

                  private String value;

                  private AssetId(String value) {
                    this.value = value;
                  }

                  @JsonValue
                  public String getValue() {
                    return value;
                  }
                }

              }

            }

            @JsonPropertyOrder(alphabetic = true)
            public static class TextLabel implements Label {

              @JsonProperty
              private TextValue value;

              public TextLabel(TextValue value) {
                this.value = value;
              }

              @Override
              public String getType() {
                return "text";
              }

              @JsonPropertyOrder(alphabetic = true)
              public static class TextValue {

                @JsonProperty
                private String text;
                @JsonProperty
                private String locale;

                public TextValue(String text, String locale) {
                  this.text = text;
                  this.locale = locale;
                }

              }

            }

          }

          @JsonPropertyOrder(alphabetic = true)
          public static class Configuration {

            @JsonProperty
            private SupportedRange supportedRange;
            @JsonProperty
            private UnitOfMeasure unitOfMeasure;

            public Configuration(SupportedRange supportedRange, UnitOfMeasure unitOfMeasure) {
              this.supportedRange = supportedRange;
              this.unitOfMeasure = unitOfMeasure;
            }

            public enum UnitOfMeasure {
              ALEXA_UNIT_PERCENT("Alexa.Unit.Percent");

              private String value;

              private UnitOfMeasure(String value) {
                this.value = value;
              }

              @JsonValue
              public String getValue() {
                return value;
              }
            }

            @JsonPropertyOrder(alphabetic = true)
            public static class SupportedRange {

              @JsonProperty
              private Integer minimumValue;
              @JsonProperty
              private Integer maximumValue;
              @JsonProperty
              private Integer precision;

              public SupportedRange(Integer minimumValue, Integer maximumValue, Integer precision) {
                this.minimumValue = minimumValue;
                this.maximumValue = maximumValue;
                this.precision = precision;
              }
            }
          }
        }
      }
    }
  }
}
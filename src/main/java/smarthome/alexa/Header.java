package smarthome.alexa;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
public class Header {

  @JsonProperty("messageId")
  private String messageId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("namespace")
  private String namespace;

  @JsonProperty("payloadVersion")
  private String payloadVersion;

  @JsonProperty("correlationToken")
  private String correlationToken;

  public Header() {
  }

  public Header(String name, String namespace, String correlationToken) {
    this.messageId = UUID.randomUUID().toString();
    this.name = name;
    this.namespace = namespace;
    this.payloadVersion = "3";
    this.correlationToken = correlationToken;
  }

  public Header(String name, String namespace) {
    this(name, namespace, null);
  }

  public String getMessageId() {
    return messageId;
  }

  public String getName() {
    return name;
  }

  public String getNamespace() {
    return namespace;
  }

  public String getPayloadVersion() {
    return payloadVersion;
  }

  public String getCorrelationToken() {
    return correlationToken;
  }

}
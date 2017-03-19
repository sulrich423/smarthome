package smarthome;

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

  public Header() {
  }

  public Header(String messageId, String name, String namespace, String payloadVersion) {
    this.messageId = messageId;
    this.name = name;
    this.namespace = namespace;
    this.payloadVersion = payloadVersion;
  }

  public Header(String name, String namespace) {
    this.messageId = UUID.randomUUID().toString();
    this.name = name;
    this.namespace = namespace;
    this.payloadVersion = "2";
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

}
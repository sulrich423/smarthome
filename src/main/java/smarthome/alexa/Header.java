package smarthome.alexa;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
@JsonInclude(Include.NON_NULL)
public class Header {

  @JsonProperty
  private String messageId;
  @JsonProperty
  private DirectiveName name;
  @JsonProperty
  private Interface namespace;
  @JsonProperty
  private String instance;
  @JsonProperty
  private String payloadVersion;
  @JsonProperty
  private String correlationToken;

  public Header() {
  }

  public Header(Interface namespace, DirectiveName name, String correlationToken) {
    this.messageId = UUID.randomUUID().toString();
    this.namespace = namespace;
    this.name = name;
    this.payloadVersion = "3";
    this.correlationToken = correlationToken;
  }

  public Header(Interface namespace, DirectiveName name) {
    this(namespace, name, null);
  }

  public String getMessageId() {
    return messageId;
  }

  public DirectiveName getName() {
    return name;
  }

  public Interface getNamespace() {
    return namespace;
  }

  public String getInstance() {
    return instance;
  }

  public String getPayloadVersion() {
    return payloadVersion;
  }

  public String getCorrelationToken() {
    return correlationToken;
  }

}
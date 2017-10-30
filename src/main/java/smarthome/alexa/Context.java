package smarthome.alexa;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.collect.Lists;

@JsonPropertyOrder(alphabetic = true)
public class Context {

  @JsonProperty("properties")
  private List<Property> properties;

  public Context(String namespace, String name, String value) {
    this.properties = Lists.newArrayList(new Property(namespace, name, value));
  }

  @JsonPropertyOrder(alphabetic = true)
  public static class Property {

    @JsonProperty("namespace")
    private String namespace;

    @JsonProperty("name")
    private String name;

    @JsonProperty("value")
    private String value;

    @JsonProperty("timeOfSample")
    private String timeOfSample;

    @JsonProperty("uncertaintyInMilliseconds")
    private Integer uncertaintyInMilliseconds;

    public Property(String namespace, String name, String value) {
      this.namespace = namespace;
      this.name = name;
      this.value = value;
      this.timeOfSample = ZonedDateTime.now(Clock.systemUTC()).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
      this.uncertaintyInMilliseconds = 0;
    }

  }
}

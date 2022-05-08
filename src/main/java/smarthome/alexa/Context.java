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

  @JsonProperty
  private List<Property> properties;

  public Context(Interface namespace, PropertyName name, Instance instance, String value) {
    this.properties = Lists.newArrayList(new Property(namespace, name, instance, value));
  }

  public Context(Interface namespace, PropertyName name, String value) {
    this(namespace, name, null, value);
  }

  @JsonPropertyOrder(alphabetic = true)
  public static class Property {

    @JsonProperty
    private Interface namespace;
    @JsonProperty
    private PropertyName name;
    @JsonProperty
    private Instance instance;
    @JsonProperty
    private String value;
    @JsonProperty
    private String timeOfSample;
    @JsonProperty
    private Integer uncertaintyInMilliseconds;

    public Property(Interface namespace, PropertyName name, Instance instance, String value) {
      this.namespace = namespace;
      this.name = name;
      this.instance = instance;
      this.value = value;
      this.timeOfSample = ZonedDateTime.now(Clock.systemUTC()).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
      this.uncertaintyInMilliseconds = 0;
    }

  }
}

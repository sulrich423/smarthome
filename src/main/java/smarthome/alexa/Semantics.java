package smarthome.alexa;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import smarthome.alexa.request.AdjustRangeValueRequest.AdjustRangeValuePayload;
import smarthome.alexa.request.SetRangeValueRequest.SetRangeValuePayload;

@JsonPropertyOrder(alphabetic = true)
public class Semantics {

  @JsonProperty
  private List<ActionMapping> actionMappings;
  @JsonProperty
  private List<StateMapping> stateMappings;

  public Semantics(List<ActionMapping> actionMappings, List<StateMapping> stateMappings) {
    this.actionMappings = actionMappings;
    this.stateMappings = stateMappings;
  }

  @JsonPropertyOrder(alphabetic = true)
  public static class ActionMapping {

    @JsonProperty("@type")
    private String type;
    @JsonProperty
    private List<Action> actions;
    @JsonProperty
    private Directive directive;

    public ActionMapping(List<Action> actions, Directive directive) {
      this.type = "ActionsToDirective";
      this.actions = actions;
      this.directive = directive;
    }

    public enum Action {
      OPEN("Open"),
      CLOSE("Close"),
      RAISE("Raise"),
      LOWER("Lower"),
      SET_ECO_ON("SetEcoOn"),
      SET_ECO_OFF("SetEcoOff");

      private String value;

      private Action(String value) {
        this.value = value;
      }

      @JsonValue
      public String getValue() {
        return "Alexa.Actions." + value;
      }
    }

    public interface Directive {

      @JsonProperty
      public DirectiveName getName();

    }

    @JsonPropertyOrder(alphabetic = true)
    public static class SetRangeValueDirective implements Directive {

      @JsonProperty
      private SetRangeValuePayload payload;

      public SetRangeValueDirective(Integer rangeValue) {
        this.payload = new SetRangeValuePayload(rangeValue);
      }

      @Override
      public DirectiveName getName() {
        return DirectiveName.SET_RANGE_VALUE;
      }

    }

    @JsonPropertyOrder(alphabetic = true)
    public static class AdjustRangeValueDirective implements Directive {

      @JsonProperty
      private AdjustRangeValuePayload payload;

      public AdjustRangeValueDirective(Integer rangeValueDelta, Boolean rangeValueDeltaDefault) {
        this.payload = new AdjustRangeValuePayload(rangeValueDelta, rangeValueDeltaDefault);
      }

      @Override
      public DirectiveName getName() {
        return DirectiveName.ADJUST_RANGE_VALUE;
      }

    }

  }

  public interface StateMapping {

    @JsonProperty("@type")
    public String getType();

  }

  public enum State {
    OPEN("Open"),
    CLOSED("Closed"),
    ECO_ON("EcoOn"),
    ECO_OFF("EcoOff"),
    LOW("Low"),
    EMPTY("Empty"),
    FULL("Full"),
    DONE("Done"),
    STUCK("Stuck");

    private String value;

    private State(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return "Alexa.States." + value;
    }
  }

  @JsonPropertyOrder(alphabetic = true)
  public static class StateValueMapping implements StateMapping {

    @JsonProperty
    private List<State> states;
    @JsonProperty
    private Integer value;

    public StateValueMapping(List<State> states, Integer value) {
      this.states = states;
      this.value = value;
    }

    @Override
    public String getType() {
      return "StatesToValue";
    }

  }

  @JsonPropertyOrder(alphabetic = true)
  public static class StateRangeMapping implements StateMapping {

    @JsonProperty
    private List<State> states;
    @JsonProperty
    private Range range;

    public StateRangeMapping(List<State> states, Range range) {
      this.states = states;
      this.range = range;
    }

    @Override
    public String getType() {
      return "StatesToRange";
    }

    @JsonPropertyOrder(alphabetic = true)
    public static class Range {

      @JsonProperty
      private Integer minimumValue;
      @JsonProperty
      private Integer maximumValue;

      public Range(Integer minimumValue, Integer maximumValue) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
      }
    }
  }
}
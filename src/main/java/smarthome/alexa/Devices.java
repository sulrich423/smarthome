package smarthome.alexa;

import java.util.List;

import com.google.common.collect.Lists;

import smarthome.alexa.Semantics.ActionMapping;
import smarthome.alexa.Semantics.ActionMapping.Action;
import smarthome.alexa.Semantics.ActionMapping.AdjustRangeValueDirective;
import smarthome.alexa.Semantics.ActionMapping.SetRangeValueDirective;
import smarthome.alexa.Semantics.State;
import smarthome.alexa.Semantics.StateRangeMapping;
import smarthome.alexa.Semantics.StateRangeMapping.Range;
import smarthome.alexa.Semantics.StateValueMapping;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint.Capability;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint.Capability.CapabilityResources;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint.Capability.CapabilityResources.AssetLabel;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint.Capability.CapabilityResources.AssetLabel.AssetValue.AssetId;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint.Capability.Configuration;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint.Capability.Configuration.SupportedRange;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint.Capability.Configuration.UnitOfMeasure;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint.Capability.Properties;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint.Capability.Properties.Supported;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoint.DisplayCategory;

public class Devices {

  private static final List<Capability> SWITCH_ACTIONS = Lists.newArrayList(new Capability(Interface.ALEXA_POWER_CONTROLLER));
  private static final List<Capability> BLIND_ACTIONS = Lists.newArrayList(
      new Capability(Interface.ALEXA_RANGE_CONTROLLER, Instance.BLIND_LIFT,
          new Properties(Lists.newArrayList(new Supported(PropertyName.RANGE_VALUE)), false, true),
          new CapabilityResources(Lists.newArrayList(new AssetLabel(AssetId.ALEXA_SETTING_OPENING))),
          new Configuration(new SupportedRange(0, 100, 1), UnitOfMeasure.ALEXA_UNIT_PERCENT),
          new Semantics(Lists.newArrayList(
              new ActionMapping(Lists.newArrayList(Action.CLOSE), new SetRangeValueDirective(0)),
              new ActionMapping(Lists.newArrayList(Action.OPEN), new SetRangeValueDirective(100)),
              new ActionMapping(Lists.newArrayList(Action.LOWER), new AdjustRangeValueDirective(-10, false)),
              new ActionMapping(Lists.newArrayList(Action.RAISE), new AdjustRangeValueDirective(10, false))),
              Lists.newArrayList(
                  new StateValueMapping(Lists.newArrayList(State.CLOSED), 0),
                  new StateRangeMapping(Lists.newArrayList(State.OPEN), new Range(1, 100))))));

  public static final Endpoint LIGHT = new Endpoint(SWITCH_ACTIONS, "light", "Licht", "Deckenfluter",
      Lists.newArrayList(DisplayCategory.LIGHT));

  public static final Endpoint TV_LIGHT = new Endpoint(SWITCH_ACTIONS, "tvLight", "Fernsehlicht",
      "indirektes Licht hinter dem Fernseher und Schranklicht", Lists.newArrayList(DisplayCategory.LIGHT));

  public static final Endpoint PLAYSTATION = new Endpoint(SWITCH_ACTIONS, "playstation", "Playstation", "Playstation 5",
      Lists.newArrayList(DisplayCategory.GAME_CONSOLE));

  public static final Endpoint SET_TOP_BOX = new Endpoint(SWITCH_ACTIONS, "setTopBox", "Set top box",
      "VU+ Set-top Box von Deep Standby in Standby versetzen", Lists.newArrayList(DisplayCategory.STREAMING_DEVICE));

  public static final Endpoint BLIND_PATIO = new Endpoint(BLIND_ACTIONS, "blindPatio", "Rollladen",
      "Rollladen zur Terrasse", Lists.newArrayList(DisplayCategory.EXTERIOR_BLIND));

}

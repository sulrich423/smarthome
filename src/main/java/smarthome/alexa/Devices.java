package smarthome.alexa;

import java.util.List;

import com.google.common.collect.Lists;

import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoints;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoints.Capability;

public class Devices {

  private static final List<Capability> SWITCH_ACTIONS = Lists.newArrayList(new Capability("Alexa.PowerController"));
  private static final List<Capability> BLIND_ACTIONS = Lists.newArrayList(
      new Capability("Alexa.PowerController"), new Capability("Alexa.PercentageController"));

  public static final Endpoints LIGHT = new Endpoints(SWITCH_ACTIONS, "light", "Licht", "Deckenfluter",
      Lists.newArrayList("LIGHT"));

  public static final Endpoints TV_LIGHT = new Endpoints(SWITCH_ACTIONS, "tvLight", "Fernsehlicht",
      "indirektes Licht hinter dem Fernseher und Schranklicht", Lists.newArrayList("LIGHT"));

  public static final Endpoints PLAYSTATION = new Endpoints(SWITCH_ACTIONS, "playstation", "Playstation", "Playstation 4",
      Lists.newArrayList("OTHER"));

  public static final Endpoints SET_TOP_BOX = new Endpoints(SWITCH_ACTIONS, "setTopBox", "Set top box",
      "VU+ Set-top Box von Deep Standby in Standby versetzen", Lists.newArrayList("OTHER"));

  public static final Endpoints BLIND_WINDOW = new Endpoints(BLIND_ACTIONS, "blind_window", "Verdunklung Fenster",
      "Plissee Wohnzimmer", Lists.newArrayList("OTHER"));

  public static final Endpoints BLIND_PATIO = new Endpoints(BLIND_ACTIONS, "blind_patio", "Verdunklung Terrasse",
      "Rollladen zur Terrasse", Lists.newArrayList("OTHER"));

}

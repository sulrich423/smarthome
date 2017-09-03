package smarthome.alexa;

import java.util.List;

import com.google.common.collect.Lists;

import smarthome.alexa.response.DiscoverAppliancesResponse.Payload.DiscoveredAppliances;

public class Devices {

  private static final List<String> SWITCH_ACTIONS = Lists.newArrayList("turnOn", "turnOff");
  private static final List<String> BLIND_ACTIONS = Lists.newArrayList("turnOn", "turnOff", "setPercentage");

  public static final DiscoveredAppliances LIGHT = new DiscoveredAppliances(SWITCH_ACTIONS, "light", "Licht", "Deckenfluter");

  public static final DiscoveredAppliances TV_LIGHT = new DiscoveredAppliances(SWITCH_ACTIONS, "tvLight", "Fernsehlicht",
      "indirektes Licht hinter dem Fernseher und Schranklicht");

  public static final DiscoveredAppliances PLAYSTATION = new DiscoveredAppliances(SWITCH_ACTIONS, "playstation", "Playstation",
      "Playstation 4");

  public static final DiscoveredAppliances SET_TOP_BOX = new DiscoveredAppliances(SWITCH_ACTIONS, "setTopBox", "Set top box",
      "VU+ Set-top Box von Deep Standby in Standby versetzen");

  public static final DiscoveredAppliances BLIND_WINDOW = new DiscoveredAppliances(BLIND_ACTIONS, "blind_window",
      "Verdunklung Fenster", "Plissee Wohnzimmer");

  public static final DiscoveredAppliances BLIND_PATIO = new DiscoveredAppliances(BLIND_ACTIONS, "blind_patio",
      "Verdunklung Terrasse", "Rollladen zur Terrasse");

}

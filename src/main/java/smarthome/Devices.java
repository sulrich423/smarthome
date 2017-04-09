package smarthome;

import java.util.List;

import com.google.common.collect.Lists;

import smarthome.response.DiscoverAppliancesResponse.Payload.DiscoveredAppliances;

public class Devices {

  private static final List<String> SWITCH_ACTIONS = Lists.newArrayList("turnOn", "turnOff");

  public static final DiscoveredAppliances LIGHT = new DiscoveredAppliances(SWITCH_ACTIONS, "light", "Licht", "Deckenfluter");

  public static final DiscoveredAppliances TV_LIGHT = new DiscoveredAppliances(SWITCH_ACTIONS, "tvLight", "Fernsehlicht",
      "indirektes Licht hinter dem Fernseher und Schranklicht");

  public static final DiscoveredAppliances PLAYSTATION = new DiscoveredAppliances(SWITCH_ACTIONS, "playstation", "Playstation",
      "Playstation 4");

}

package smarthome;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import smarthome.response.DiscoverAppliancesResponse.Payload.DiscoveredAppliances;

public class Configuration {

  public static final List<DiscoveredAppliances> DISCOVERABLE_DEVICES = Lists.newArrayList(
      Devices.LIGHT,
      Devices.TV_LIGHT,
      Devices.PLAYSTATION,
      Devices.TAGESSCHAU);

  public static final Map<String, List<SwitchAction>> DEVICE_ACTION_MAPPING = ImmutableMap.<String, List<SwitchAction>>builder()
      .put(Devices.LIGHT.getApplianceId(), Lists.newArrayList(SwitchAction.LIGHT))
      .put(Devices.TV_LIGHT.getApplianceId(), Lists.newArrayList(SwitchAction.TV_LIGHT, SwitchAction.CABIN_LIGHT))
      .put(Devices.PLAYSTATION.getApplianceId(), Lists.newArrayList(SwitchAction.PLAYSTATION))
      .put(Devices.TAGESSCHAU.getApplianceId(), Lists.newArrayList(SwitchAction.TAGESSCHAU))
      .build();
}

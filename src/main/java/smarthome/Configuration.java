package smarthome;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import smarthome.alexa.Devices;
import smarthome.alexa.response.DiscoverResponse.Event.Payload.Endpoints;
import smarthome.service.action.Action;
import smarthome.service.action.BlindAction;
import smarthome.service.action.SwitchAction;

public class Configuration {

  public static final String BASEURL = "xxx";
  public static final String USERNAME = "xxx";
  public static final String PASSWORD = "xxx";

  public static final List<Endpoints> DISCOVERABLE_DEVICES = Lists.newArrayList(
      Devices.LIGHT,
      Devices.TV_LIGHT,
      Devices.PLAYSTATION,
      Devices.SET_TOP_BOX,
      Devices.BLIND_WINDOW,
      Devices.BLIND_PATIO);

  public static final Map<String, List<Action>> DEVICE_ACTION_MAPPING = new DeviceActionMappingBuilder()
      .put(Devices.LIGHT, SwitchAction.LIGHT)
      .put(Devices.TV_LIGHT, SwitchAction.TV_LIGHT, SwitchAction.CABIN_LIGHT)
      .put(Devices.PLAYSTATION, SwitchAction.PLAYSTATION)
      .put(Devices.SET_TOP_BOX, SwitchAction.SET_TOP_BOX)
      .put(Devices.BLIND_WINDOW, BlindAction.BLIND_WINDOW)
      .put(Devices.BLIND_PATIO, BlindAction.BLIND_PATIO)
      .build();

  private static class DeviceActionMappingBuilder {

    private Map<String, List<Action>> result = Maps.newHashMap();

    private DeviceActionMappingBuilder put(Endpoints device, Action... actions) {
      result.put(device.getEndpointId(), Lists.newArrayList(actions));
      return this;
    }

    private Map<String, List<Action>> build() {
      return result;
    }
  }
}

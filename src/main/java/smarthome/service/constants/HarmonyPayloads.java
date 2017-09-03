package smarthome.service.constants;

import smarthome.service.payload.HarmonyActivityOnOffPayload;
import smarthome.service.payload.HarmonyActivityOnPayload;
import smarthome.service.payload.HarmonyCommandPayload;

public class HarmonyPayloads {

  public static final HarmonyCommandPayload TV_LIGHT_POWERTOGGLE = new HarmonyCommandPayload("43124579", "PowerToggle");
  public static final HarmonyActivityOnPayload ACTIVITY_PLAYSTATION = new HarmonyActivityOnPayload("26678390");
  public static final HarmonyActivityOnOffPayload SET_TOP_BOX_ON = new HarmonyActivityOnOffPayload("28147317", "55");

}

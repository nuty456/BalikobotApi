package cz.balikobot.api.definitions;

import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * API versions.
 */
@Slf4j
public enum API {
  /**
   * APIv1 version 1
   */
  V1("v1"),

  /**
   * APIv1 version 2
   */
  V2("v2"),

  /**
   * APIv1 version 3
   */
  V3("v3"),

  /**
   * APIv2 version 1
   */
  V2V1("v2v1"),

  /**
   * APIv2 version 2
   */
  V2V2("v2v2");

  public final String label;

  API(String label) {
    this.label = label;
  }

  public static API valueOfLabel(String label) {
    for (API e : values()) {
      if (e.label.equals(label)) {
        return e;
      }
    }
    return null;
  }

  /**
   * API URL.
   */
  public static final HashMap<API, URL> URL = new HashMap<API, URL>() {{
    try {
      put(V1, new URL("https://api.balikobot.cz/"));
      put(V2, new URL("https://api.balikobot.cz/v2/"));
      put(V3, new URL("https://api.balikobot.cz/v3/"));
      put(V2V1, new URL("https://apiv2.balikobot.cz/"));
      put(V2V2, new URL("https://apiv2.balikobot.cz/v2/"));
    } catch (MalformedURLException e) {
      log.error(String.format("Exception: %s", e.getMessage()), e);
    }
  }};

}

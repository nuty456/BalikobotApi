package cz.balikobot.api.services;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;

/**
 * This class provides various methods for formatting response data.
 */
@Data
public class Formatter {
  /**
   * The Validator class provides methods for validating status codes and response data.
   */
  private Validator validator;

  /**
   * The Formatter class provides methods for formatting data.
   */
  public Formatter(Validator validator) {
    this.validator = validator;
  }

  /**
   * Normalize the response of tracked packages.
   *
   * @param response The response to be normalized.
   * @return The normalized response as an ArrayList of HashMaps.
   */
  public ArrayList<HashMap<Object, Object>> normalizeTrackPackagesResponse(ArrayList<HashMap<Object, Object>> response) {
    ArrayList<HashMap<Object, Object>> formattedResponse = new ArrayList();

    for (HashMap<Object, Object> responseItems : response) {

      ArrayList<HashMap<Object, Object>> resultS;
      if (responseItems.get("states") != null) {
        final Object resStates = responseItems.get("states");
        resultS = resStates != null ? (ArrayList<HashMap<Object, Object>>) resStates : new ArrayList<>();
      } else {
        resultS = new ArrayList<>();
      }

      for (HashMap<Object, Object> responseItem : resultS) {
        HashMap<Object, Object> item = new HashMap<>();
        item.put("date", responseItem.get("date"));
        item.put("name", responseItem.get("name"));
        if (responseItem.containsKey("status_id_v2")) {
          final Object statusIdV2 = responseItem.get("status_id_v2");
          if (statusIdV2 instanceof Double) {
            item.put("status_id", statusIdV2);
          } else if (statusIdV2 instanceof Integer) {
            item.put("status_id", new Double((Integer) statusIdV2));
          }
        } else {
          final Object statusId = responseItem.get("status_id");
          if (statusId instanceof Double) {
            item.put("status_id", statusId);
          } else if (statusId instanceof Integer) {
            item.put("status_id", new Double((Integer) statusId));
          }
        }
        item.put("type", responseItem.getOrDefault("type", "event"));
        item.put("name_internal", responseItem.containsKey("name_balikobot") ? responseItem.get("name_balikobot") : responseItem.get("name"));
        formattedResponse.add(item);
      }
    }

    return formattedResponse;
  }

  /**
   * Removes the "status" key from the provided HashMap.
   *
   * @param response The HashMap from which to remove the "status" key.
   * @return The modified HashMap without the "status" key.
   */
  public HashMap<Object, Object> withoutStatus(HashMap<Object, Object> response) {
    response.remove("status");

    return response;
  }

  /**
   * Normalize the response items by creating a HashMap with key-value pairs.
   *
   * @param items     The list of items to be normalized.
   * @param keyName   The key name used to retrieve the keys from the items.
   * @param valueName The value name used to retrieve the values from the items. Can be null.
   * @return The normalized response as a HashMap with key-value pairs.
   */
  public static HashMap<Object, Object> normalizeResponseItems(ArrayList<HashMap<Object, Object>> items, String keyName, String valueName) {
    final HashMap<Object, Object> formattedItems = new HashMap<>();
    for (HashMap<Object, Object> item : items) {
      if (valueName != null) {
        formattedItems.put(item.get(keyName), item.get(valueName) != null ? item.get(valueName) : item); //  [item[keyName]] =valueName != null ? item[valueName] : item;
      } else {
        formattedItems.put(item.get(keyName), item);
      }
    }

    return formattedItems;
  }
}

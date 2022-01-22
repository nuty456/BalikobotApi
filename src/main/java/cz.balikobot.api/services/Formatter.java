package cz.balikobot.api.services;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;

@Data
public class Formatter {
  /**
   * Response validator
   *
   * @var \Inspirum\Balikobot\Services\Validator
   */
  private Validator validator;

  /**
   * @param \Inspirum\Balikobot\Services\Validator validator
   */
  public Formatter(Validator validator) {
    this.validator = validator;
  }

  /**
   * Normalize "zipcodes" request response
   *
   * @param HashMap<Object, Object> response
   * @param |null        country
   *
   * @return ArrayList<ArrayList < String, mixed>>
   */
  // public ArrayList<> normalizePostCodesResponse(ArrayList<> response, String country = null)
  // {
  //   country = response.get("country") ?? country;
  //
  //   formattedResponse = new ArrayList();
  //
  //   for (response.get("zip_codes") ?? [] : responseItem) {
  //   formattedResponse[] = [
  //   "postcode"     => responseItem.get("zip") ?? (responseItem.get("zip_start") ?? null),
  //   "postcode_end" => responseItem.get("zip_end") ?? null,
  //       "city"         => responseItem.get("city") ?? null,
  //       "country"      => responseItem.get("country") ?? country,
  //       "1B"           => (Boolean) (responseItem.get("1B") ?? false),
  //           ];
  // }
  //
  //   return formattedResponse;
  // }

  /**
   * Normalize "trackstatus" request response
   *
   * @param HashMap<Object, Object> response
   *
   * @return ArrayList<ArrayList < String, Double | String | null>>
   *
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> normalizeTrackPackagesLastStatusResponse(HashMap<Object, Object> response)
  // {
  //   formattedResponse = new ArrayList();
  //
  //   for (response : responseItem) {
  //   this.validator.validateResponseStatus(responseItem, response);
  //
  //   formattedResponse[] = [
  //   "name"          => responseItem.get("status_text"),
  //       "name_internal" => responseItem.get("status_text"),
  //       "type"          => "event",
  //       "status_id"     => (Double) responseItem.get("status_id"),
  //       "date"          => null,
  //           ];
  // }
  //
  //   return formattedResponse;
  // }

  /**
   * Normalize "track" request response
   *
   * @param response
   * @return ArrayList<ArrayList < ArrayList < String, Double | String>>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public ArrayList<HashMap<Object, Object>> normalizeTrackPackagesResponse(ArrayList<HashMap<Object, Object>> response) {
    ArrayList<HashMap<Object, Object>> formattedResponse = new ArrayList();

    for (HashMap<Object, Object> responseItems : response) {
      // this.validator.validateResponseStatus(responseItems, response);

      // formattedResponse[i] = new ArrayList();

      ArrayList<HashMap<Object, Object>> resultS = new ArrayList<>();
      if (responseItems.get("states") != null) {
        final Object resStates = responseItems.get("states");
        resultS = resStates != null ? (ArrayList<HashMap<Object, Object>>) resStates : new ArrayList<>();
      } else {
        resultS = new ArrayList<>();
      }

      for (HashMap<Object, Object> responseItem : resultS) {

        // fix wrong API response https://github.com/inspirum/balikobot-php/issues/15 for PHP < 8.0
        // if (is_array<>(responseItem) == false || ArrayList<>_key_exists("name", responseItem) == false) {
        //   continue;
        // }

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
        item.put("type", responseItem.containsKey("type") ? responseItem.get("type") : "event");
        item.put("name_internal", responseItem.containsKey("name_balikobot") ? responseItem.get("name_balikobot") : responseItem.get("name"));
        formattedResponse.add(item);
      }
    }

    return formattedResponse;
  }

  /**
   * Normalize "pod" request response
   *
   * @param HashMap<Object, Object> response
   *
   * @return ArrayList<String>
   *
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> normalizeProofOfDeliveriesResponse(HashMap<Object, Object> response)
  // {
  //   formattedResponse = new ArrayList();
  //
  //   for (response : responseItem) {
  //   this.validator.validateResponseStatus(responseItem, response);
  //
  //   formattedResponse[] = responseItem.get("file_url");
  // }
  //
  //   return formattedResponse;
  // }

  /**
   * Unset "status" attribute
   *
   * @param response
   * @return HashMap<Object, Object>
   */
  public HashMap<Object, Object> withoutStatus(HashMap<Object, Object> response) {
    response.remove("status");

    return response;
  }

  /**
   * Normalize response items
   *
   * @param items
   * @param keyName
   * @param valueName
   * @return ArrayList<String, mixed>
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

  /**
   * Normalize response items indexed by group
   *
   * @param ArrayList<ArrayList<mixed>> items
   * @param               groupKeyName
   * @param               groupItemsKeyName
   * @param               keyName
   * @param |null         valueName
   *
   * @return ArrayList<String, ArrayList < String, mixed>>
   */
  // public ArrayList<> normalizeResponseIndexedItems(
  //     ArrayList<> items,
  //     String groupKeyName,
  //     String groupItemsKeyName,
  //     String keyName,
  //     String valueName
  // )  {
  //   formattedItems = new ArrayList();
  //
  //   for (items : item) {
  //     formattedItems[(String) item[groupKeyName]] = this.normalizeResponseItems(
  //         item[groupItemsKeyName] ?? [],
  //     keyName,
  //         valueName
  //           );
  //   }
  //
  //   return formattedItems;
  // }

  /**
   * Encapsulate ids with key
   *
   * @param ArrayList<int|String> ids
   * @param             keyName
   *
   * @return ArrayList<ArrayList < int | String>>
   */
  // public ArrayList<> encapsulateIds(ArrayList<> ids, String keyName)
  // {
  //   formattedItems = new ArrayList();
  //
  //   for (ids : id) {
  //   formattedItems[] = [keyName => id];
  // }
  //
  //   return formattedItems;
  // }
}

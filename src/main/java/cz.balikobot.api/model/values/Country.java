package cz.balikobot.api.model.values;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * A class representing a country.
 */
@Data
@AllArgsConstructor
public class Country {
  /**
   * Names.
   */
  private HashMap<String, String> names = new HashMap<>();

  /**
   * Alpha-2 country code.
   */
  private String code;

  /**
   * Continent name.
   */
  private String continent;

  /**
   * Phone prefixes.
   */
  private List<String> phonePrefixes;

  /**
   * Currency code.
   */
  private String currencyCode;


  /**
   * Retrieves the name of the country in the specified locale.
   *
   * @param locale The locale used to retrieve the country name
   * @return The name of the country in the specified locale
   */
  public String getName(String locale) {
    return this.names.get(locale);
  }

  /**
   * Retrieves the phone prefix of the country.
   *
   * @return The phone prefix of the country.
   */
  public String getPhonePrefix() {
    return this.phonePrefixes.get(0);
  }

  /**
   * Creates a new instance of the Country class using the provided data.
   *
   * @param data The data used to create the country instance. The data should be a HashMap with the following keys:
   *             - "name_cz": The name of the country in Czech language (String)
   *             - "name_en": The name of the country in English language (String)
   *             - "iso_code": The ISO code of the country (String)
   *             - "currency": The currency code of the country (String)
   *             - "phone_prefix": The phone prefix(es) of the country. This can be a single String or a List of Strings. (Object)
   *             - "continent": The name of the continent the country belongs to (String)
   * @return A new instance of the Country class initialized with the provided data.
   */
  public static Country newInstanceFromData(HashMap<Object, Object> data) {
    return new Country(
        new HashMap<String, String>() {{
          put("cs", (String) data.get("name_cz"));
          put("en", (String) data.get("name_en"));
        }},
        (String) data.get("iso_code"),
        (String) data.get("currency"),
        data.get("phone_prefix") != null ? (data.get("phone_prefix") instanceof ArrayList ? (ArrayList) data.get("phone_prefix") : Collections.singletonList((String) data.get("phone_prefix"))) : new ArrayList(),
        (String) data.get("continent")
    );
  }

}

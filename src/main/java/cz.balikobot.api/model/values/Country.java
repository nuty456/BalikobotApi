package cz.balikobot.api.model.values;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import lombok.Data;

@Data
public class Country {
  /**
   * Names
   */
  private HashMap<String, String> names = new HashMap<String, String>();

  /**
   * Alpha-2 country code
   */
  private String code;

  /**
   * Continent name
   */
  private String continent;

  /**
   * Phone prefixes
   */
  private List<String> phonePrefixes;

  /**
   * Currency code
   */
  private String currencyCode;

  /**
   * Country constructor
   *
   * @param names
   * @param code
   * @param currencyCode
   * @param phonePrefixes
   * @param continent
   */
  public Country(
      HashMap<String, String> names,
      String code,
      String currencyCode,
      List<String> phonePrefixes,
      String continent
  ) {
    this.names = names;
    this.code = code;
    this.currencyCode = currencyCode;
    this.phonePrefixes = phonePrefixes;
    this.continent = continent;
  }

  /**
   * @param locale
   * @return String|null
   */
  public String getName(String locale) {
    return this.names.get(locale);
  }

  /**
   * @return String
   */
  public String getPhonePrefix() {
    return this.phonePrefixes.get(0);
  }

  /**
   * @param data
   * @return \Inspirum\Balikobot\Model\Values\Country
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

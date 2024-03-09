package cz.balikobot.api.model.values;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

import cz.balikobot.api.definitions.ServiceType;
import cz.balikobot.api.definitions.Shipper;

/**
 * Represents a postal code information including shipper, service type, and other details.
 */
@Data
@AllArgsConstructor
public class PostCode {
  /**
   * Represents a shipper associated with a postal code.
   */
  private Shipper shipper;

  /**
   * Represents a service type associated with a postal code
   */
  private ServiceType service;

  /**
   * Represents a postal code.
   */
  private String postcode;

  /**
   * Represents the end postcode of a postal code.
   */
  private String postcodeEnd;

  /**
   * Represents the city associated with a postal code.
   */
  private String city;

  /**
   * Represents the country associated with a postal code.
   */
  private String country;

  /**
   * Represents whether morning delivery is available for a given postal code.
   */
  private Boolean morningDelivery;

  /**
   * Create a new instance of the PostCode class from the provided data.
   *
   * @param shipper The shipper object.
   * @param service The service type object.
   * @param data    The data used to create the PostCode object. It should be a HashMap where the keys are as follows:
   *                "postcode" - The postcode.
   *                "postcode_end" - The end postcode (optional).
   *                "city" - The city (optional).
   *                "country" - The country (optional).
   *                "1B" - The morning delivery flag (optional).
   * @return A new instance of the PostCode class.
   */
  public static PostCode newInstanceFromData(Shipper shipper, ServiceType service, HashMap<Object, Object> data) {
    return new PostCode(
        shipper,
        service,
        (String) data.get("postcode"),
        data.get("postcode_end") != null ? (String) data.get("postcode_end") : null,
        data.get("city") != null ? (String) data.get("city") : null,
        data.get("country") != null ? (String) data.get("country") : null,
        data.get("1B") != null && (Boolean) data.get("1B")
    );
  }
}

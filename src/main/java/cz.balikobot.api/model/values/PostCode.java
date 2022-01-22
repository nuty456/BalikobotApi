package cz.balikobot.api.model.values;

import java.util.HashMap;

import lombok.Data;

import cz.balikobot.api.definitions.ServiceType;
import cz.balikobot.api.definitions.Shipper;

@Data
public class PostCode {
  /**
   */
  private Shipper shipper;

  /**
   */
  private ServiceType service;

  /**
   */
  private String postcode;

  /**
   */
  private String postcodeEnd;

  /**
   */
  private String city;

  /**
   */
  private String country;

  /**
   */
  private Boolean morningDelivery;

  /**
   * Postcode constructor
   *
   * @param  shipper
   * @param  service
   * @param  postcode
   * @param  postcodeEnd
   * @param  city
   * @param  country
   * @param     morningDelivery
   */
  public PostCode(
      Shipper shipper,
      ServiceType service,
      String postcode,
      String postcodeEnd,
      String city,
      String country,
      Boolean morningDelivery
  ) {
    this.shipper         = shipper;
    this.service         = service;
    this.postcode        = postcode;
    this.postcodeEnd     = postcodeEnd;
    this.city            = city;
    this.country         = country;
    this.morningDelivery = morningDelivery;
  }

  /**
   * New instance from data
   *
   * @param  shipper
   * @param  service
   * @param  data
   *
   * @return \Inspirum\Balikobot\Model\Values\PostCode
   */
  public static PostCode newInstanceFromData(Shipper shipper, ServiceType service, HashMap<Object, Object> data)
  {
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

package cz.balikobot.api.model.values;

import cz.balikobot.api.definitions.ServiceType;
import cz.balikobot.api.definitions.Shipper;

import java.util.HashMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Branch {
  /**
   *
   */
  private Shipper shipper;

  /**
   * @var String|null
   */
  private ServiceType service;

  /**
   *
   */
  private String branchId;

  /**
   * @var String|null
   */
  private String id;

  /**
   * @var String|null
   */
  private String uid;

  /**
   *
   */
  private String type;

  /**
   *
   */
  private String name;

  /**
   *
   */
  private String city;

  /**
   *
   */
  private String street;

  /**
   *
   */
  private String zip;

  /**
   * @var String|null
   */
  private String cityPart;

  /**
   * @var String|null
   */
  private String district;

  /**
   * @var String|null
   */
  private String region;

  /**
   * ISO 3166-1 alpha-2 http://cs.wikipedia.org/wiki/ISO_3166-1
   *
   * @var String|null
   */
  private String country;

  /**
   * @var String|null
   */
  private String currency;

  /**
   * @var String|null
   */
  private String photoSmall;

  /**
   * @var String|null
   */
  private String photoBig;

  /**
   * @var String|null
   */
  private String url;

  /**
   * @var Double|null
   */
  private Double latitude;

  /**
   * @var Double|null
   */
  private Double longitude;

  /**
   * @var String|null
   */
  private String directionsGlobal;

  /**
   * @var String|null
   */
  private String directionsCar;

  /**
   * @var String|null
   */
  private String directionsPublic;

  /**
   * @var Boolean|null
   */
  private Boolean wheelchairAccessible;

  /**
   * @var Boolean|null
   */
  private Boolean claimAssistant;

  /**
   * @var Boolean|null
   */
  private Boolean dressingRoom;

  /**
   * @var String|null
   */
  private String openingMonday;

  /**
   * @var String|null
   */
  private String openingTuesday;

  /**
   * @var String|null
   */
  private String openingWednesday;

  /**
   * @var String|null
   */
  private String openingThursday;

  /**
   * @var String|null
   */
  private String openingFriday;

  /**
   * @var String|null
   */
  private String openingSaturday;

  /**
   * @var String|null
   */
  private String openingSunday;

  /**
   * @var Double|null
   */
  private Double maxWeight;

  /**
   * Branch constructor
   *
   * @param shipper
   * @param service
   * @param id
   * @param uid
   * @param type
   * @param name
   * @param city
   * @param street
   * @param zip
   */
  public Branch(
      Shipper shipper,
      ServiceType service,
      String id,
      String uid,
      String type,
      String name,
      String city,
      String street,
      String zip
  ) {
    this.shipper = shipper;
    this.service = service;
    this.id = id;
    this.uid = uid;
    this.type = type;
    this.name = name;
    this.city = city;
    this.street = street;
    this.zip = zip;
    this.branchId = this.resolveBranchId();
  }

  /**
   * Branch constructor
   *
   * @param shipper
   * @param service
   * @param id
   * @param uid
   * @param type
   * @param name
   * @param city
   * @param street
   * @param zip
   * @param country
   * @param cityPart
   * @param district
   * @param region
   * @param currency
   * @param photoSmall
   * @param photoBig
   * @param url
   * @param latitude
   * @param longitude
   * @param directionsGlobal
   * @param directionsCar
   * @param directionsPublic
   * @param wheelchairAccessible
   * @param claimAssistant
   * @param dressingRoom
   * @param openingMonday
   * @param openingTuesday
   * @param openingWednesday
   * @param openingThursday
   * @param openingFriday
   * @param openingSaturday
   * @param openingSunday
   * @param maxWeight
   */
  public Branch(
      Shipper shipper,
      ServiceType service,
      String id,
      String uid,
      String type,
      String name,
      String city,
      String street,
      String zip,
      String country,
      String cityPart,
      String district,
      String region,
      String currency,
      String photoSmall,
      String photoBig,
      String url,
      Double latitude,
      Double longitude,
      String directionsGlobal,
      String directionsCar,
      String directionsPublic,
      Boolean wheelchairAccessible,
      Boolean claimAssistant,
      Boolean dressingRoom,
      String openingMonday,
      String openingTuesday,
      String openingWednesday,
      String openingThursday,
      String openingFriday,
      String openingSaturday,
      String openingSunday,
      Double maxWeight
  ) {
    this.shipper = shipper;
    this.service = service;
    this.id = id;
    this.uid = uid;
    this.type = type;
    this.name = name;
    this.city = city;
    this.street = street;
    this.zip = zip;
    this.cityPart = cityPart;
    this.district = district;
    this.region = region;
    this.country = country;
    this.currency = currency;
    this.photoSmall = photoSmall;
    this.photoBig = photoBig;
    this.url = url;
    this.latitude = latitude;
    this.longitude = longitude;
    this.directionsGlobal = directionsGlobal;
    this.directionsCar = directionsCar;
    this.directionsPublic = directionsPublic;
    this.wheelchairAccessible = wheelchairAccessible;
    this.claimAssistant = claimAssistant;
    this.dressingRoom = dressingRoom;
    this.openingMonday = openingMonday;
    this.openingTuesday = openingTuesday;
    this.openingWednesday = openingWednesday;
    this.openingThursday = openingThursday;
    this.openingFriday = openingFriday;
    this.openingSaturday = openingSaturday;
    this.openingSunday = openingSunday;
    this.maxWeight = maxWeight;
    this.branchId = this.resolveBranchId();
  }

  /**
   * Resolve branch ID
   *
   * @return String
   */
  private String resolveBranchId() {
    // get key used in branch_id when calling add request
    if (
        this.shipper == Shipper.CP
            || this.shipper == Shipper.SP
            || (this.shipper == Shipper.ULOZENKA && this.service == ServiceType.ULOZENKA_CP_NP)
    ) {
      return this.zip.replace(" ", "");
    }

    if (this.shipper == Shipper.PPL) {
      return ((String) this.id).replace("KM", "");
    }

    if (this.shipper == Shipper.INTIME) {
      return this.name;
    }

    return (String) this.id;
  }

  /**
   * New instance from data
   *
   * @param shipper
   * @param service
   * @param data
   * @return \Inspirum\Balikobot\Model\Values\Branch
   */
  public static Branch newInstanceFromData(Shipper shipper, ServiceType service, HashMap<Object, Object> data) {
    if (shipper == Shipper.CP && service == ServiceType.CP_NP) {
      data.put("country", "CZ");
    }

    if (data.get("street") != null && (data.get("house_number") != null || data.get("orientation_number") != null)) {
      final Object houseNumberSource = data.get("house_number");
      Integer houseNumber = 0;
      try {
        if (houseNumberSource != null) {
          if (houseNumberSource instanceof Integer) {
            houseNumber = (int) houseNumberSource;
          } else if (houseNumberSource instanceof String) {
            houseNumber = Integer.parseInt((String) houseNumberSource);
          }
        }
      } catch (NumberFormatException e) {
        log.error(String.format("Exception: %s", e.getMessage()), e);
      }
      Integer orientationNumber = 0;
      try {
        final Object orientationNumberSource = data.get("orientation_number");
        if (orientationNumberSource != null) {
          if (orientationNumberSource instanceof Integer) {
            orientationNumber = (int) orientationNumberSource;
          } else if (orientationNumberSource instanceof String) {
            orientationNumber = Integer.parseInt((String) orientationNumberSource);
          }
        }
      } catch (NumberFormatException e) {
        log.error(String.format("Exception: %s", e.getMessage()), e);
      }
      String streetNumber = String.format("%s/%s", houseNumber > 0 ? houseNumber : "", orientationNumber > 0 ? orientationNumber : "").trim();
      data.put("street", String.format("%s %s", (data.get("street") != null ? data.get("street") : (data.get("city") != null ? data.get("city") : "")), streetNumber));
    }
    final Object latitudeSource = data.get("latitude");
    Double latitude = 0.0;
    try {
      if (latitudeSource != null) {
        if (latitudeSource instanceof Double) {
          latitude = (Double) latitudeSource;
        } else if (latitudeSource instanceof Integer) {
          latitude = new Double((Integer) latitudeSource);
        } else if (latitudeSource instanceof String) {
          latitude = Double.parseDouble((String) latitudeSource);
        }
      }
    } catch (Exception e) {
      log.error(String.format("Exception: %s", e.getMessage()), e);
    }
    final Object longitudeSource = data.get("longitude");
    Double longitude = 0.0;
    try {
      if (longitudeSource != null) {
        if (longitudeSource instanceof Double) {
          longitude = (Double) longitudeSource;
        } else if (longitudeSource instanceof Integer) {
          longitude = new Double((Integer) longitudeSource);
        } else if (longitudeSource instanceof String) {
          longitude = Double.parseDouble((String) longitudeSource);
        }
      }
    } catch (Exception e) {
      log.error(String.format("Exception: %s", e.getMessage()), e);
    }

    return new Branch(
        shipper,
        service,
        data.get("branch_id") != null ? (String) data.get("branch_id") : (data.get("id") != null ? (String) data.get("id") : null),
        (String) data.get("branch_uid"),
        data.get("type") != null ? (String) data.get("type") : "branch",
        data.get("name") != null ? (String) data.get("name") : (data.get("zip") != null ? (String) data.get("zip") : "00000"),
        data.get("city") != null ? (String) data.get("city") : "",
        data.get("street") != null ? (String) data.get("street") : (data.get("address") != null ? (String) data.get("address") : ""),
        data.get("zip") != null ? (String) data.get("zip") : "00000",
        (String) data.get("country"),
        (String) data.get("city_part"),
        (String) data.get("district"),
        (String) data.get("region"),
        (String) data.get("currency"),
        (String) data.get("photo_small"),
        (String) data.get("photo_big"),
        (String) data.get("url"),
        latitude,
        longitude,
        (String) data.get("directions_global"),
        (String) data.get("directions_car"),
        (String) data.get("directions_public"),
        data.get("wheelchair_accessible") != null ? ((Integer) data.get("wheelchair_accessible") == 1) : null,
        data.get("claim_assistant") != null ? ((Integer) data.get("claim_assistant") == 1) : null,
        data.get("dressing_room") != null ? ((Integer) data.get("dressing_room") == 1) : null,
        (String) data.get("opening_monday"),
        (String) data.get("opening_tuesday"),
        (String) data.get("opening_wednesday"),
        (String) data.get("opening_thursday"),
        (String) data.get("opening_friday"),
        (String) data.get("opening_saturday"),
        (String) data.get("opening_sunday"),
        data.get("max_weight") != null ? Double.parseDouble((String) data.get("max_weight")) : null
    );
  }

}

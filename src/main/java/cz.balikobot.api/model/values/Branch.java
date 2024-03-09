package cz.balikobot.api.model.values;

import cz.balikobot.api.definitions.ServiceType;
import cz.balikobot.api.definitions.Shipper;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * The Branch class represents a branch entity.
 * A branch is associated with a shipper and a service type.
 * It contains various properties such as its identifier, name, address, and opening hours.
 */
@Data
@Slf4j
@AllArgsConstructor
public class Branch {
  /**
   * The Shipper class represents a shipper entity.
   */
  private Shipper shipper;

  /**
   * Type of service.
   */
  private ServiceType service;

  /**
   * Represents the unique identifier of a branch.
   */
  private String branchId;

  /**
   * ID.
   */
  private String id;

  /**
   * UID.
   */
  private String uid;

  /**
   * Type.
   */
  private String type;

  /**
   * Name.
   */
  private String name;

  /**
   * City.
   */
  private String city;

  /**
   * Street.
   */
  private String street;

  /**
   * ZIP.
   */
  private String zip;

  /**
   * Represents a part of a city.
   */
  private String cityPart;

  /**
   * The district where an entity is located.
   */
  private String district;

  /**
   * This private variable represents a region.
   */
  private String region;

  /**
   * Represents the name of a country.
   * <p>
   * ISO 3166-1 alpha-2
   *
   * @see <a href="https://cs.wikipedia.org/wiki/ISO_3166-1">ISO_3166-1</a>
   */
  private String country;

  /**
   * Represents a currency.
   */
  private String currency;

  /**
   * The small photo of an object.
   * This variable stores the file path or URL of the small photo associated with the object.
   */
  private String photoSmall;

  /**
   * The variable to store the path of a large photo image.
   */
  private String photoBig;

  /**
   * The URL variable represents a private string that stores a URL.
   * It is used to reference and manipulate URLs in the software application.
   */
  private String url;

  /**
   * The latitude variable represents the latitude coordinate of a location.
   */
  private Double latitude;

  /**
   * Represents the longitude of a location.
   */
  private Double longitude;

  /**
   * The directionsGlobal variable represents the global directions. It is a private instance variable of type String.
   */
  private String directionsGlobal;

  /**
   * Represents the directions for a car.
   */
  private String directionsCar;

  /**
   * The directionsPublic variable stores the public directions.
   */
  private String directionsPublic;

  /**
   * Indicates whether a place is wheelchair accessible.
   */
  private Boolean wheelchairAccessible;

  /**
   * Represents the status of the claim assistant. It is a boolean value that indicates whether the claim assistant is available or not.
   */
  private Boolean claimAssistant;

  /**
   * The dressingRoom is a private variable indicating the availability of a dressing room.
   */
  private Boolean dressingRoom;

  /**
   * The openingMonday variable represents the opening hours on Monday in a string format.
   */
  private String openingMonday;

  /**
   * This private variable represents the opening hours on Tuesday.
   */
  private String openingTuesday;

  /**
   * The openingWednesday variable stores the opening hours for Wednesday as a String.
   */
  private String openingWednesday;

  /**
   * The openingThursday variable represents the opening hours on Thursday.
   */
  private String openingThursday;

  /**
   * The openingFriday variable represents the opening time on Fridays.
   */
  private String openingFriday;

  /**
   * The openingSaturday variable stores the opening hours for Saturdays.
   */
  private String openingSaturday;

  /**
   * The opening hours on Sunday.
   */
  private String openingSunday;

  /**
   * The maximum weight.
   */
  private Double maxWeight;

  /**
   * Constructs a new instance of the Branch class.
   *
   * @param shipper The shipper associated with the branch.
   * @param service The service type associated with the branch.
   * @param id      The identifier of the branch.
   * @param uid     The unique identifier of the branch.
   * @param type    The type of the branch.
   * @param name    The name of the branch.
   * @param city    The city where the branch is located.
   * @param street  The street address of the branch.
   * @param zip     The ZIP code of the branch.
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
   * Creates a new Branch object with the specified parameters.
   *
   * @param shipper              the shipper for the branch
   * @param service              the service type for the branch
   * @param id                   the ID of the branch
   * @param uid                  the UID of the branch
   * @param type                 the type of the branch
   * @param name                 the name of the branch
   * @param city                 the city where the branch is located
   * @param street               the street of the branch's address
   * @param zip                  the ZIP code of the branch's address
   * @param country              the country where the branch is located
   * @param cityPart             the city part where the branch is located
   * @param district             the district where the branch is located
   * @param region               the region where the branch is located
   * @param currency             the currency used at the branch
   * @param photoSmall           the URL of the small photo of the branch
   * @param photoBig             the URL of the big photo of the branch
   * @param url                  the URL of the branch's website
   * @param latitude             the latitude coordinate of the branch's location
   * @param longitude            the longitude coordinate of the branch's location
   * @param directionsGlobal     the global directions to the branch
   * @param directionsCar        the car directions to the branch
   * @param directionsPublic     the public transportation directions to the branch
   * @param wheelchairAccessible indicates if the branch is wheelchair accessible
   * @param claimAssistant       indicates if the branch has a claim assistant
   * @param dressingRoom         indicates if the branch has a dressing room
   * @param openingMonday        the opening hours on Mondays
   * @param openingTuesday       the opening hours on Tuesdays
   * @param openingWednesday     the opening hours on Wednesdays
   * @param openingThursday      the opening hours on Thursdays
   * @param openingFriday        the opening hours on Fridays
   * @param openingSaturday      the opening hours on Saturdays
   * @param openingSunday        the opening hours on Sundays
   * @param maxWeight            the maximum weight allowed at the branch
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
   * Resolves the branch ID based on the shipper and service type.
   *
   * @return The resolved branch ID.
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
      return this.id.replace("KM", "");
    }

    if (this.shipper == Shipper.INTIME) {
      return this.name;
    }

    return this.id;
  }

  /**
   * Creates a new instance of the Branch class from the given data.
   *
   * @param shipper the shipper of the branch
   * @param service the service type of the branch
   * @param data    the data used to construct the branch
   * @return a new instance of the Branch class
   */
  public static Branch newInstanceFromData(Shipper shipper, ServiceType service, HashMap<Object, Object> data) {
    if (shipper == Shipper.CP && service == ServiceType.CP_NP) {
      data.put("country", "CZ");
    }

    if (data.get("street") != null && (data.get("house_number") != null || data.get("orientation_number") != null)) {
      final Object houseNumberSource = data.get("house_number");
      int houseNumber = 0;
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
      int orientationNumber = 0;
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
    double latitude = 0.0;
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
    double longitude = 0.0;
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

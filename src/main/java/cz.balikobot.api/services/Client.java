package cz.balikobot.api.services;

import cz.balikobot.api.contracts.RequesterInterface;
import cz.balikobot.api.definitions.API;
import cz.balikobot.api.definitions.CountryEnum;
import cz.balikobot.api.definitions.Request;
import cz.balikobot.api.definitions.ServiceType;
import cz.balikobot.api.definitions.Shipper;
import cz.balikobot.api.exceptions.BadRequestException;
import cz.balikobot.api.exceptions.UnauthorizedException;
import cz.balikobot.api.model.values.PackageDropStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import lombok.Data;

/**
 * Balikobot API client
 */
@Data
public class Client {
  /**
   * The RequesterInterface interface provides methods for calling the Balikobot API.
   */
  private RequesterInterface requester;

  /**
   * This private variable represents the formatter used for formatting data.
   */
  private Formatter formatter;

  /**
   * Represents a validator object used for validating input data.
   * <p>
   * This private instance variable is used within the class "Client".
   */
  private Validator validator;

  /**
   * The Client class is responsible for making requests to the Balikobot API.
   *
   * @param requester The requester used to make API calls.
   */
  public Client(RequesterInterface requester) {
    this.requester = requester;
    this.validator = new Validator();
    this.formatter = new Formatter(this.validator);
  }

  /**
   * Adds packages to the Balikobot API.
   *
   * @param shipper   The shipper object representing the shipper making the request.
   * @param packages  The list of packages to be added. Each package is represented by a HashMap<Object, Object>.
   * @param labelsUrl The URL for the labels associated with the added packages.
   * @return The list of packages that have successfully been added. Each package is represented by a HashMap<Object, Object>.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public List<HashMap<Object, Object>> addPackages(Shipper shipper, List<HashMap<Object, Object>> packages, Object labelsUrl) throws UnauthorizedException, BadRequestException {
    final HashMap<Object, Object> data = new HashMap<>();
    data.put("packages", packages);
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ADD.label, data);
    if (response != null) {
      final Object resPackages = response.get("packages");
      return resPackages != null ? (ArrayList<HashMap<Object, Object>>) resPackages : new ArrayList<>();
    } else {
      return new ArrayList<>();
    }
  }

  /**
   * Adds a package to the Balikobot API.
   *
   * @param shipper   The shipper object representing the shipper making the request.
   * @param pkg       The package to be added. It is represented by a HashMap<Object, Object>.
   * @param labelsUrl The URL for the labels associated with the added package.
   * @return The list of packages that have successfully been added. Each package is represented by a HashMap<Object, Object>.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public List<HashMap<Object, Object>> addPackage(Shipper shipper, HashMap<Object, Object> pkg, Object labelsUrl) throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ADD.label, pkg);
    if (response != null) {
      final Object resPackages = response.get("packages");
      return resPackages != null ? (ArrayList<HashMap<Object, Object>>) resPackages : new ArrayList<>();
    } else {
      return new ArrayList<>();
    }
  }

  /**
   * Drops a package from the Balikobot – the package must be not ordered
   *
   * @param shipper   The shipper object representing the shipper making the request.
   * @param packageId The ID of the package to be dropped.
   * @return The list of PackageDropStatus objects indicating the status of the dropped packages.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public List<PackageDropStatus> dropPackages(Shipper shipper, String packageId) throws UnauthorizedException, BadRequestException {
    return this.dropPackages(shipper, Collections.singletonList(packageId));
  }

  /**
   * Drops packages from the Balikobot API.
   *
   * @param shipper    The shipper object representing the shipper making the request.
   * @param packageIds The list of package IDs to be dropped.
   * @return The list of PackageDropStatus objects indicating the status of the dropped packages.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public List<PackageDropStatus> dropPackages(Shipper shipper, List<String> packageIds) throws UnauthorizedException, BadRequestException {
    List<PackageDropStatus> returnResult = new ArrayList<>();
    if (packageIds != null && !packageIds.isEmpty()) {
      final HashMap<Object, Object> data = new HashMap<>();
      data.put("package_ids", packageIds);
      final HashMap<Object, Object> result = this.requester.call(API.V2V1, shipper, Request.DROP.label, data);
      if (result != null) {
        final Integer status = (Integer) result.get("status");
        if (status != null && status.equals(200)) {
          final ArrayList<LinkedHashMap<Object, Object>> packages = (ArrayList<LinkedHashMap<Object, Object>>) result.get("packages");
          if (packages != null) {
            for (LinkedHashMap<Object, Object> p : packages) {
              final String packageId = (String) p.get("package_id");
              final Integer pStatus = (Integer) p.get("status");
              final String statusMessage = (String) p.get("status_message");
              returnResult.add(new PackageDropStatus(packageId, pStatus, statusMessage));
            }
          }
        }
      }
    }
    return returnResult;
  }

  /**
   * Tracks a package using the shipper and carrier ID.
   *
   * @param shipper   The shipper object representing the shipper making the request.
   * @param carrierId The ID of the carrier for the package.
   * @return A HashMap containing tracking information for the package. If there are no tracking records found, an empty HashMap is returned.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public HashMap<Object, Object> trackPackage(Shipper shipper, String carrierId) throws UnauthorizedException, BadRequestException {
    final ArrayList<HashMap<Object, Object>> tracks = this.trackPackages(shipper, Collections.singletonList(carrierId));
    return tracks != null && !tracks.isEmpty() ? tracks.get(0) : new HashMap<>();
  }

  /**
   * Tracks multiple packages using the shipper and carrier IDs.
   *
   * @param shipper    The shipper object representing the shipper making the request.
   * @param carrierIds The list of carrier IDs for the packages.
   * @return An ArrayList of HashMaps containing tracking information for each package.
   * If there are no tracking records found for a package, an empty HashMap is returned.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public ArrayList<HashMap<Object, Object>> trackPackages(Shipper shipper, List<String> carrierIds) throws UnauthorizedException, BadRequestException {
    final HashMap<Object, Object> data = new HashMap<>();
    data.put("carrier_ids", carrierIds);
    HashMap<Object, Object> response = this.requester.call(API.V2V2, shipper, Request.TRACK.label, data, false, false);
    ArrayList<HashMap<Object, Object>> result;
    if (response != null) {
      final Object resPackages = response.get("packages");
      result = resPackages != null ? (ArrayList<HashMap<Object, Object>>) resPackages : new ArrayList<>();
    } else {
      result = new ArrayList<>();
    }

    return this.formatter.normalizeTrackPackagesResponse(result);
  }

  /**
   * Retrieves an overview of the shipper's information from the Balikobot API.
   *
   * @param shipper The shipper object representing the shipper making the request.
   * @return A HashMap containing the shipper's overview information.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public HashMap<Object, Object> getOverview(Shipper shipper) throws UnauthorizedException, BadRequestException {
    return this.requester.call(API.V2V1, shipper, Request.OVERVIEW.label, new HashMap<>(), false, false);
  }

  /**
   * Retrieves the URL for the labels associated with the specified packages.
   *
   * @param shipper    The shipper object representing the shipper making the request.
   * @param packageIds The list of package IDs.
   * @return The URL for the labels.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public String getLabels(Shipper shipper, List<String> packageIds) throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.LABELS.label, new HashMap<Object, Object>() {{
      put("package_ids", packageIds);
    }});

    return (String) response.get("labels_url");
  }

  /**
   * This method is used to order a shipment with the given shipper and package IDs.
   *
   * @param shipper    The shipper object representing the shipper making the request.
   * @param packageIds The list of package IDs to be included in the shipment.
   * @return A HashMap<Object, Object> representing the response from the API.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public HashMap<Object, Object> orderShipment(Shipper shipper, List<String> packageIds) throws UnauthorizedException, BadRequestException {
    final HashMap<Object, Object> data = new HashMap<>();
    data.put("package_ids", packageIds);
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ORDER.label, data);

    return this.formatter.withoutStatus(response);
  }


  /**
   * Retrieves the available services for the given shipper.
   *
   * @param shipper The shipper object representing the shipper making the request.
   * @return A HashMap representing the available services. The keys and values in the HashMap correspond to the service types and their names respectively.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public HashMap<Object, Object> getServices(Shipper shipper) throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.SERVICES.label);

    final ArrayList<HashMap<Object, Object>> serviceTypes = (ArrayList<HashMap<Object, Object>>) response.get("service_types");
    return formatter.normalizeResponseItems(serviceTypes, "service_type", "name");
  }

  /**
   * Retrieves the branches for a given shipper, service, country, and request type.
   *
   * @param shipper             The shipper object representing the shipper making the request.
   * @param service             The service type.
   * @param country             The country for which branches are requested. (optional)
   * @param fullBranchesRequest Boolean value indicating whether to request full branches or not. (optional)
   * @param gzip                Boolean value indicating whether to enable gzip compression for the response. (optional)
   * @return An ArrayList of HashMaps containing branch information.
   * Each branch is represented by a HashMap<Object, Object>.
   * If no branches are found or the response is null, an empty ArrayList is returned.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public ArrayList<HashMap<Object, Object>> getBranches(
      Shipper shipper,
      ServiceType service,
      CountryEnum country /*=null*/,
      Boolean fullBranchesRequest /*=false*/,
      Boolean gzip /*=false*/
  ) throws UnauthorizedException, BadRequestException {
    String url;
    final Request usedRequest = fullBranchesRequest ? Request.FULL_BRANCHES : Request.BRANCHES;
    url = usedRequest.label;

    if (service != null) {
      url += "/service/" + service.label;
    }

    if (country != null) {
      url += "/country/" + country.label;
    }

    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, url);

    if (response != null) {
      final Object branches = response.get("branches");
      return branches != null ? (ArrayList<HashMap<Object, Object>>) branches : new ArrayList<>();
    } else {
      return new ArrayList<>();
    }
  }

  /**
   * Retrieves the available countries for the given shipper.
   *
   * @param shipper The shipper object representing the shipper making the request.
   * @return A HashMap representing the available countries. The keys and values in the HashMap correspond to the country codes and their names respectively.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public HashMap<Object, Object> getCountries(Shipper shipper) throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.COUNTRIES.label);

    ArrayList<HashMap<Object, Object>> result;
    if (response != null) {
      final Object resPackages = response.get("service_types");
      result = resPackages != null ? (ArrayList<HashMap<Object, Object>>) resPackages : new ArrayList<>();
    } else {
      result = new ArrayList<>();
    }

    return formatter.normalizeResponseItems(result, "service_type", "countries");
  }

  /**
   * Retrieves the activated services for the given shipper.
   *
   * @param shipper The shipper object representing the shipper making the request.
   * @return A HashMap representing the activated services. The keys and values in the HashMap correspond to the service codes and their names respectively.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public HashMap<Object, Object> getActivatedServices(Shipper shipper) throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ACTIVATED_SERVICES.label);

    return this.formatter.withoutStatus(response);
  }

  /**
   * Retrieves the countries data from the API.
   *
   * @return a HashMap containing country data where the key is the ISO code and the value is the corresponding data
   * @throws UnauthorizedException if the user is not authorized to access the API
   * @throws BadRequestException   if the API request is invalid
   */
  public HashMap<Object, Object> getCountriesData() throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, null, Request.GET_COUNTRIES_DATA.label);

    ArrayList<HashMap<Object, Object>> result = new ArrayList<>();
    if (response != null) {
      final Object resPackages = response.get("countries");
      result = resPackages != null ? (ArrayList<HashMap<Object, Object>>) resPackages : new ArrayList<>();
    } else {
      result = new ArrayList<>();
    }

    return formatter.normalizeResponseItems(result, "iso_code", null);
  }

  /**
   * Retrieves the changelog from the Balikobot API.
   *
   * @return A HashMap<Object, Object> containing the changelog information.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is malformed or invalid.
   */
  public HashMap<Object, Object> getChangelog() throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, null, Request.CHANGELOG.label);

    return this.formatter.withoutStatus(response);
  }
}

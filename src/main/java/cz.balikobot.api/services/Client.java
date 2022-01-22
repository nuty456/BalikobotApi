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

@Data
public class Client {
  /**
   * API requester
   *
   * @var \Inspirum\Balikobot\Contracts\RequesterInterface
   */
  private RequesterInterface requester;

  /**
   * Request and Response formatter
   *
   * @var \Inspirum\Balikobot\Services\Formatter
   */
  private Formatter formatter;

  /**
   * Response validator
   *
   * @var \Inspirum\Balikobot\Services\Validator
   */
  private Validator validator;

  /**
   * Balikobot API client
   *
   * @param \Inspirum\Balikobot\Contracts\RequesterInterface requester
   */
  public Client(RequesterInterface requester) {
    this.requester = requester;
    this.validator = new Validator();
    this.formatter = new Formatter(this.validator);
  }

  /**
   * Add package(s) to the Balikobot
   *
   * @param shipper
   * @param packages
   * @param labelsUrl
   * @return ArrayList<HashMap < String, Object>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public List<HashMap<Object, Object>> addPackages(Shipper shipper, List<HashMap<Object, Object>> packages, Object labelsUrl) throws UnauthorizedException, BadRequestException {
    final HashMap<Object, Object> data = new HashMap<>();
    data.put("packages", packages);
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ADD.label, data);
    // HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ADD.label, new HashMap<Object, Object>() {{
    //   put("packages", packages);
    // }});

    if (response != null && response.get("labels_url") != null) {
      labelsUrl = response.get("labels_url");
    }

    // response = response.get("packages") ?? [];


    this.validator.validateIndexes(response, packages.size());

    // todo this.validator.validateResponseItemHasAttribute(response, "package_id", response);


    if (response != null) {
      final Object resPackages = response.get("packages");
      return resPackages != null ? (ArrayList<HashMap<Object, Object>>) resPackages : new ArrayList<>();
    } else {
      return new ArrayList<>();
    }
  }

  /**
   * Add package(s) to the Balikobot
   *
   * @param shipper
   * @param pkg
   * @param labelsUrl
   * @return ArrayList<HashMap < String, Object>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public List<HashMap<Object, Object>> addPackage(Shipper shipper, HashMap<Object, Object> pkg, Object labelsUrl) throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ADD.label, pkg);

    if (response.get("labels_url") != null) {
      labelsUrl = response.get("labels_url");
    }

    // response = response.get("packages") ?? [];


    // this.validator.validateIndexes(response, packages.size());

    // todo this.validator.validateResponseItemHasAttribute(response, "package_id", response);


    if (response != null) {
      final Object resPackages = response.get("packages");
      return resPackages != null ? (ArrayList<HashMap<Object, Object>>) resPackages : new ArrayList<>();
    } else {
      return new ArrayList<>();
    }
  }

  // /**
  //  * Drops a package from the Balikobot – the package must be not ordered
  //  *
  //  * @param shipper
  //  * @param packageId
  //  * @return void
  //  * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
  //  */
  // public boolean dropPackage(Shipper shipper, String packageId) {
  //   if (packageId != null) {
  //     // final HashMap<Object, Object> data = new HashMap<Object, Object>() {{
  //     //   put("id", packageId);
  //     // }};
  //     final HashMap<Object, Object> data = new HashMap<>();
  //     data.put("id", packageId);
  //     final HashMap<Object, Object> dataPckgIds = new HashMap<>();
  //     dataPckgIds.put("package_ids", data);
  //     final HashMap<Object, Object> result = this.requester.call(API.V2V1, shipper, Request.DROP.label, dataPckgIds);
  //     System.out.println(result);
  //     if (result != null) {
  //       return true;
  //     } else {
  //       return false;
  //     }
  //   }
  //   return false;
  // }

  /**
   * Drops a package from the Balikobot – the package must be not ordered
   *
   * @param shipper
   * @param packageId
   * @return void
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public List<PackageDropStatus> dropPackages(Shipper shipper, String packageId) throws UnauthorizedException, BadRequestException {
    return this.dropPackages(shipper, Collections.singletonList(packageId));
  }

  /**
   * Drops a package from the Balikobot – the package must be not ordered
   *
   * @param shipper
   * @param packageIds
   * @return void
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public List<PackageDropStatus> dropPackages(Shipper shipper, List<String> packageIds) throws UnauthorizedException, BadRequestException {
    List<PackageDropStatus> returnResult = new ArrayList<>();
    if (packageIds != null && packageIds.size() > 0) {
      final HashMap<Object, Object> data = new HashMap<>();
      data.put("package_ids", packageIds);
      final HashMap<Object, Object> result = this.requester.call(API.V2V1, shipper, Request.DROP.label, data);
      // {"packages":[
      //     {"package_id":"add-intime-3663","status":200,"status_message":"Operace prob\u011bhla v po\u0159\u00e1dku."}
      //   ],
      //   "status":200}
      // System.out.println(result);
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
   * Tracks a package
   *
   * @param shipper
   * @param carrierId
   * @return ArrayList<ArrayList < String, Double | String>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<Object, Object> trackPackage(Shipper shipper, String carrierId) throws UnauthorizedException, BadRequestException {
    final ArrayList<HashMap<Object, Object>> tracks = this.trackPackages(shipper, Collections.singletonList(carrierId));
    return tracks != null && tracks.size() > 0 ? tracks.get(0) : new HashMap<>();
  }

  /**
   * Tracks a packages
   *
   * @param shipper
   * @param carrierIds
   * @return ArrayList<ArrayList < ArrayList < String, Double | String>>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public ArrayList<HashMap<Object, Object>> trackPackages(Shipper shipper, List<String> carrierIds) throws UnauthorizedException, BadRequestException {
    final HashMap<Object, Object> data = new HashMap<>();
    data.put("carrier_ids", carrierIds);
    HashMap<Object, Object> response = this.requester.call(API.V2V2, shipper, Request.TRACK.label, data, false, false);

    // response = response.get("packages") ?? [];

    ArrayList<HashMap<Object, Object>> result = new ArrayList<>();
    if (response != null) {
      final Object resPackages = response.get("packages");
      result = resPackages != null ? (ArrayList<HashMap<Object, Object>>) resPackages : new ArrayList<>();
    } else {
      result = new ArrayList<>();
    }


    this.validator.validateIndexes(response, carrierIds.size());

    return this.formatter.normalizeTrackPackagesResponse(result);
  }

  /**
   * Tracks a package, get the last info
   *
   * @param shipper
   * @param carrierId
   * @return ArrayList<String, Double | String | null>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> trackPackageLastStatus(Shipper shipper, String carrierId) {
  //   return this.trackPackagesLastStatus(shipper,[carrierId])[0];
  // }

  /**
   * Tracks a package, get the last info
   *
   * @param             shipper
   * @param ArrayList<String> carrierIds
   * @return ArrayList<ArrayList < String, Double | String | null>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> trackPackagesLastStatus(Shipper shipper, List<String> carrierIds) {
  //   HashMap<Object, Object> response = this.requester.call(
  //       API.V2V2,
  //       shipper,
  //       Request.TRACK_STATUS,
  //       new HashMap<Object, Object>() {{
  //         put("carrier_ids", carrierIds);
  //       }},
  //       false, false
  //   );
  //
  //   HashMap<Object, Object> res = response.get("packages") != null ? (HashMap<Object, Object>) response.get("packages") : new HashMap<>();
  //
  //   this.validator.validateIndexes(res, carrierIds != null ? carrierIds.size() : 0);
  //
  //   return this.formatter.normalizeTrackPackagesLastStatusResponse(res);
  // }

  /**
   * Returns packages from the front (not ordered) for given shipper
   *
   * @param shipper
   * @return ArrayList<ArrayList < String, int | String>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<Object, Object> getOverview(Shipper shipper) throws UnauthorizedException, BadRequestException {
    return this.requester.call(API.V2V1, shipper, Request.OVERVIEW.label, new HashMap<>(), false, false);
  }

  /**
   * Gets labels
   *
   * @param shipper
   * @param packageIds
   * @return String
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public String getLabels(Shipper shipper, List<String> packageIds) throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.LABELS.label, new HashMap<Object, Object>() {{
      put("package_ids", packageIds);
    }});

    return (String) response.get("labels_url");
  }

  /**
   * Gets complete information about a package by its package ID
   *
   * @param shipper
   * @param packageId
   * @return ArrayList<String, int | String>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getPackageInfo(Shipper shipper, String packageId) {
  //   return this.requester.call(API.V2V1, shipper, Request.PACKAGE."/".packageId, shouldHaveStatus:false);
  // }

  /**
   * Gets complete information about a package by its carrier ID
   *
   * @param shipper
   * @param carrierId
   * @return ArrayList<String, int | String>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getPackageInfoByCarrierId(Shipper shipper, String carrierId) {
  //   return this.requester.call(
  //       API.V2V1,
  //       shipper,
  //       Request.PACKAGE."/carrier_id/".carrierId,
  //       shouldHaveStatus:false,
  //       );
  // }

  /**
   * Order shipment for packages
   *
   * @param shipper
   * @param packageIds
   * @return ArrayList<String, int | String>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<Object, Object> orderShipment(Shipper shipper, List<String> packageIds) throws UnauthorizedException, BadRequestException {
    final HashMap<Object, Object> data = new HashMap<>();
    data.put("package_ids", packageIds);
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ORDER.label, data);

    return this.formatter.withoutStatus(response);
  }

  /**
   * Get order details
   *
   * @param shipper
   * @param orderId
   * @return ArrayList<String, int | String | ArrayList <>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getOrder(Shipper shipper, String orderId) {
  //   HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ORDER_VIEW."/".orderId, shouldHaveStatus:false);
  //
  //   return this.formatter.withoutStatus(response);
  // }

  /**
   * Order pickup for packages
   *
   * @param shipper
   * @param dateFrom
   * @param dateTo
   * @param weight
   * @param packageCount
   * @param message
   * @return void
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public void orderPickup(
  //     Shipper shipper,
  //     DateTime dateFrom,
  //     DateTime dateTo,
  //     Double weight,
  //     int packageCount,
  //     String message/* = null,*/
  // ) {
  //   this.requester.call(API.V2V1, shipper, Request.ORDER_PICKUP, new HashMap<Object, Object>() {
  //     {
  //       put("date", DateTimeFormat.forPattern("yyyy-MM-dd").print(dateFrom));
  //       put("time_from", dateFrom.format("H:s"));
  //       put("time_to", dateTo.format("H:s"));
  //       put("weight", weight);
  //       put("package_count", packageCount);
  //       put("message", message);
  //     }
  //   });
  // }

  /**
   * Returns available services for the given shipper
   *
   * @param shipper
   * @return ArrayList<String, String>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<Object, Object> getServices(Shipper shipper) throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.SERVICES.label);

    final ArrayList<HashMap<Object, Object>> serviceTypes = (ArrayList<HashMap<Object, Object>>) response.get("service_types");
    return this.formatter.normalizeResponseItems(serviceTypes, "service_type", "name");
    // return serviceTypes;
  }

  /**
   * Returns available B2A services for the given shipper
   *
   * @param shipper
   * @return ArrayList<String, String>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getB2AServices(Shipper shipper) {
  //   HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.B2A."/".Request.SERVICES);
  //
  //   return response.get("service_types") ?? [];
  // }

  /**
   * Returns all manipulation units for the given shipper
   *
   * @param shipper
   * @param  fullData
   * @return ArrayList<String, String | ArrayList <>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getManipulationUnits(Shipper shipper, Boolean fullData /*= false*/) {
  //   HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.MANIPULATION_UNITS);
  //
  //   return this.formatter.normalizeResponseItems(
  //       response.get("units") ? ? [],
  //   "code",
  //       fullData == false ? "name" : null,
  //       );
  // }

  /**
   * Returns available manipulation units for the given shipper
   *
   * @param shipper
   * @param  fullData
   * @return ArrayList<String, String | ArrayList <>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getActivatedManipulationUnits(Shipper shipper, Boolean fullData =false) {
  //   HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ACTIVATED_MANIPULATION_UNITS);
  //
  //   return this.formatter.normalizeResponseItems(
  //       response.get("units") ? ? [],
  //   "code",
  //       fullData == false ? "name" : null,
  //       );
  // }

  /**
   * Returns available branches for the given shipper and its service Full branches instead branches request
   *
   * @param shipper
   * @param |null               service
   * @param |null               country
   * @param fullBranchesRequest
   * @param gzip
   * @return ArrayList<HashMap < String, Object>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public ArrayList<HashMap<Object, Object>> getBranches(
      Shipper shipper,
      ServiceType service,
      CountryEnum country /*=null*/,
      Boolean fullBranchesRequest /*=false*/,
      Boolean gzip /*=false*/
  ) throws UnauthorizedException, BadRequestException {
    String url = "";
    final Request usedRequest = fullBranchesRequest ? Request.FULL_BRANCHES : Request.BRANCHES;
    url = usedRequest.label;

    if (service != null) {
      // url += "/" + service.label + "/";
      url += "/service/" + service.label;
    }

    if (country != null) {
      // url += "/" + country.label; // +"/";
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
   * Returns available branches for the given shipper in given location
   *
   * @param       shipper
   * @param       country
   * @param       city
   * @param |null postcode
   * @param |null street
   * @param int|null    maxResults
   * @param Double|null radius
   * @param |null type
   * @return ArrayList<HashMap < String, Object>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public function getBranchesForLocation(
  //     Shipper shipper,
  //     String country,
  //     String city,
  //     String postcode =null,
  //     String street =null,
  //     int maxResults =null,
  //     Double radius =null,
  //     String type =null,
  //     ):HashMap<Object, Object>
  //
  // {
  //   HashMap<Object, Object> response = this.requester.call(
  //       API.V2V1,
  //       shipper,
  //       Request.BRANCH_LOCATOR,
  //       ArrayList < > _filter(
  //       [
  //       "country" = > country,
  //   "city" =>city,
  //     "zip" =>postcode,
  //     "street" =>street,
  //     "max_results" =>maxResults,
  //     "radius" =>radius,
  //     "type" =>type,
  //               ]
  //           )
  //       );
  //
  //   return response.get("branches") ?? [];
  // }

  /**
   * Returns list of countries where service with cash-on-delivery payment type is available in
   *
   * @param shipper
   * @return ArrayList<ArrayList < int | String, ArrayList < String, ArrayList < String, mixed>>>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getCodCountries(Shipper shipper) {
  //   HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.CASH_ON_DELIVERY_COUNTRIES);
  //
  //   return this.formatter.normalizeResponseItems(
  //       response.get("service_types") ? ? [],
  //   "service_type",
  //       "cod_countries",
  //       );
  // }

  /**
   * Returns list of countries where service is available in
   *
   * @param shipper
   * @return ArrayList<ArrayList < int | String, String>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<Object, Object> getCountries(Shipper shipper) throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.COUNTRIES.label);

    ArrayList<HashMap<Object, Object>> result = new ArrayList<>();
    if (response != null) {
      final Object resPackages = response.get("service_types");
      result = resPackages != null ? (ArrayList<HashMap<Object, Object>>) resPackages : new ArrayList<>();
    } else {
      result = new ArrayList<>();
    }

    return this.formatter.normalizeResponseItems(result, "service_type", "countries");
  }

  /**
   * Returns available branches for the given shipper and its service
   *
   * @param       shipper
   * @param       service
   * @param |null country
   * @return ArrayList<ArrayList < String, mixed>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getPostCodes(Shipper shipper, String service, String country =null) {
  //   HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ZIP_CODES."/".service."/".country);
  //
  //   return this.formatter.normalizePostCodesResponse(response, country);
  // }

  /**
   * Check package(s) data
   *
   * @param                        shipper
   * @param ArrayList<ArrayList<String>> packages
   * @return void
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public void checkPackages(Shipper shipper, HashMap<Object, Object> packages) {
  //   this.requester.call(API.V2V1, shipper, Request.CHECK,["packages" = > packages]);
  // }

  /**
   * Returns available manipulation units for the given shipper
   *
   * @param shipper
   * @param  fullData
   * @return ArrayList<String>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getAdrUnits(Shipper shipper, Boolean fullData =false) {
  //   HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ADR_UNITS);
  //
  //   return this.formatter.normalizeResponseItems(
  //       response.get("units") ? ? [],
  //   "code",
  //       fullData == false ? "name" : null,
  //       );
  // }

  /**
   * Returns available activated services for the given shipper
   *
   * @param shipper
   * @return ArrayList<String, mixed>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<Object, Object> getActivatedServices(Shipper shipper) throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, shipper, Request.ACTIVATED_SERVICES.label);

    return this.formatter.withoutStatus(response);
  }

  /**
   * Order shipments from place B (typically supplier / previous consignee) to place A (shipping point)
   *
   * @param shipper
   * @param ArrayList<ArrayList<String,mixed>> packages
   * @return ArrayList<ArrayList < String, mixed>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public ArrayList<HashMap<String, Object>> orderB2AShipment(Shipper shipper, HashMap<Object, Object> packages) {
  //   HashMap<Object, Object> response = this.requester.call(API.V1, shipper, Request.B2A, packages);
  //
  //   response = this.formatter.withoutStatus(response);
  //
  //   this.validator.validateIndexes(response, count(packages));
  //
  //   this.validator.validateResponseItemHasAttribute(response, "package_id", response);
  //
  //   return response;
  // }

  /**
   * Get PDF link with signed consignment delivery document by the recipient
   *
   * @param shipper
   * @param carrierId
   * @return String
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public String getProofOfDelivery(Shipper shipper, String carrierId) {
  //   return this.getProofOfDeliveries(shipper,[carrierId])[0];
  // }

  /**
   * Get HashMap<Object, Object> of PDF links with signed consignment delivery document by the recipient
   *
   * @param             shipper
   * @param ArrayList<String> carrierIds
   * @return ArrayList<String>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getProofOfDeliveries(Shipper shipper,List<String> carrierIds) {
  //   HashMap<Object, Object> response = this.requester.call(
  //       API.V1,
  //       shipper,
  //       Request.PROOF_OF_DELIVERY,
  //       this.formatter.encapsulateIds(carrierIds, "id"),
  //       shouldHaveStatus:false,
  //       );
  //
  //   response = this.formatter.withoutStatus(response);
  //
  //   this.validator.validateIndexes(response, count(carrierIds));
  //
  //   return this.formatter.normalizeProofOfDeliveriesResponse(response);
  // }

  /**
   * Obtain the price of carriage at consignment level
   *
   * @param                              shipper
   * @param ArrayList<ArrayList<String,mixed>> packages
   * @return ArrayList<ArrayList < String, mixed>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getTransportCosts(Shipper shipper, HashMap<Object, Object> packages) {
  //   HashMap<Object, Object> response = this.requester.call(API.V1, shipper, Request.TRANSPORT_COSTS, packages);
  //
  //   unset(response.get("status"));
  //
  //   this.validator.validateIndexes(response, count(packages));
  //
  //   this.validator.validateResponseItemHasAttribute(response, "eid", response);
  //
  //   return response;
  // }

  /**
   * Get information on individual countries of the world
   *
   * @return ArrayList<ArrayList < String, mixed>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
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

    return this.formatter.normalizeResponseItems(result, "iso_code", null);
  }

  /**
   * Method for obtaining news in the Balikobot API
   *
   * @return ArrayList<String, mixed>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<Object, Object> getChangelog() throws UnauthorizedException, BadRequestException {
    HashMap<Object, Object> response = this.requester.call(API.V2V1, null, Request.CHANGELOG.label);

    return this.formatter.withoutStatus(response);
  }

  /**
   * Method for easier carrier integration, obtaining list of available input attributes for the ADD method
   *
   * @param shipper
   * @return ArrayList<String, ArrayList < String, mixed>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getAddAttributes(Shipper shipper) {
  //   HashMap<Object, Object> response = this.requester.call(API.V1, shipper, Request.ADD_ATTRIBUTES);
  //
  //   return this.formatter.normalizeResponseItems(
  //       response.get("attributes") ? ? [],
  //   "name",
  //       null,
  //       );
  // }

  /**
   * Method for obtaining a list of additional services by individual transport services
   *
   * @param       shipper
   * @param |null service
   * @param      fullData
   * @return ArrayList<String, String | ArrayList <>|ArrayList<String, String|HashMap<Object, Object>>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getAddServiceOptions(Shipper shipper, String service =null, Boolean fullData =false) {
  //   HashMap<Object, Object> response = this.requester.call(API.V1, shipper, Request.ADD_SERVICE_OPTIONS."/".service);
  //
  //   if (service == null) {
  //     return this.formatter.normalizeResponseIndexedItems(
  //         response.get("service_types") ? ? [],
  //     "service_type",
  //         "services",
  //         "code",
  //         fullData == false ? "name" : null,
  //           );
  //   }
  //
  //   return this.formatter.normalizeResponseItems(
  //       response.get("services") ? ? [],
  //   "code",
  //       fullData == false ? "name" : null,
  //       );
  // }
}

package cz.balikobot.api.services;

import cz.balikobot.api.contracts.RequesterInterface;
import cz.balikobot.api.definitions.CountryEnum;
import cz.balikobot.api.definitions.ServiceType;
import cz.balikobot.api.definitions.Shipper;
import cz.balikobot.api.exceptions.BadRequestException;
import cz.balikobot.api.exceptions.UnauthorizedException;
import cz.balikobot.api.model.aggregates.OrderedPackageCollection;
import cz.balikobot.api.model.aggregates.PackageCollection;
import cz.balikobot.api.model.values.Branch;
import cz.balikobot.api.model.values.Country;
import cz.balikobot.api.model.values.OrderedPackage;
import cz.balikobot.api.model.values.OrderedShipment;
import cz.balikobot.api.model.values.PackageDropStatus;
import cz.balikobot.api.model.values.PackageStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Balikobot {
  /**
   * Balikobot API
   *
   * @var \Inspirum\Balikobot\Services\Client
   */
  private Client client;

  /**
   * Balikobot constructor
   *
   * @param \Inspirum\Balikobot\Contracts\RequesterInterface requester
   */
  public Balikobot(RequesterInterface requester) {
    this.client = new Client(requester);
  }

  /**
   * All supported shipper services
   *
   * @return ArrayList<String>
   */
  public List<Shipper> getShippers() {
    return Shipper.all();
  }

  /**
   * Add packages
   *
   * @param \Inspirum\Balikobot\Model\Aggregates\PackageCollection packages
   * @return \Inspirum\Balikobot\Model\Aggregates\OrderedPackageCollection|\Inspirum\Balikobot\Model\Values\OrderedPackage[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public OrderedPackageCollection addPackages(PackageCollection packages) throws UnauthorizedException, BadRequestException {
    String labelsUrl = null;
    final List<HashMap<Object, Object>> response = this.client.addPackages(packages.getShipper(), packages.toArray(), labelsUrl);

    OrderedPackageCollection orderedPackages = new OrderedPackageCollection(packages.getShipper());
    orderedPackages.setLabelsUrl(labelsUrl);

    for (HashMap<Object, Object> p : response) {
      orderedPackages.add(OrderedPackage.newInstanceFromData(packages.getShipper(), p));
    }

    return orderedPackages;
  }

  /**
   * Exports order into Balikobot system
   *
   * @param \Inspirum\Balikobot\Model\Aggregates\OrderedPackageCollection packages
   * @return void
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public void dropPackages(OrderedPackageCollection packages) throws UnauthorizedException, BadRequestException {
    this.client.dropPackages(packages.getShipper(), packages.getPackageIds());
  }

  // /**
  //  * Drop package from Balikobot system
  //  *
  //  * @param \Inspirum\Balikobot\Model\Values\OrderedPackage package
  //  * @return void
  //  * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
  //  */
  // public boolean dropPackage(OrderedPackage orderedPackage) {
  //   return this.client.dropPackage(orderedPackage.getShipper(), orderedPackage.getPackageId());
  // }

  /**
   * Drop package from Balikobot system
   *
   * @param \Inspirum\Balikobot\Model\Values\OrderedPackage package
   * @return void
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public List<PackageDropStatus> dropPackages(OrderedPackage orderedPackage) throws UnauthorizedException, BadRequestException {
    return this.client.dropPackages(orderedPackage.getShipper(), orderedPackage.getPackageId());
  }

  /**
   * Order shipment
   *
   * @param \Inspirum\Balikobot\Model\Aggregates\OrderedPackageCollection packages
   * @return \Inspirum\Balikobot\Model\Values\OrderedShipment
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public OrderedShipment orderShipment(OrderedPackageCollection packages) throws UnauthorizedException, BadRequestException {
    final HashMap<Object, Object> response = this.client.orderShipment(packages.getShipper(), packages.getPackageIds());

    return OrderedShipment.newInstanceFromData(packages.getShipper(), packages.getPackageIds(), response);
  }

  /**
   * Track package
   *
   * @param \Inspirum\Balikobot\Model\Values\OrderedPackage package
   * @return ArrayList<\ Inspirum \ Balikobot \ Model \ Values \ PackageStatus>|\Inspirum\Balikobot\Model\Values\PackageStatus[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public PackageStatus trackPackage(OrderedPackage orderedPackage) throws UnauthorizedException, BadRequestException {
    final OrderedPackageCollection packages = new OrderedPackageCollection(orderedPackage.getShipper());// todo ten shipper v construktoru tam nebyl
    packages.add(orderedPackage);

    final ArrayList<PackageStatus> packageStatuses = this.trackPackages(packages);
    return packageStatuses != null && packageStatuses.size() > 0 ? packageStatuses.get(0) : null;
  }

  /**
   * Track packages
   *
   * @param \Inspirum\Balikobot\Model\Aggregates\OrderedPackageCollection packages
   * @return ArrayList<\ Inspirum \ Balikobot \ Model \ Values \ PackageStatus>>|\Inspirum\Balikobot\Model\Values\PackageStatus[][]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public ArrayList<PackageStatus> trackPackages(OrderedPackageCollection packages) throws UnauthorizedException, BadRequestException {
    final ArrayList<HashMap<Object, Object>> response = this.client.trackPackages(packages.getShipper(), packages.getCarrierIds());

    ArrayList<PackageStatus> statuses = new ArrayList<>();

    for (HashMap<Object, Object> responseStatuses : response) {
      statuses.add(this.createPackageStatusesCollection(responseStatuses));
    }

    return statuses;
  }

  /**
   * Track package last status
   *
   * @param \Inspirum\Balikobot\Model\Values\OrderedPackage package
   * @return \Inspirum\Balikobot\Model\Values\PackageStatus
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public PackageStatus trackPackageLastStatus(OrderedPackage orderedPackage) {
  //   OrderedPackageCollection packages = new OrderedPackageCollection(orderedPackage.getShipper());
  //   packages.add(orderedPackage);
  //
  //   return this.trackPackagesLastStatus(packages);
  // }

  /**
   * Track package last status
   *
   * @param \Inspirum\Balikobot\Model\Aggregates\OrderedPackageCollection packages
   * @return ArrayList<\ Inspirum \ Balikobot \ Model \ Values \ PackageStatus>|\Inspirum\Balikobot\Model\Values\PackageStatus[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public PackageStatus trackPackagesLastStatus(OrderedPackageCollection packages) {
  //   HashMap<Object, Object> response = this.client.trackPackagesLastStatus(packages.getShipper(), packages.getCarrierIds());
  //
  //   return this.createPackageStatusesCollection(response);
  // }

  /**
   * Create package statuses collection for package
   *
   * @param response
   * @return ArrayList<\ Inspirum \ Balikobot \ Model \ Values \ PackageStatus>
   */
  private ArrayList<PackageStatus> createPackageStatusesCollection(ArrayList<HashMap<Object, Object>> response) {
    final ArrayList<PackageStatus> statuses = new ArrayList<>();

    for (HashMap<Object, Object> status : response) {
      statuses.add(PackageStatus.newInstanceFromData(status));
    }

    return statuses;
  }

  private PackageStatus createPackageStatusesCollection(HashMap<Object, Object> response) {
    // final ArrayList statuses = new ArrayList();

    // for (Map.Entry<Object, Object> status : response.entrySet()) {
    return PackageStatus.newInstanceFromData(response);
    // statuses.add(PackageStatus.newInstanceFromData(status));
    // }

    // return statuses;
  }

  /**
   * Get overview for given shipper
   *
   * @param shipper
   * @return \Inspirum\Balikobot\Model\Aggregates\OrderedPackageCollection|\Inspirum\Balikobot\Model\Values\OrderedPackage[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public OrderedPackageCollection getOverview(Shipper shipper) {
  //   HashMap<Object, Object> response = this.client.getOverview(shipper);
  //
  //   HashMap<Object, Object> res = response.get("packages");
  //
  //   OrderedPackageCollection orderedPackages = new OrderedPackageCollection();
  //
  //   for (HashMap<Object, Object> p : res) {
  //     OrderedPackage orderedPackage = OrderedPackage.newInstanceFromData(shipper, p);
  //     orderedPackages.add(orderedPackage);
  //   }
  //
  //   return orderedPackages;
  // }

  /**
   * Get labels for orders
   *
   * @param \Inspirum\Balikobot\Model\Aggregates\OrderedPackageCollection packages
   * @return String
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public String getLabels(OrderedPackageCollection packages) throws UnauthorizedException, BadRequestException {
    return this.client.getLabels(packages.getShipper(), packages.getPackageIds());
  }

  /**
   * Gets complete information about a package
   *
   * @param \Inspirum\Balikobot\Model\Values\OrderedPackage package
   * @return \Inspirum\Balikobot\Model\Values\Package
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public BalikobotPackage getPackageInfo(OrderedPackage orderedPackage) {
  //   final HashMap<Object, Object> response = this.client.getPackageInfoByCarrierId(orderedPackage.getShipper(), orderedPackage.getCarrierId());
  //   response.remove("package_id");
  //   response.remove("eshop_id");
  //   response.remove("carrier_id");
  //   response.remove("track_url");
  //   response.remove("label_url");
  //   response.remove("carrier_id_swap");
  //   response.remove("pieces");
  //
  //   response.put(Option.EID, orderedPackage.getBatchId());
  //
  //   return new BalikobotPackage(response);
  // }

  /**
   * Gets complete information about a package
   *
   * @param shipper
   * @param orderId
   * @return \Inspirum\Balikobot\Model\Values\OrderedShipment
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public OrderedShipment getOrder(Shipper shipper, String orderId) {
  //   final HashMap<Object, Object> response = this.client.getOrder(shipper, orderId);
  //
  //   return OrderedShipment.newInstanceFromData(shipper, (List<String>) response.get("package_ids"), response);
  // }

  /**
   * Returns available services for the given shipper
   *
   * @param shipper
   * @return ArrayList<String, String>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<Object, Object> getServices(Shipper shipper) throws UnauthorizedException, BadRequestException {
    return this.client.getServices(shipper);
  }

  /**
   * Returns available B2A services for the given shipper
   *
   * @param shipper
   * @return ArrayList<String, String>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getB2AServices(Shipper shipper) {
  //   return this.client.getB2AServices(shipper);
  // }

  /**
   * Returns all manipulation units for the given shipper
   *
   * @param shipper
   * @param  fullData
   * @return ArrayList<String | ArrayList <>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getManipulationUnits(Shipper shipper, Boolean fullData =false) {
  //   return this.client.getManipulationUnits(shipper, fullData);
  // }

  /**
   * Returns available manipulation units for the given shipper
   *
   * @param shipper
   * @param  fullData
   * @return ArrayList<String | ArrayList <>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getActivatedManipulationUnits(Shipper shipper, Boolean fullData =false) {
  //   return this.client.getActivatedManipulationUnits(shipper, fullData);
  // }

  /**
   * Get all available branches
   *
   * @return \Generator|\Inspirum\Balikobot\Model\Values\Branch[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public ArrayList<Branch> getBranches() throws UnauthorizedException, BadRequestException {
    final ArrayList<Branch> result = new ArrayList<>();
    for (Shipper shipper : this.getShippers()) {
      result.addAll(this.getBranchesForShipper(shipper));
    }
    return result;
  }

  /**
   * Get all available branches for countries
   *
   * @param countries
   * @return \Generator|\Inspirum\Balikobot\Model\Values\Branch[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public ArrayList<Branch> getBranchesForCountries(List<CountryEnum> countries) throws UnauthorizedException, BadRequestException {
    final ArrayList<Branch> result = new ArrayList<>();
    for (Shipper shipper : this.getShippers()) {
      result.addAll(this.getBranchesForShipperForCountries(shipper, countries));
    }
    return result;
  }

  /**
   * Get all available branches for given shipper
   *
   * @param shipper
   * @return \Generator|\Inspirum\Balikobot\Model\Values\Branch[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public ArrayList<Branch> getBranchesForShipper(Shipper shipper) throws UnauthorizedException, BadRequestException {
    final ArrayList<Branch> result = new ArrayList<>();
    for (String service : this.getServicesForShipper(shipper)) {
      try {
        result.addAll(this.getBranchesForShipperService(shipper, ServiceType.valueOfLabel(service)));
      } catch (UnauthorizedException e) {
        log.error(String.format("Exception: %s", e.getMessage()));
      }
    }
    return result;
  }

  /**
   * Get all available branches for given shipper for countries
   *
   * @param shipper
   * @param countries
   * @return \Generator|\Inspirum\Balikobot\Model\Values\Branch[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public ArrayList<Branch> getBranchesForShipperForCountries(Shipper shipper, List<CountryEnum> countries) throws UnauthorizedException, BadRequestException {
    ArrayList<Branch> result = new ArrayList<>();
    final ArrayList<String> servicesForShipper = this.getServicesForShipper(shipper);
    // final HashMap<Object, Object> servicesForShipper = (HashMap<Object, Object>) servicesForShipper1;
    if (servicesForShipper != null) {
      for (String service : servicesForShipper) {
        try {
          final ServiceType serviceTypeEnum = ServiceType.valueOfLabel(service);
          final ArrayList<Branch> branchArrayList = this.getBranchesForShipperServiceForCountries(shipper, serviceTypeEnum, countries);
          result.addAll(branchArrayList);
        } catch (Exception e) {
          log.error(String.format("Exception: %s", e.getMessage()));
        }
      }
    }
    return result;
  }

  /**
   * Get services for shipper
   *
   * @param shipper
   * @return iterable<String | null>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  private ArrayList<String> getServicesForShipper(Shipper shipper) throws UnauthorizedException, BadRequestException {
    ArrayList<String> results = new ArrayList<>();
    final HashMap<Object, Object> services = this.getServices(shipper);
    // return services;
    // if (count(services) == 0) {
    //   return yield from[null];
    // }

    // for (HashMap<Object, Object> _keys (services) :service){
    //   yield(String) service;
    // }
    for (Map.Entry<Object, Object> service : services.entrySet()) {
      results.add(String.valueOf((service.getKey())));
    }
    return results;
  }

  /**
   * Get all available branches for given shipper and service type for countries
   *
   * @param service
   * @param countries
   * @param shipper
   * @return \Generator|\Inspirum\Balikobot\Model\Values\Branch[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public ArrayList<Branch> getBranchesForShipperServiceForCountries(
      Shipper shipper,
      ServiceType service,
      List<CountryEnum> countries
  ) throws UnauthorizedException, BadRequestException {
    ArrayList<Branch> result = new ArrayList<>();
    final ArrayList<Branch> allBranchesForShipperServiceForCountries = this.getAllBranchesForShipperServiceForCountries(shipper, service, countries);
    for (Branch branch : allBranchesForShipperServiceForCountries) {
      if (countries.contains(CountryEnum.valueOfLabel(branch.getCountry()))) {
        result.add(branch);
      }
    }
    return result;
  }

  /**
   * Get all available branches for given shipper and service type filtered by countries if possible
   *
   * @param service
   * @param countries
   * @param shipper
   * @return \Generator|\Inspirum\Balikobot\Model\Values\Branch[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  private ArrayList<Branch> getAllBranchesForShipperServiceForCountries(
      Shipper shipper,
      ServiceType service,
      List<CountryEnum> countries
  ) throws UnauthorizedException, BadRequestException {
    ArrayList<Branch> result = new ArrayList<>();
    final Boolean hasBranchCountryFilterSupport = Shipper.hasBranchCountryFilterSupport(shipper.label, service.label);
    if (!hasBranchCountryFilterSupport) {
      try {
        result.addAll(this.getBranchesForShipperService(shipper, service));
      } catch (Exception e) {
        log.error(String.format("Exception: %s", e.getMessage()));
      }
    }

    for (CountryEnum country : countries) {
      try {
        result.addAll(this.getBranchesForShipperService(shipper, service, country));
      } catch (Exception e) {
        log.error(String.format("Exception: %s", e.getMessage()));
      }
    }
    return result;
  }

  /**
   * Get all available branches for given shipper and service type
   *
   * @param shipper
   * @param |null   service
   * @param |null   country
   * @return \Generator|\Inspirum\Balikobot\Model\Values\Branch[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public ArrayList<Branch> getBranchesForShipperService(Shipper shipper, ServiceType service) throws UnauthorizedException, BadRequestException {
    return getBranchesForShipperService(shipper, service, null);
  }

  public ArrayList<Branch> getBranchesForShipperService(Shipper shipper, ServiceType service, CountryEnum country /*=null*/) throws UnauthorizedException, BadRequestException {
    ArrayList<Branch> result = new ArrayList<>();
    final Boolean useFullBranchRequest = Shipper.hasFullBranchesSupport(shipper.label, service.label);
    final ArrayList<HashMap<Object, Object>> branches = this.client.getBranches(shipper, service, country, useFullBranchRequest, true);
    for (HashMap<Object, Object> branch : branches) {
      try {
        result.add(Branch.newInstanceFromData(shipper, service, branch));
      } catch (Exception e) {
        log.error(String.format("Exception %s", e.getMessage()), e);
      }
    }
    return result;
  }

  /**
   * Get all available branches for given shipper
   *
   * @param       shipper
   * @param       country
   * @param       city
   * @param |null postcode
   * @param |null street
   * @param int|null    maxResults
   * @param Double|null radius
   * @param |null type
   * @return \Generator|\Inspirum\Balikobot\Model\Values\Branch[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public iterable getBranchesForLocation(
  //     Shipper shipper,
  //     String country,
  //     String city,
  //     String postcode =null,
  //     String street =null,
  //     int maxResults =null,
  //     Double radius =null,
  //     String type =null,
  //     ) {
  //   branches = this.client.getBranchesForLocation(
  //       shipper,
  //       country,
  //       city,
  //       postcode,
  //       street,
  //       maxResults,
  //       radius,
  //       type
  //   );
  //
  //   for (branches:
  //        branch) {
  //     yield Branch.newInstanceFromData(shipper, null, branch);
  //   }
  // }

  /**
   * Returns list of countries where service with cash-on-delivery payment type is available in
   *
   * @param shipper
   * @return ArrayList<ArrayList < int | String, ArrayList < String, ArrayList < String, mixed>>>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getCodCountries(Shipper shipper) {
  //   return this.client.getCodCountries(shipper);
  // }

  /**
   * Returns list of countries where service is available in
   *
   * @param shipper
   * @return ArrayList<ArrayList < int | String, String>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<Object, Object> getCountries(Shipper shipper) throws UnauthorizedException, BadRequestException {
    return this.client.getCountries(shipper);
  }

  /**
   * Returns available branches for the given shipper and its service
   *
   * @param       shipper
   * @param       service
   * @param |null country
   * @return \Generator|\Inspirum\Balikobot\Model\Values\PostCode[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public iterable getPostCodes(Shipper shipper, String service, String country/* =null*/) {
  //   for (this.client.getPostCodes(shipper, service, country) :postcode){
  //     yield PostCode.newInstanceFromData(shipper, service, postcode);
  //   }
  // }

  /**
   * Check package(s) data
   *
   * @param \Inspirum\Balikobot\Model\Aggregates\PackageCollection packages
   * @return void
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public void checkPackages(PackageCollection packages) {
  //   this.client.checkPackages(packages.getShipper(), packages.toArray());
  // }

  /**
   * Returns available manipulation units for the given shipper
   *
   * @param shipper
   * @param fullData
   * @return ArrayList<String | ArrayList <>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getAdrUnits(Shipper shipper, Boolean fullData) {
  //   return this.client.getAdrUnits(shipper, fullData);
  // }

  /**
   * Returns available activated services for the given shipper
   *
   * @param shipper
   * @return ArrayList<String, mixed>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<Object, Object> getActivatedServices(Shipper shipper) throws UnauthorizedException, BadRequestException {
    return this.client.getActivatedServices(shipper);
  }

  /**
   * Order shipments from place B (typically supplier / previous consignee) to place A (shipping point)
   *
   * @param \Inspirum\Balikobot\Model\Aggregates\PackageCollection packages
   * @return \Inspirum\Balikobot\Model\Aggregates\OrderedPackageCollection|\Inspirum\Balikobot\Model\Values\OrderedPackage[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public OrderedPackage orderB2AShipment(PackageCollection packages) {
  //   response = this.client.orderB2AShipment(packages.getShipper(), packages.toArray());
  //
  //   orderedPackages = new OrderedPackageCollection();
  //
  //   for (response:
  //        i => package){
  //   package[Option.EID] =(String) packages.offsetGet(i).getEID();
  //     orderedPackage = OrderedPackage.newInstanceFromData(packages.getShipper(), package);
  //     orderedPackages.add(orderedPackage);
  //   }
  //
  //   return orderedPackages;
  // }

  /**
   * Get PDF link with signed consignment delivery document by the recipient
   *
   * @param \Inspirum\Balikobot\Model\Values\OrderedPackage package
   * @return String
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public String getProofOfDelivery(OrderedPackage orderedPackage) {
  //   packages = new OrderedPackageCollection();
  //   packages.add(orderedPackage);
  //
  //   return this.getProofOfDeliveries(packages)[0];
  // }

  /**
   * Get HashMap<Object, Object> of PDF links with signed consignment delivery document by the recipient
   *
   * @param \Inspirum\Balikobot\Model\Aggregates\OrderedPackageCollection packages
   * @return ArrayList<String>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<Object, Object> getProofOfDeliveries(OrderedPackageCollection packages) {
  //   return this.client.getProofOfDeliveries(packages.getShipper(), packages.getCarrierIds());
  // }

  /**
   * Obtain the price of carriage at consignment level
   *
   * @param \Inspirum\Balikobot\Model\Aggregates\PackageCollection packages
   * @return \Inspirum\Balikobot\Model\Aggregates\PackageTransportCostCollection|\Inspirum\Balikobot\Model\Values\PackageTransportCost[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public PackageTransportCost getTransportCosts(PackageCollection packages) {
  //   response = this.client.getTransportCosts(packages.getShipper(), packages.toArray());
  //
  //   transportCosts = new PackageTransportCostCollection(packages.getShipper());
  //
  //   for (response: package){
  //     transportCost = PackageTransportCost.newInstanceFromData(packages.getShipper(), package);
  //     transportCosts.add(transportCost);
  //   }
  //
  //   return transportCosts;
  // }

  /**
   * Get information on individual countries of the world
   *
   * @return ArrayList<String, \ Inspirum \ Balikobot \ Model \ Values \ Country>|\Inspirum\Balikobot\Model\Values\Country[]
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<String, Country> getCountriesData() throws UnauthorizedException, BadRequestException {
    final HashMap<Object, Object> response = this.client.getCountriesData();
    HashMap<String, Country> countries = new HashMap<>();
    for (Map.Entry<Object, Object> countryEntry : response.entrySet()) {
      countries.put((String) countryEntry.getKey(), Country.newInstanceFromData((HashMap<Object, Object>) countryEntry.getValue()));
    }

    return countries;
  }

  /**
   * Method for obtaining news in the Balikobot API
   *
   * @return HashMap<String, Object>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<Object, Object> getChangelog() throws UnauthorizedException, BadRequestException {
    return this.client.getChangelog();
  }

  /**
   * Method for obtaining a list of additional services by individual transport services
   *
   * @param shipper
   * @return ArrayList<String, ArrayList < String, mixed>>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  // public HashMap<String, HashMap<String, Object>> getAddAttributes(Shipper shipper) {
  //   return this.client.getAddAttributes(shipper);
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
  //   return this.client.getAddServiceOptions(shipper, service, fullData);
  // }

}

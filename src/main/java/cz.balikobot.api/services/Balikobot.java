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

/**
 * Balikobot API
 */
@Data
@Slf4j
public class Balikobot {
  /**
   * Represents a client.
   */
  private Client client;

  /**
   * Initializes a new instance of the Balikobot class.
   *
   * @param requester The requester interface used for making requests to the Balikobot API.
   */
  public Balikobot(RequesterInterface requester) {
    this.client = new Client(requester);
  }

  /**
   * Retrieves a list of all available shippers.
   *
   * @return A list of Shipper objects representing the available shippers.
   */
  public List<Shipper> getShippers() {
    return Shipper.all();
  }

  /**
   * Adds packages to the ordered package collection.
   *
   * @param packages the package collection to be added.
   * @return the updated ordered package collection.
   * @throws UnauthorizedException if the user is not authorized.
   * @throws BadRequestException   if the request is invalid.
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
   * Drops the packages specified in the ordered package collection.
   *
   * @param packages the ordered package collection containing the packages to be dropped
   * @throws UnauthorizedException if the user is not authorized to perform the operation
   * @throws BadRequestException   if the request is invalid
   */
  public void dropPackages(OrderedPackageCollection packages) throws UnauthorizedException, BadRequestException {
    this.client.dropPackages(packages.getShipper(), packages.getPackageIds());
  }

  /**
   * Drops packages for a given ordered package.
   *
   * @param orderedPackage the ordered package to drop
   * @return a list of package drop statuses
   * @throws UnauthorizedException if the request is unauthorized
   * @throws BadRequestException   if the request is invalid
   */
  public List<PackageDropStatus> dropPackages(OrderedPackage orderedPackage) throws UnauthorizedException, BadRequestException {
    return this.client.dropPackages(orderedPackage.getShipper(), orderedPackage.getPackageId());
  }

  /**
   * Orders a shipment using the provided package collection.
   *
   * @param packages The collection of packages to be shipped.
   * @return The ordered shipment.
   * @throws UnauthorizedException if the request is unauthorized.
   * @throws BadRequestException   if the request is invalid.
   */
  public OrderedShipment orderShipment(OrderedPackageCollection packages) throws UnauthorizedException, BadRequestException {
    final HashMap<Object, Object> response = this.client.orderShipment(packages.getShipper(), packages.getPackageIds());

    return OrderedShipment.newInstanceFromData(packages.getShipper(), packages.getPackageIds(), response);
  }

  /**
   * Tracks the status of a package.
   *
   * @param orderedPackage The package to track.
   * @return The status of the package.
   * @throws UnauthorizedException If the user is not authorized to track packages.
   * @throws BadRequestException   If the provided package is invalid.
   */
  public PackageStatus trackPackage(OrderedPackage orderedPackage) throws UnauthorizedException, BadRequestException {
    final OrderedPackageCollection packages = new OrderedPackageCollection(orderedPackage.getShipper());
    packages.add(orderedPackage);

    final ArrayList<PackageStatus> packageStatuses = this.trackPackages(packages);
    return packageStatuses != null && !packageStatuses.isEmpty() ? packageStatuses.get(0) : null;
  }

  /**
   * Track packages using the specified OrderedPackageCollection.
   *
   * @param packages the OrderedPackageCollection containing the packages to track
   * @return an ArrayList of PackageStatus objects representing the current status of the tracked packages
   * @throws UnauthorizedException if the user is unauthorized to track packages
   * @throws BadRequestException   if the request is invalid
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
   * Creates a collection of PackageStatus objects from the given response.
   *
   * @param response The response containing the status data for the packages.
   * @return The collection of PackageStatus objects created from the response.
   */
  private ArrayList<PackageStatus> createPackageStatusesCollection(ArrayList<HashMap<Object, Object>> response) {
    final ArrayList<PackageStatus> statuses = new ArrayList<>();

    for (HashMap<Object, Object> status : response) {
      statuses.add(PackageStatus.newInstanceFromData(status));
    }

    return statuses;
  }

  /**
   * Creates a PackageStatus object from the given response data.
   *
   * @param response the response data in the form of a HashMap
   * @return a new PackageStatus object
   */
  private PackageStatus createPackageStatusesCollection(HashMap<Object, Object> response) {
    return PackageStatus.newInstanceFromData(response);
  }

  /**
   * Retrieves the labels for a collection of packages from the client.
   *
   * @param packages the collection of packages to retrieve labels for
   * @return the labels of the packages as a string
   * @throws UnauthorizedException if the request is unauthorized
   * @throws BadRequestException   if the request is invalid
   */
  public String getLabels(OrderedPackageCollection packages) throws UnauthorizedException, BadRequestException {
    return this.client.getLabels(packages.getShipper(), packages.getPackageIds());
  }

  /**
   * Retrieves the services offered by a shipper.
   *
   * @param shipper the shipper object for which services need to be retrieved
   * @return a HashMap representing the services offered by the shipper
   * @throws UnauthorizedException if the user is not authorized to access the shipper's services
   * @throws BadRequestException   if there is an error in the request
   */
  public HashMap<Object, Object> getServices(Shipper shipper) throws UnauthorizedException, BadRequestException {
    return this.client.getServices(shipper);
  }

  /**
   * Retrieves the branches.
   *
   * @return A list of Branch objects representing the branches.
   * @throws UnauthorizedException If the user is not authorized to access the branches.
   * @throws BadRequestException   If there is a problem with the request.
   */
  public ArrayList<Branch> getBranches() throws UnauthorizedException, BadRequestException {
    final ArrayList<Branch> result = new ArrayList<>();
    for (Shipper shipper : this.getShippers()) {
      result.addAll(this.getBranchesForShipper(shipper));
    }
    return result;
  }

  /**
   * Retrieves the branches for the given countries.
   *
   * @param countries A list of country enums representing the countries.
   * @return An ArrayList of Branch objects representing the branches for the given countries.
   * @throws UnauthorizedException If the user is not authorized to access the branches.
   * @throws BadRequestException   If the request is invalid.
   */
  public ArrayList<Branch> getBranchesForCountries(List<CountryEnum> countries) throws UnauthorizedException, BadRequestException {
    final ArrayList<Branch> result = new ArrayList<>();
    for (Shipper shipper : this.getShippers()) {
      result.addAll(this.getBranchesForShipperForCountries(shipper, countries));
    }
    return result;
  }

  /**
   * Retrieves the list of branches for a given shipper.
   *
   * @param shipper the shipper for which to retrieve the branches
   * @return an ArrayList of Branch objects representing the branches for the shipper
   * @throws UnauthorizedException if the user is not authorized to perform this operation
   * @throws BadRequestException   if the request is malformed or invalid
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
   * Retrieves the branches for a shipper based on the specified countries.
   *
   * @param shipper   the shipper to retrieve branches for
   * @param countries the list of countries to filter the branches
   * @return the list of branches that match the shipper and countries
   * @throws UnauthorizedException if the user is not authorized to access the branches
   * @throws BadRequestException   if the request is invalid
   */
  public ArrayList<Branch> getBranchesForShipperForCountries(Shipper shipper, List<CountryEnum> countries) throws UnauthorizedException, BadRequestException {
    ArrayList<Branch> result = new ArrayList<>();
    final ArrayList<String> servicesForShipper = this.getServicesForShipper(shipper);
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
   * Retrieves services available for a shipper.
   *
   * @param shipper The shipper for which to retrieve services.
   * @return The list of services available for the shipper.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is invalid.
   */
  private ArrayList<String> getServicesForShipper(Shipper shipper) throws UnauthorizedException, BadRequestException {
    ArrayList<String> results = new ArrayList<>();
    final HashMap<Object, Object> services = this.getServices(shipper);
    for (Map.Entry<Object, Object> service : services.entrySet()) {
      results.add(String.valueOf((service.getKey())));
    }
    return results;
  }

  /**
   * Retrieves the branches that are available for a given shipper service and countries.
   *
   * @param shipper   The shipper for which to retrieve the branches.
   * @param service   The service type for which to retrieve the branches.
   * @param countries The list of countries for which to retrieve the branches.
   * @return An ArrayList of branches that are available for the shipper service and countries.
   * @throws UnauthorizedException if the request is unauthorized.
   * @throws BadRequestException   if the request is invalid.
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
   * Retrieves all branches for a specific shipper service in multiple countries.
   *
   * @param shipper   the shipper object for which to retrieve branches
   * @param service   the service type for which to retrieve branches
   * @param countries the list of countries for which to retrieve branches
   * @return the array list of branches for the shipper service in the specified countries
   * @throws UnauthorizedException if the user is unauthorized to access the branches
   * @throws BadRequestException   if the request is invalid
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
   * Retrieves the list of branches available for a specific shipper and service type.
   *
   * @param shipper The shipper for which to retrieve the branches.
   * @param service The service type for which to retrieve the branches.
   * @return The list of branches available for the specified shipper and service type.
   * @throws UnauthorizedException If the user is not authorized to access the branches.
   * @throws BadRequestException   If the provided shipper or service type is invalid.
   */
  public ArrayList<Branch> getBranchesForShipperService(Shipper shipper, ServiceType service) throws UnauthorizedException, BadRequestException {
    return getBranchesForShipperService(shipper, service, null);
  }

  /**
   * Retrieves the branches for a specific shipper and service type in the given country.
   *
   * @param shipper The shipper for which to retrieve the branches.
   * @param service The service type for which to retrieve the branches.
   * @param country (optional) The country for which to retrieve the branches. If not specified, all countries will be considered.
   * @return The list of branches for the shipper and service type in the specified country.
   * @throws UnauthorizedException if the user is not authorized to perform this operation.
   * @throws BadRequestException   if the request is invalid or malformed.
   */
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
   * Returns list of countries where service is available in
   *
   * @param shipper the shipper for which to retrieve the countries.
   * @return a HashMap containing the countries available for the shipper.
   * @throws UnauthorizedException if the user is unauthorized to make the request.
   * @throws BadRequestException   if the request is invalid.
   */
  public HashMap<Object, Object> getCountries(Shipper shipper) throws UnauthorizedException, BadRequestException {
    return this.client.getCountries(shipper);
  }

  /**
   * Retrieves the activated services for a specific shipper.
   *
   * @param shipper the shipper for which to retrieve the activated services
   * @return a HashMap containing the activated services, where the key is the service name and the value is the service details
   * @throws UnauthorizedException if the user is not authorized to access the activated services
   * @throws BadRequestException   if the request is invalid
   */
  public HashMap<Object, Object> getActivatedServices(Shipper shipper) throws UnauthorizedException, BadRequestException {
    return this.client.getActivatedServices(shipper);
  }

  /**
   * Retrieves the countries data from the server.
   *
   * @return A HashMap containing the countries data. The key is the country name (String), and the value is an instance of the Country class.
   * @throws UnauthorizedException If the user is not authorized to access the countries data.
   * @throws BadRequestException   If the request to retrieve the countries data is invalid.
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
   * Gets the changelog from the client.
   *
   * @return a HashMap containing the changelog
   * @throws UnauthorizedException if the request is unauthorized
   * @throws BadRequestException   if the request is invalid
   */
  public HashMap<Object, Object> getChangelog() throws UnauthorizedException, BadRequestException {
    return this.client.getChangelog();
  }
}

package cz.balikobot.api.definitions;

/**
 * Balikobot API requests.
 */
public enum Request {
  /**
   * Add a package
   *
   */
  ADD("add"),

  /**
   * Drop a package
   *
   */
  DROP("drop"),

  /**
   * Track a package
   *
   */
  TRACK("track"),

  /**
   * Track a package; get the last brief info
   *
   */
  TRACK_STATUS("trackstatus"),

  /**
   * List of packages
   *
   */
  OVERVIEW("overview"),

  /**
   * Get labels
   *
   */
  LABELS("labels"),

  /**
   * Get the package info
   *
   */
  PACKAGE("package"),

  /**
   * Order shipment
   *
   */
  ORDER("order"),

  /**
   * Get the shipment details
   *
   */
  ORDER_VIEW("orderview"),

  /**
   * Get the shipment pickup details
   *
   */
  ORDER_PICKUP("orderpickup"),

  /**
   * List of offered services
   *
   */
  SERVICES("services"),

  /**
   * List of units for palette shipping
   *
   */
  MANIPULATION_UNITS("manipulationunits"),

  /**
   * List of activated units for palette shipping
   *
   */
  ACTIVATED_MANIPULATION_UNITS("activatedmanipulationunits"),

  /**
   * List of available branches
   *
   */
  BRANCHES("branches"),

  /**
   * List of available branches with details
   *
   */
  FULL_BRANCHES("fullbranches"),

  /**
   * List of available branches with details for given location
   *
   */
  BRANCH_LOCATOR("branchlocator"),

  /**
   * List of services with countries which support cash-on-delivery payment type
   *
   */
  CASH_ON_DELIVERY_COUNTRIES("cod4services"),

  /**
   * List of available countries
   *
   */
  COUNTRIES("countries4service"),

  /**
   * List of available zip codes
   *
   */
  ZIP_CODES("zipcodes"),

  /**
   * Check add-package data
   *
   */
  CHECK("check"),

  /**
   * List of ADR units
   *
   */
  ADR_UNITS("adrunits"),

  /**
   * List of activated services for production API keys
   *
   */
  ACTIVATED_SERVICES("activatedservices"),

  /**
   * Order shipments from place B (typically supplier / previous consignee) to place A (shipping point)
   *
   */
  B2A("b2a"),

  /**
   * Get PDF with signed consignment delivery document by the recipient
   *
   */
  PROOF_OF_DELIVERY("pod"),

  /**
   * Method for obtaining the price of carriage at consignment level
   *
   */
  TRANSPORT_COSTS("transportcosts"),

  /**
   * Method for obtaining information on individual countries of the world
   *
   */
  GET_COUNTRIES_DATA("getCountriesData"),

  /**
   * Method for obtaining news in the Balikobot API
   *
   */
  CHANGELOG("changelog"),

  /**
   * Method for obtaining a list of additional services by individual transport services
   *
   */
  ADD_SERVICE_OPTIONS("addserviceoptions"),

  /**
   * Experimental method for easier carrier integration
   * List of available input attributes for the ADD method of the selected carrier
   *
   */
  ADD_ATTRIBUTES("addattributes");

  public final String label;

  Request(String label) {
    this.label = label;
  }

  public static Request valueOfLabel(String label) {
    for (Request e : values()) {
      if (e.label.equals(label)) {
        return e;
      }
    }
    return null;
  }

}

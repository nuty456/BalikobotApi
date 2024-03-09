package cz.balikobot.api.model.values.pkg;

import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.definitions.ServiceType;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

import java.util.ArrayList;

/**
 * CommonData interface represents a common set of data for a package in the Balikobot system.
 * It provides methods to get and set package properties, such as EID, order number, service type, services, branch ID, and error settings.
 */
public interface CommonData extends OffsetData {

  /**
   * Retrieves the value associated with the specified offset key.
   *
   * @param key The key representing the offset.
   * @return The value at the specified offset key.
   */
  Object offsetGet(Object key);

  /**
   * Checks if the specified offset key exists in the data structure.
   *
   * @param key The key representing the offset.
   * @return true if the specified offset key exists, false otherwise.
   */
  Boolean offsetExists(Object key);

  /**
   * Sets the EID (Electronic Identification) for the CommonData object.
   * The EID is a unique identifier used to identify electronic objects.
   *
   * @param id The EID to be set.
   */
  default void setEID(String id) {
    this.offsetSet(Option.EID.label, id);
  }

  /**
   * Retrieves the Electronic Identification (EID) associated with the CommonData object.
   *
   * @return The Electronic Identification (EID).
   */
  default String getEID() {
    return (String) this.offsetGet(Option.EID.label);
  }

  /**
   * Checks if the current instance has an EID.
   *
   * @return True if the current instance has an EID, false otherwise.
   */
  default Boolean hasEID() {
    return this.offsetExists(Option.EID.label);
  }

  /**
   * Sets the order number for the CommonData object.
   *
   * @param orderNumber The order number to be set.
   */
  default void setOrderNumber(int orderNumber) {
    this.offsetSet(Option.ORDER_NUMBER.label, orderNumber);
  }

  /**
   * Sets the real order ID for the CommonData object.
   *
   * @param realOrderId The real order ID to be set.
   */
  default void setRealOrderId(String realOrderId) {
    this.offsetSet(Option.REAL_ORDER_ID.label, realOrderId);
  }

  /**
   * Sets the service type for the CommonData object.
   *
   * @param serviceType The service type to be set.
   */
  default void setServiceType(ServiceType serviceType) {
    this.offsetSet(Option.SERVICE_TYPE.label, serviceType.label);
  }

  /**
   * Sets the services for the CommonData object.
   *
   * @param services An ArrayList of strings representing the services.
   */
  default void setServices(ArrayList<String> services) {
    // TODO: add validation

    this.offsetSet(Option.SERVICES.label, String.join("+", services));
  }

  /**
   * Sets the branch ID for the CommonData object.
   *
   * @param branchId The branch ID to be set.
   */
  default void setBranchId(String branchId) {
    this.offsetSet(Option.BRANCH_ID.label, branchId);
  }

  /**
   * Sets the flag for returning full error messages.
   */
  default void setReturnFullErrors() {
    setReturnFullErrors(true);
  }

  /**
   * Sets the flag for returning full error messages.
   *
   * @param fullErrors A Boolean value specifying whether to return full error messages or not.
   *                   If fullErrors is true, the method sets the offset with the value 1. Otherwise, it sets the offset with the value 0.
   */
  default void setReturnFullErrors(Boolean fullErrors) {
    this.offsetSet(Option.RETURN_FULL_ERRORS.label, fullErrors ? 1 : 0);
  }

  /**
   * Sets the flag for returning the tracking information of a package.
   * If the returnTrack parameter is true, the method sets the offset with the value 1. Otherwise, it sets the offset with the value 0.
   */
  default void setReturnTrack() {
    setReturnTrack(true);
  }

  /**
   * Sets the flag for returning the tracking information of a package.
   * If the returnTrack parameter is true, the method sets the offset with the value 1. Otherwise, it sets the offset with the value 0.
   *
   * @param returnTrack A Boolean value specifying whether to return the tracking information or not.
   */
  default void setReturnTrack(Boolean returnTrack) {
    this.offsetSet(Option.RETURN_TRACK.label, returnTrack ? 1 : 0);
  }

  /**
   * Sets the flag for returning the final carrier ID.
   */
  default void setReturnFinalCarrierId() {
    setReturnFinalCarrierId(true);
  }

  /**
   * Sets the flag for returning the final carrier ID.
   *
   * @param returnCarrierId A Boolean value specifying whether to return the final carrier ID or not.
   */
  default void setReturnFinalCarrierId(Boolean returnCarrierId) {
    this.offsetSet(Option.RETURN_FINAL_CARRIER_ID.label, returnCarrierId ? 1 : 0);
  }

}

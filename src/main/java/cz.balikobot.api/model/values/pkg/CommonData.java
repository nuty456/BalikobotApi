package cz.balikobot.api.model.values.pkg;

import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.definitions.ServiceType;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

import java.util.ArrayList;
import java.util.stream.Collectors;

public interface CommonData extends OffsetData {

  /**
   * Get an item at a given offset
   *
   * @param key
   * @return mixed
   */
  Object offsetGet(Object key);

  /**
   * Determine if an item exists at an offset
   *
   * @param key
   * @return Boolean
   */
  Boolean offsetExists(Object key);

  /**
   * Set EID
   *
   * @param id
   * @return void
   */
  default void setEID(String id) {
    this.offsetSet(Option.EID.label, id);
  }

  /**
   * Get EID
   *
   * @return String|null
   */
  default String getEID() {
    return (String) this.offsetGet(Option.EID.label);
  }

  /**
   * Get EID
   *
   * @return Boolean
   */
  default Boolean hasEID() {
    return this.offsetExists(Option.EID.label);
  }

  /**
   * @param orderNumber
   * @return void
   */
  default void setOrderNumber(int orderNumber) {
    this.offsetSet(Option.ORDER_NUMBER.label, orderNumber);
  }

  /**
   * @param realOrderId
   * @return void
   */
  default void setRealOrderId(String realOrderId) {
    this.offsetSet(Option.REAL_ORDER_ID.label, realOrderId);
  }

  /**
   * @param serviceType
   * @return void
   */
  default void setServiceType(ServiceType serviceType) {
    this.offsetSet(Option.SERVICE_TYPE.label, serviceType.label);
  }

  /**
   * @param ArrayList<String> services
   * @return void
   */
  default void setServices(ArrayList<String> services) {
    // TODO: add validation

    this.offsetSet(Option.SERVICES.label, services.stream().collect(Collectors.joining("+")));
  }

  /**
   * @param branchId
   * @return void
   */
  default void setBranchId(String branchId) {
    this.offsetSet(Option.BRANCH_ID.label, branchId);
  }

  /**
   * @return void
   */
  default void setReturnFullErrors() {
    setReturnFullErrors(true);
  }

  default void setReturnFullErrors(Boolean fullErrors) {
    this.offsetSet(Option.RETURN_FULL_ERRORS.label, (int) (fullErrors ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setReturnTrack() {
    setReturnTrack(true);
  }

  default void setReturnTrack(Boolean returnTrack) {
    this.offsetSet(Option.RETURN_TRACK.label, (int) (returnTrack ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setReturnFinalCarrierId() {
    setReturnFinalCarrierId(true);
  }

  default void setReturnFinalCarrierId(Boolean returnCarrierId) {
    this.offsetSet(Option.RETURN_FINAL_CARRIER_ID.label, (int) (returnCarrierId ? 1 : 0));
  }

}

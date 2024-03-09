package cz.balikobot.api.model.values.pkg;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

/**
 * This interface represents delivery data for a delivery request. It extends the OffsetData interface.
 * <p>
 * The DeliveryData interface provides methods to set various delivery options such as notes for the driver and the customer,
 * comfort, personal delivery options, PIN, insurance, evening delivery, exworks delivery, account number, zip code, country code,
 * comfort service, comfort service plus, delivery date, swap, swap option, open before payment, test before payment, and general notes.
 *
 * @see OffsetData
 */
public interface DeliveryData extends OffsetData {

  /**
   * Sets the note driver for the delivery.
   *
   * @param noteDriver the note to be set for the driver
   */
  default void setNoteDriver(String noteDriver) {
    this.offsetSet(Option.NOTE_DRIVER.label, noteDriver);
  }

  /**
   * Sets the note for the customer associated with the delivery.
   *
   * @param noteCustomer the note to be set for the customer
   */
  default void setNoteCustomer(String noteCustomer) {
    this.offsetSet(Option.NOTE_CUSTOMER.label, noteCustomer);
  }

  /**
   * Sets the comfort exclusive service for the delivery.
   */
  default void setComfortExclusiveService() {
    setComfortExclusiveService(true);
  }

  /**
   * Sets the comfort exclusive service for the delivery.
   *
   * @param comfortExclusiveService the value indicating whether the delivery has comfort exclusive service
   */
  default void setComfortExclusiveService(Boolean comfortExclusiveService) {
    this.offsetSet(Option.COMFORT_EXCLUSIVE_SERVICE.label, comfortExclusiveService ? 1 : 0);
  }

  /**
   * Sets the personal delivery floor for the delivery.
   */
  default void setPersDeliveryFloor() {
    setPersDeliveryFloor(true);
  }

  /**
   * Sets the value indicating whether the delivery requires personal delivery to a specific floor.
   *
   * @param persDeliveryFloor the value indicating whether the delivery requires personal delivery floor
   */
  default void setPersDeliveryFloor(Boolean persDeliveryFloor) {
    this.offsetSet(Option.PERS_DELIVERY_FLOOR.label, persDeliveryFloor ? 1 : 0);
  }

  /**
   * Sets the value indicating whether the delivery requires personal delivery to a specific building.
   */
  default void setPersDeliveryBuilding() {
    setPersDeliveryBuilding(true);
  }

  /**
   * Sets the value indicating whether the delivery requires personal delivery to a specific building.
   *
   * @param persDeliveryBuilding the value indicating whether the delivery requires personal delivery to a specific building
   */
  default void setPersDeliveryBuilding(Boolean persDeliveryBuilding) {
    this.offsetSet(Option.PERS_DELIVERY_BUILDING.label, persDeliveryBuilding ? 1 : 0);
  }

  /**
   * Sets the value indicating whether the delivery requires personal delivery to a specific department.
   */
  default void setPersDeliveryDepartment() {
    setPersDeliveryDepartment(true);
  }

  /**
   * Sets the value indicating whether the delivery requires personal delivery to a specific department.
   *
   * @param persDeliveryDepartment the value indicating whether the delivery requires personal delivery to a specific department
   */
  default void setPersDeliveryDepartment(Boolean persDeliveryDepartment) {
    this.offsetSet(Option.PERS_DELIVERY_DEPARTMENT.label, persDeliveryDepartment ? 1 : 0);
  }

  /**
   * Sets the PIN for the delivery.
   *
   * @param pin the PIN to be set for the delivery
   */
  default void setPIN(String pin) {
    this.offsetSet(Option.PIN.label, pin);
  }

  /**
   * Sets the value indicating whether Saturday delivery is required for the delivery.
   */
  default void setSatDelivery() {
    setSatDelivery(true);
  }

  /**
   * Sets the value indicating whether Saturday delivery is required for the delivery.
   *
   * @param satDelivery the value indicating whether Saturday delivery is required
   */
  default void setSatDelivery(Boolean satDelivery) {
    this.offsetSet(Option.SAT_DELIVERY.label, satDelivery ? 1 : 0);
  }

  /**
   * Sets the value indicating whether the delivery requires full age verification.
   */
  default void setRequireFullAge() {
    setRequireFullAge(true);
  }

  /**
   * Sets the value indicating whether the delivery requires full age verification.
   *
   * @param requireFullAge the value indicating whether full age verification is required
   */
  default void setRequireFullAge(Boolean requireFullAge) {
    this.offsetSet(Option.REQUIRE_FULL_AGE.label, requireFullAge ? 1 : 0);
  }

  /**
   * Sets the full age minimum for the delivery.
   *
   * @param fullAgeMinimum the full age minimum to be set for the delivery
   *
   * @throws NullPointerException if fullAgeMinimum is null
   */
  default void setFullAgeMinimum(String fullAgeMinimum) {
    this.offsetSet(Option.FULL_AGE_MINIMUM.label, fullAgeMinimum);
  }

  /**
   * Sets the value indicating whether the delivery requires full age data.
   *
   * @param fullAgeData the value indicating whether full age data is required
   */
  default void setFullAgeData(String fullAgeData) {
    this.offsetSet(Option.FULL_AGE_DATA.label, fullAgeData);
  }

  /**
   * Sets the password for the delivery.
   *
   * @param password the password to be set for the delivery
   */
  default void setPassword(String password) {
    this.offsetSet(Option.PASSWORD.label, password);
  }

  /**
   * Sets the delivery insurance for the delivery.
   */
  default void setDelInsurance() {
    setDelInsurance(true);
  }

  /**
   * Sets the value indicating whether the delivery has insurance.
   *
   * @param delInsurance the value indicating whether the delivery has insurance
   */
  default void setDelInsurance(Boolean delInsurance) {
    this.offsetSet(Option.DEL_INSURANCE.label, delInsurance ? 1 : 0);
  }

  /**
   * Sets the boolean value indicating whether evening delivery is required for the delivery.
   */
  default void setDelEvening() {
    setDelEvening(true);
  }

  /**
   * Sets the value indicating whether evening delivery is required for the delivery.
   *
   * @param delEvening the boolean value indicating whether evening delivery is required
   */
  default void setDelEvening(Boolean delEvening) {
    this.offsetSet(Option.DEL_EVENING.label, delEvening ? 1 : 0);
  }

  /**
   * Sets the value indicating whether the delivery is ex works.
   */
  default void setDelExworks() {
    setDelExworks(true);
  }

  /**
   * Sets the value indicating whether the delivery is ex works.
   *
   * @param delExworks the value indicating whether the delivery is ex works
   */
  default void setDelExworks(Boolean delExworks) {
    this.offsetSet(Option.DEL_EXWORKS.label, delExworks ? 1 : 0);
  }

  /**
   * Sets the delivery account number for the delivery.
   *
   * @param delAccountNumber the account number to be set for the delivery
   */
  default void setDelAccountNumber(String delAccountNumber) {
    this.offsetSet(Option.DEL_EXWORKS_ACCOUNT_NUMBER.label, delAccountNumber);
  }

  /**
   * Sets the delivery ZIP code for the delivery.
   *
   * @param delZip the ZIP code to be set for the delivery
   */
  default void setDelZip(String delZip) {
    this.offsetSet(Option.DEL_EXWORKS_ZIP.label, delZip);
  }

  /**
   * Sets the delivery country code for the delivery.
   *
   * @param countryCode the country code to be set for the delivery
   */
  default void setDelCountryCode(String countryCode) {
    this.offsetSet(Option.DEL_EXWORKS_COUNTRY_CODE.label, countryCode);
  }

  /**
   * Sets the comfort service for the delivery.
   */
  default void setComfortService() {
    setComfortService(true);
  }

  /**
   * Sets the value indicating whether the delivery has comfort service.
   *
   * @param comfort the value indicating whether the delivery has comfort service
   */
  default void setComfortService(Boolean comfort) {
    this.offsetSet(Option.COMFORT_SERVICE.label, comfort ? 1 : 0);
  }

  /**
   * Sets the Comfort Service Plus for the delivery.
   */
  default void setComfortServicePlus() {
    setComfortServicePlus(true);
  }

  /**
   * Sets the Comfort Service Plus for the delivery.
   *
   * @param comfort the value indicating whether the delivery has Comfort Service Plus
   */
  default void setComfortServicePlus(Boolean comfort) {
    this.offsetSet(Option.COMFORT_SERVICE_PLUS.label, comfort ? 1 : 0);
  }

  /**
   * Sets the delivery date for the delivery.
   *
   * @param deliveryDate the delivery date to be set for the delivery
   */
  default void setDeliveryDate(DateTime deliveryDate) {
    this.offsetSet(Option.DELIVERY_DATE.label, DateTimeFormat.forPattern("yyyy-MM-dd").print(deliveryDate));
  }

  /**
   * Sets the value indicating whether the delivery requires a swap option.
   */
  default void setSwap() {
    setSwap(true);
  }

  /**
   * Sets the value indicating whether the delivery requires a swap option.
   *
   * @param swap the value indicating whether the delivery requires a swap option
   */
  default void setSwap(Boolean swap) {
    this.offsetSet(Option.SWAP.label, swap ? 1 : 0);
  }

  /**
   * Sets the swap option for the delivery.
   *
   * @param swapOption the swap option to be set for the delivery
   */
  default void setSwapOption(String swapOption) {
    this.offsetSet(Option.SWAP_OPTION.label, swapOption);
  }

  /**
   * Sets whether the delivery should be opened before payment.
   */
  default void setOpenBeforePayment() {
    setOpenBeforePayment(true);
  }

  /**
   * Sets whether the delivery should be opened before payment.
   *
   * @param openBeforePayment the value indicating whether the delivery should be opened before payment
   */
  default void setOpenBeforePayment(Boolean openBeforePayment) {
    this.offsetSet(Option.OPEN_BEFORE_PAYMENT.label, openBeforePayment ? 1 : 0);
  }

  /**
   * Sets whether the delivery should be tested before payment.
   */
  default void setTestBeforePayment() {
    setTestBeforePayment(true);
  }

  /**
   * Sets the value indicating whether the delivery should be tested before payment.
   *
   * @param testBeforePayment the value indicating whether the delivery should be tested before payment
   */
  default void setTestBeforePayment(Boolean testBeforePayment) {
    this.offsetSet(Option.TEST_BEFORE_PAYMENT.label, testBeforePayment ? 1 : 0);
  }

  /**
   * Sets the note for the delivery.
   *
   * @param note the note to be set for the delivery
   */
  default void setNote(String note) {
    this.offsetSet(Option.NOTE.label, note);
  }

  /**
   * Sets the recipient house number for the delivery.
   *
   * @param recHouseNumber the house number to be set for the recipient
   */
  default void setRecHouseNumber(String recHouseNumber) {
    this.offsetSet(Option.REC_HOUSE_NUMBER.label, recHouseNumber);
  }

  /**
   * Sets the recording block for the delivery.
   *
   * @param recBlock the recording block to be set for the delivery
   */
  default void setRecBlock(String recBlock) {
    this.offsetSet(Option.REC_BLOCK.label, recBlock);
  }

  /**
   * Sets the record entrance value.
   */
  default void setRecEnterance(String recEnteracne) {
    this.offsetSet(Option.REC_ENTERANCE.label, recEnteracne);
  }

  /**
   * Set the floor of the current record.
   *
   * @param recFloor the floor to be set
   */
  default void setFloor(String recFloor) {
    this.offsetSet(Option.REC_FLOOR.label, recFloor);
  }

  /**
   * Sets the flat number for the record.
   *
   * @param recFlatNumber the flat number to be set for the record
   */
  default void setFlatNumber(String recFlatNumber) {
    this.offsetSet(Option.REC_FLAT_NUMBER.label, recFlatNumber);
  }

  /**
   * Sets the delivery costs for an option.
   *
   * @param deliveryCosts the delivery costs to be set
   */
  default void setDeliveryCosts(Double deliveryCosts) {
    this.offsetSet(Option.DELIVERY_COSTS.label, deliveryCosts);
  }

  /**
   * Sets the delivery costs in Euros.
   *
   * @param deliveryCosts The delivery costs in Euros.
   */
  default void setDeliveryCostsEUR(Double deliveryCosts) {
    this.offsetSet(Option.DELIVERY_COSTS_EUR.label, deliveryCosts);
  }

  /**
   * Sets the pickup date for an item.
   *
   * @param pickupDate the pickup date to be set for the item
   */
  default void setPickupDate(DateTime pickupDate) {
    this.offsetSet(Option.PICKUP_DATE.label, DateTimeFormat.forPattern("yyyy-MM-dd").print(pickupDate));
  }

  /**
   * Sets the pickup time from the specified DateTime value.
   *
   * @param pickupTimeFrom the pickup time from as a DateTime value
   */
  default void setPickupTimeFrom(DateTime pickupTimeFrom) {
    this.offsetSet(Option.PICKUP_TIME_FROM.label, DateTimeFormat.forPattern("HH:mm").print(pickupTimeFrom));
  }

  /**
   * Sets the pickup time to the specified DateTime.
   *
   * @param pickupTimeTo the DateTime representing the pickup time to set
   */
  default void setPickupTimeTo(DateTime pickupTimeTo) {
    this.offsetSet(Option.PICKUP_TIME_TO.label, DateTimeFormat.forPattern("HH:mm").print(pickupTimeTo));
  }

  /**
   * Sets the declaration comments to the specified value.
   *
   * @param value the new declaration comments
   */
  default void setDeclarationComments(String value) {
    this.offsetSet(Option.DECLARATION_COMMENTS.label, value);
  }

  /**
   * Sets the discount for declaration charges.
   *
   * @param value the discount value to be set
   */
  default void setDeclarationChargesDiscount(Double value) {
    this.offsetSet(Option.DECLARATION_CHARGES_DISCOUNT.label, value);
  }

  /**
   * Sets the value of declaration insurance charges.
   *
   * @param value the value of declaration insurance charges to set
   */
  default void setDeclarationInsuranceCharges(Double value) {
    this.offsetSet(Option.DECLARATION_INSURANCE_CHARGES.label, value);
  }

  /**
   * Sets the value of declaration other charges.
   *
   * @param value the value to set for declaration other charges
   */
  default void setDeclarationOtherCharges(Double value) {
    this.offsetSet(Option.DECLARATION_OTHER_CHARGES.label, value);
  }

  /**
   * Sets the declaration transport charges for the delivery.
   *
   * @param value the value representing the transport charges for the delivery
   */
  default void setDeclarationTransportCharges(Double value) {
    this.offsetSet(Option.DECLARATION_TRANSPORT_CHARGES.label, value);
  }

  /**
   * Sets the value indicating whether the delivery package contains alcohol.
   *
   * @param value the boolean value indicating whether the package contains alcohol
   */
  default void setIsAlcohol(Boolean value) {
    this.offsetSet(Option.IS_ALCOHOL.label, value);
  }
}

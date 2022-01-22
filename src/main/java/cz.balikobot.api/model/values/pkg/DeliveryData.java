package cz.balikobot.api.model.values.pkg;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

public interface DeliveryData extends OffsetData {

  /**
   * @param noteDriver
   * @return void
   */
  default void setNoteDriver(String noteDriver) {
    this.offsetSet(Option.NOTE_DRIVER.label, noteDriver);
  }

  /**
   * @param noteCustomer
   * @return void
   */
  default void setNoteCustomer(String noteCustomer) {
    this.offsetSet(Option.NOTE_CUSTOMER.label, noteCustomer);
  }

  /**
   * @return void
   */
  default void setComfortExclusiveService() {
    setComfortExclusiveService(true);
  }

  /**
   * @param comfortExclusiveService
   * @return void
   */
  default void setComfortExclusiveService(Boolean comfortExclusiveService) {
    this.offsetSet(Option.COMFORT_EXCLUSIVE_SERVICE.label, (int) (comfortExclusiveService ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setPersDeliveryFloor() {
    setPersDeliveryFloor(true);
  }

  /**
   * @param persDeliveryFloor
   * @return void
   */
  default void setPersDeliveryFloor(Boolean persDeliveryFloor) {
    this.offsetSet(Option.PERS_DELIVERY_FLOOR.label, (int) (persDeliveryFloor ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setPersDeliveryBuilding() {
    setPersDeliveryBuilding(true);
  }

  /**
   * @param persDeliveryBuilding
   * @return void
   */
  default void setPersDeliveryBuilding(Boolean persDeliveryBuilding) {
    this.offsetSet(Option.PERS_DELIVERY_BUILDING.label, (int) (persDeliveryBuilding ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setPersDeliveryDepartment() {
    setPersDeliveryDepartment(true);
  }

  /**
   * @param persDeliveryDepartment
   * @return void
   */
  default void setPersDeliveryDepartment(Boolean persDeliveryDepartment) {
    this.offsetSet(Option.PERS_DELIVERY_DEPARTMENT.label, (int) (persDeliveryDepartment ? 1 : 0));
  }

  /**
   * @param pin
   * @return void
   */
  default void setPIN(String pin) {
    this.offsetSet(Option.PIN.label, pin);
  }

  /**
   * @return void
   */
  default void setSatDelivery() {
    setSatDelivery(true);
  }

  /**
   * @param satDelivery
   * @return void
   */
  default void setSatDelivery(Boolean satDelivery) {
    this.offsetSet(Option.SAT_DELIVERY.label, (int) (satDelivery ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setRequireFullAge() {
    setRequireFullAge(true);
  }

  /**
   * @param requireFullAge
   * @return void
   */
  default void setRequireFullAge(Boolean requireFullAge) {
    this.offsetSet(Option.REQUIRE_FULL_AGE.label, (int) (requireFullAge ? 1 : 0));
  }

  /**
   * @param fullAgeMinimum
   * @return void
   */
  default void setFullAgeMinimum(String fullAgeMinimum) {
    this.offsetSet(Option.FULL_AGE_MINIMUM.label, fullAgeMinimum);
  }

  /**
   * @param fullAgeData
   * @return void
   */
  default void setFullAgeData(String fullAgeData) {
    this.offsetSet(Option.FULL_AGE_DATA.label, fullAgeData);
  }

  /**
   * @param password
   * @return void
   */
  default void setPassword(String password) {
    this.offsetSet(Option.PASSWORD.label, password);
  }

  /**
   * @return void
   */
  default void setDelInsurance() {
    setDelInsurance(true);
  }

  /**
   * @param delInsurance
   * @return void
   */
  default void setDelInsurance(Boolean delInsurance) {
    this.offsetSet(Option.DEL_INSURANCE.label, (int) (delInsurance ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setDelEvening() {
    setDelEvening(true);
  }

  /**
   * @param delEvening
   * @return void
   */
  default void setDelEvening(Boolean delEvening) {
    this.offsetSet(Option.DEL_EVENING.label, (int) (delEvening ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setDelExworks() {
    setDelExworks(true);
  }

  /**
   * @param delExworks
   * @return void
   */
  default void setDelExworks(Boolean delExworks) {
    this.offsetSet(Option.DEL_EXWORKS.label, (int) (delExworks ? 1 : 0));
  }

  /**
   * @param delAccountNumber
   * @return void
   */
  default void setDelAccountNumber(String delAccountNumber) {
    this.offsetSet(Option.DEL_EXWORKS_ACCOUNT_NUMBER.label, delAccountNumber);
  }

  /**
   * @param delZip
   * @return void
   */
  default void setDelZip(String delZip) {
    this.offsetSet(Option.DEL_EXWORKS_ZIP.label, delZip);
  }

  /**
   * @param countryCode
   * @return void
   */
  default void setDelCountryCode(String countryCode) {
    this.offsetSet(Option.DEL_EXWORKS_COUNTRY_CODE.label, countryCode);
  }

  /**
   * @return void
   */
  default void setComfortService() {
    setComfortService(true);
  }

  /**
   * @param comfort
   * @return void
   */
  default void setComfortService(Boolean comfort) {
    this.offsetSet(Option.COMFORT_SERVICE.label, (int) (comfort ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setComfortServicePlus() {
    setComfortServicePlus(true);
  }

  /**
   * @param comfort
   * @return void
   */
  default void setComfortServicePlus(Boolean comfort) {
    this.offsetSet(Option.COMFORT_SERVICE_PLUS.label, (int) (comfort ? 1 : 0));
  }

  /**
   * @param \DateTime deliveryDate
   * @return void
   */
  default void setDeliveryDate(DateTime deliveryDate) {
    this.offsetSet(Option.DELIVERY_DATE.label, DateTimeFormat.forPattern("yyyy-MM-dd").print(deliveryDate));
  }

  /**
   * @return void
   */
  default void setSwap() {
    setSwap(true);
  }

  /**
   * @param swap
   * @return void
   */
  default void setSwap(Boolean swap) {
    this.offsetSet(Option.SWAP.label, (int) (swap ? 1 : 0));
  }

  /**
   * @param swapOption
   * @return void
   */
  default void setSwapOption(String swapOption) {
    this.offsetSet(Option.SWAP_OPTION.label, swapOption);
  }

  /**
   * @return void
   */
  default void setOpenBeforePayment() {
    setOpenBeforePayment(true);
  }

  /**
   * @param openBeforePayment
   * @return void
   */
  default void setOpenBeforePayment(Boolean openBeforePayment) {
    this.offsetSet(Option.OPEN_BEFORE_PAYMENT.label, (int) (openBeforePayment ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setTestBeforePayment() {
    setTestBeforePayment(true);
  }

  /**
   * @param testBeforePayment
   * @return void
   */
  default void setTestBeforePayment(Boolean testBeforePayment) {
    this.offsetSet(Option.TEST_BEFORE_PAYMENT.label, (int) (testBeforePayment ? 1 : 0));
  }

  /**
   * @param note
   * @return void
   */
  default void setNote(String note) {
    this.offsetSet(Option.NOTE.label, note);
  }

  /**
   * @param recHouseNumber
   * @return void
   */
  default void setRecHouseNumber(String recHouseNumber) {
    this.offsetSet(Option.REC_HOUSE_NUMBER.label, recHouseNumber);
  }

  /**
   * @param recBlock
   * @return void
   */
  default void setRecBlock(String recBlock) {
    this.offsetSet(Option.REC_BLOCK.label, recBlock);
  }

  /**
   * @param recEnteracne
   * @return void
   */
  default void setRecEnterance(String recEnteracne) {
    this.offsetSet(Option.REC_ENTERANCE.label, recEnteracne);
  }

  /**
   * @param recFloor
   * @return void
   */
  default void setFloor(String recFloor) {
    this.offsetSet(Option.REC_FLOOR.label, recFloor);
  }

  /**
   * @param recFlatNumber
   * @return void
   */
  default void setFlatNumber(String recFlatNumber) {
    this.offsetSet(Option.REC_FLAT_NUMBER.label, recFlatNumber);
  }

  /**
   * @param deliveryCosts
   * @return void
   */
  default void setDeliveryCosts(Double deliveryCosts) {
    this.offsetSet(Option.DELIVERY_COSTS.label, deliveryCosts);
  }

  /**
   * @param deliveryCosts
   * @return void
   */
  default void setDeliveryCostsEUR(Double deliveryCosts) {
    this.offsetSet(Option.DELIVERY_COSTS_EUR.label, deliveryCosts);
  }

  /**
   * @param \DateTime pickupDate
   * @return void
   */
  default void setPickupDate(DateTime pickupDate) {
    this.offsetSet(Option.PICKUP_DATE.label, DateTimeFormat.forPattern("yyyy-MM-dd").print(pickupDate));
  }

  /**
   * @param \DateTime pickupTimeFrom
   * @return void
   */
  default void setPickupTimeFrom(DateTime pickupTimeFrom) {
    this.offsetSet(Option.PICKUP_TIME_FROM.label, DateTimeFormat.forPattern("HH:mm").print(pickupTimeFrom));
  }

  /**
   * @param \DateTime pickupTimeTo
   * @return void
   */
  default void setPickupTimeTo(DateTime pickupTimeTo) {
    this.offsetSet(Option.PICKUP_TIME_TO.label, DateTimeFormat.forPattern("HH:mm").print(pickupTimeTo));
  }

  /**
   * @param value
   * @return void
   */
  default void setDeclarationComments(String value) {
    this.offsetSet(Option.DECLARATION_COMMENTS.label, value);
  }

  /**
   * @param value
   * @return void
   */
  default void setDeclarationChargesDiscount(Double value) {
    this.offsetSet(Option.DECLARATION_CHARGES_DISCOUNT.label, value);
  }

  /**
   * @param value
   * @return void
   */
  default void setDeclarationInsuranceCharges(Double value) {
    this.offsetSet(Option.DECLARATION_INSURANCE_CHARGES.label, value);
  }

  /**
   * @param value
   * @return void
   */
  default void setDeclarationOtherCharges(Double value) {
    this.offsetSet(Option.DECLARATION_OTHER_CHARGES.label, value);
  }

  /**
   * @param value
   * @return void
   */
  default void setDeclarationTransportCharges(Double value) {
    this.offsetSet(Option.DECLARATION_TRANSPORT_CHARGES.label, value);
  }

  /**
   * @param value
   * @return void
   */
  default void setIsAlcohol(Boolean value) {
    this.offsetSet(Option.IS_ALCOHOL.label, value);
  }
}

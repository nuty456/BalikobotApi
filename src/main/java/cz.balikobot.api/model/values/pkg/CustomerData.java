package cz.balikobot.api.model.values.pkg;

import cz.balikobot.api.definitions.CountryEnum;
import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

/**
 * Represents a class that provides customer data for setting customer information.
 * Extends the OffsetData interface to provide the ability to set item values at specific offsets.
 */
public interface CustomerData extends OffsetData {

  /**
   * Sets the customer's name for the customer record.
   *
   * @param name the name of the customer
   */
  default void setRecName(String name) {
    this.offsetSet(Option.REC_NAME.label, name);
  }

  /**
   * Sets the firm name for the customer record.
   *
   * @param firm the firm name
   */
  default void setRecFirm(String firm) {
    this.offsetSet(Option.REC_FIRM.label, firm);
  }

  /**
   * Sets the street for the customer record.
   *
   * @param street the street of the customer
   */
  default void setRecStreet(String street) {
    this.offsetSet(Option.REC_STREET.label, street);
  }

  /**
   * Sets the city for the customer record.
   *
   * @param city the city of the customer
   */
  default void setRecCity(String city) {
    this.offsetSet(Option.REC_CITY.label, city);
  }

  /**
   * Sets the zip code for the customer record.
   *
   * @param zip the zip code of the customer
   */
  default void setRecZip(String zip) {
    this.offsetSet(Option.REC_ZIP.label, zip);
  }

  /**
   * Sets the recommended region for the customer record.
   *
   * @param recRegion the recommended region for the customer
   */
  default void setRecRegion(String recRegion) {
    this.offsetSet(Option.REC_REGION.label, recRegion);
  }

  /**
   * Sets the recommended country for the customer record.
   *
   * @param country the recommended country
   */
  default void setRecCountry(CountryEnum country) {
    this.offsetSet(Option.REC_COUNTRY.label, country.label);
  }

  /**
   * Sets the recommended locale ID for the customer record.
   *
   * @param localeId the recommended locale ID
   */
  default void setRecLocaleId(String localeId) {
    this.offsetSet(Option.REC_LOCALE_ID.label, localeId);
  }

  /**
   * Sets the recommended email for the customer record.
   *
   * @param email the recommended email
   */
  default void setRecEmail(String email) {
    this.offsetSet(Option.REC_EMAIL.label, email);
  }

  /**
   * Sets the recommended phone number for the customer record.
   *
   * @param phone the recommended phone number
   */
  default void setRecPhone(String phone) {
    this.offsetSet(Option.REC_PHONE.label, phone);
  }

  /**
   * Sets the bank account number for the customer record.
   *
   * @param bankAccount the bank account number to be set
   */
  default void setBankAccountNumber(String bankAccount) {
    this.offsetSet(Option.BANK_ACCOUNT_NUMBER.label, bankAccount);
  }

  /**
   * Sets the bank code for the customer record.
   *
   * @param bankCode the bank code to be set for the customer
   */
  default void setBankCode(String bankCode) {
    this.offsetSet(Option.BANK_CODE.label, bankCode);
  }

  /**
   * Sets the patronymum part of the customer's recommended name in the customer record.
   *
   * @param recNamePatronymum the patronymum part of the customer's recommended name
   */
  default void setRecNamePatronymum(String recNamePatronymum) {
    this.offsetSet(Option.REC_NAME_PATRONYMUM.label, recNamePatronymum);
  }

  /**
   * Sets the recommended ID for the customer record.
   *
   * @param id the recommended ID for the customer
   */
  default void setRecId(String id) {
    this.offsetSet(Option.REC_ID.label, id);
  }
}

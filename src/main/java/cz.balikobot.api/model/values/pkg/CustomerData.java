package cz.balikobot.api.model.values.pkg;

import cz.balikobot.api.definitions.CountryEnum;
import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

public interface CustomerData extends OffsetData {

  /**
   * @param name
   * @return void
   */
  default void setRecName(String name) {
    this.offsetSet(Option.REC_NAME.label, name);
  }

  /**
   * @param firm
   * @return void
   */
  default void setRecFirm(String firm) {
    this.offsetSet(Option.REC_FIRM.label, firm);
  }

  /**
   * @param street
   * @return void
   */
  default void setRecStreet(String street) {
    this.offsetSet(Option.REC_STREET.label, street);
  }

  /**
   * @param city
   * @return void
   */
  default void setRecCity(String city) {
    this.offsetSet(Option.REC_CITY.label, city);
  }

  /**
   * @param zip
   * @return void
   */
  default void setRecZip(String zip) {
    this.offsetSet(Option.REC_ZIP.label, zip);
  }

  /**
   * @param recRegion
   * @return void
   */
  default void setRecRegion(String recRegion) {
    this.offsetSet(Option.REC_REGION.label, recRegion);
  }

  /**
   * @param country
   * @return void
   */
  default void setRecCountry(CountryEnum country) {
    this.offsetSet(Option.REC_COUNTRY.label, country.label);
  }

  /**
   * @param localeId
   * @return void
   */
  default void setRecLocaleId(String localeId) {
    this.offsetSet(Option.REC_LOCALE_ID.label, localeId);
  }

  /**
   * @param email
   * @return void
   */
  default void setRecEmail(String email) {
    this.offsetSet(Option.REC_EMAIL.label, email);
  }

  /**
   * @param phone
   * @return void
   */
  default void setRecPhone(String phone) {
    this.offsetSet(Option.REC_PHONE.label, phone);
  }

  /**
   * @param bankAccount
   * @return void
   */
  default void setBankAccountNumber(String bankAccount) {
    this.offsetSet(Option.BANK_ACCOUNT_NUMBER.label, bankAccount);
  }

  /**
   * @param bankCode
   * @return void
   */
  default void setBankCode(String bankCode) {
    this.offsetSet(Option.BANK_CODE.label, bankCode);
  }

  /**
   * @param recNamePatronymum
   * @return void
   */
  default void setRecNamePatronymum(String recNamePatronymum) {
    this.offsetSet(Option.REC_NAME_PATRONYMUM.label, recNamePatronymum);
  }

  /**
   * @param id
   * @return void
   */
  default void setRecId(String id) {
    this.offsetSet(Option.REC_ID.label, id);
  }
}

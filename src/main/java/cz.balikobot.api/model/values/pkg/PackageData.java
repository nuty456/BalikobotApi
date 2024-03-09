package cz.balikobot.api.model.values.pkg;

import cz.balikobot.api.definitions.Currency;
import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

/**
 * Represents a package in the Balikobot system.
 * Extends the OffsetData interface to provide offset-based data setting functionality.
 */
public interface PackageData extends OffsetData {

  /**
   * Sets the width of the package.
   *
   * @param width The width to be set
   */
  default void setWidth(Double width) {
    this.offsetSet(Option.WIDTH.label, width);
  }

  /**
   * Sets the length of the package.
   *
   * @param length The length to be set
   */
  default void setLength(Double length) {
    this.offsetSet(Option.LENGTH.label, length);
  }

  /**
   * Sets the height of the package.
   *
   * @param height The height to be set
   */
  default void setHeight(Double height) {
    this.offsetSet(Option.HEIGHT.label, height);
  }

  /**
   * Sets the weight of the package.
   *
   * @param weight The weight to be set
   */
  default void setWeight(Double weight) {
    this.offsetSet(Option.WEIGHT.label, weight);
  }

  /**
   * Sets the price of the package.
   *
   * @param price The price to be set
   */
  default void setPrice(Double price) {
    this.offsetSet(Option.PRICE.label, price);
  }

  /**
   * Sets the volume of the package.
   *
   * @param volume The volume to be set
   */
  default void setVolume(Double volume) {
    this.offsetSet(Option.VOLUME.label, volume);
  }

  /**
   * Sets the over-dimension flag for the package.
   */
  default void setOverDimension() {
    setOverDimension(true);
  }

  /**
   * Sets the over-dimension flag for the package.
   *
   * @param overDimension The flag indicating if the package is over dimension or not
   */
  default void setOverDimension(Boolean overDimension) {
    this.offsetSet(Option.OVER_DIMENSION.label, overDimension ? 1 : 0);
  }

  /**
   * Sets the insurance currency for the package.
   *
   * @param currency The currency to be set for insurance
   */
  default void setInsCurrency(Currency currency) {
    this.offsetSet(Option.INS_CURRENCY.label, currency.label);
  }

}

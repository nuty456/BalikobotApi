package cz.balikobot.api.model.values.pkg;

import cz.balikobot.api.definitions.Currency;
import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

public interface PackageData extends OffsetData {

  /**
   * @param width
   * @return void
   */
  default void setWidth(Double width) {
    this.offsetSet(Option.WIDTH.label, width);
  }

  /**
   * @param length
   * @return void
   */
  default void setLength(Double length) {
    this.offsetSet(Option.LENGTH.label, length);
  }

  /**
   * @param height
   * @return void
   */
  default void setHeight(Double height) {
    this.offsetSet(Option.HEIGHT.label, height);
  }

  /**
   * @param weight
   * @return void
   */
  default void setWeight(Double weight) {
    this.offsetSet(Option.WEIGHT.label, weight);
  }

  /**
   * @param price
   * @return void
   */
  default void setPrice(Double price) {
    this.offsetSet(Option.PRICE.label, price);
  }

  /**
   * @param volume
   * @return void
   */
  default void setVolume(Double volume) {
    this.offsetSet(Option.VOLUME.label, volume);
  }

  /**
   * @return void
   */
  default void setOverDimension() {
    setOverDimension(true);
  }

  /**
   * @param overDimension
   */
  default void setOverDimension(Boolean overDimension) {
    this.offsetSet(Option.OVER_DIMENSION.label, (int) (overDimension ? 1 : 0));
  }

  /**
   * @param currency
   * @return void
   */
  default void setInsCurrency(Currency currency) {
    this.offsetSet(Option.INS_CURRENCY.label, currency.label);
  }

}

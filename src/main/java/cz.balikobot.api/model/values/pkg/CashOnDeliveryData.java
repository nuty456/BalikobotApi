package cz.balikobot.api.model.values.pkg;

import cz.balikobot.api.definitions.Currency;
import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

/**
 * Represents a class that provides data for Cash on Delivery (COD) payments.
 * It extends the OffsetData interface.
 */
public interface CashOnDeliveryData extends OffsetData {
  /**
   * Sets the Cash on Delivery (COD) price.
   *
   * @param codPrice the price of the COD payment
   */
  default void setCodPrice(Double codPrice) {
    this.offsetSet(Option.COD_PRICE.label, codPrice);
  }

  /**
   * Sets the currency for Cash on Delivery (COD) payments.
   *
   * @param codCurrency the currency to be set for COD payments
   */
  default void setCodCurrency(Currency codCurrency) {
    this.offsetSet(Option.COD_CURRENCY.label, codCurrency.label);
  }

  /**
   * Sets the value for the variable symbol (VS).
   *
   * @param vs the value to be set for the variable symbol
   */
  default void setVS(String vs) {
    this.offsetSet(Option.VS.label, vs);
  }

  /**
   * Sets the value for the credit card option.
   *
   * @param creditCard the value to be set for the credit card option
   *                   - true to enable credit card payment
   *                   - false to disable credit card payment
   */
  default void setCreditCard(Boolean creditCard) {
    this.offsetSet(Option.CREDIT_CARD.label, creditCard ? 1 : 0);
  }

}

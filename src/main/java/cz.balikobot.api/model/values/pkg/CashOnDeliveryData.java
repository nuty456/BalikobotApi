package cz.balikobot.api.model.values.pkg;

import cz.balikobot.api.definitions.Currency;
import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

public interface CashOnDeliveryData extends OffsetData {
  /**
   * @param codPrice
   * @return void
   */
  default void setCodPrice(Double codPrice) {
    this.offsetSet(Option.COD_PRICE.label, codPrice);
  }

  /**
   * @param codCurrency
   * @return void
   */
  default void setCodCurrency(Currency codCurrency) {
    this.offsetSet(Option.COD_CURRENCY.label, codCurrency.label);
  }

  /**
   * @param vs
   * @return void
   */
  default void setVS(String vs) {
    this.offsetSet(Option.VS.label, vs);
  }

  /**
   * @param creditCard
   * @return void
   */
  default void setCreditCard(Boolean creditCard) {
    this.offsetSet(Option.CREDIT_CARD.label, (int) (creditCard ? 1 : 0));
  }

}

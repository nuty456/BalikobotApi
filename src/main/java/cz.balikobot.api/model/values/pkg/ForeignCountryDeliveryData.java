package cz.balikobot.api.model.values.pkg;


import java.util.ArrayList;

import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

/**
 * Represents delivery data for foreign countries.
 * It extends the OffsetData interface.
 * This interface provides methods to set various attributes related to foreign country delivery.
 */
public interface ForeignCountryDeliveryData extends OffsetData {

  /**
   * Sets the invoice number for foreign country delivery data.
   *
   * @param invoiceNumber The invoice number to set.
   */
  default void setInvoiceNumber(String invoiceNumber) {
    this.offsetSet(Option.INVOICE_NUMBER.label, invoiceNumber);
  }

  /**
   * Sets the invoice PDF for foreign country delivery data.
   *
   * @param pdf The invoice PDF to set.
   */
  default void setInvoicePDF(String pdf) {
    this.offsetSet(Option.INVOICE_PDF.label, pdf);
  }

  /**
   * Sets the terms of trade for foreign country delivery data.
   *
   * @param terms The terms of trade to set.
   */
  default void setTermsOfTrade(String terms) {
    this.offsetSet(Option.TERMS_OF_TRADE.label, terms);
  }

  /**
   * Sets the content data for foreign country delivery.
   *
   * @param contentData The data representing the content of the delivery.
   */
  default void setContentData(ArrayList<String> contentData) {
    this.offsetSet(Option.CONTENT_DATA.label, contentData);
  }

}

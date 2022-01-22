package cz.balikobot.api.model.values.pkg;


import java.util.ArrayList;

import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

public interface ForeignCountryDeliveryData extends OffsetData {

  /**
   * @param invoiceNumber
   * @return void
   */
  default void setInvoiceNumber(String invoiceNumber) {
    this.offsetSet(Option.INVOICE_NUMBER.label, invoiceNumber);
  }

  /**
   * @param pdf
   * @return void
   */
  default void setInvoicePDF(String pdf) {
    this.offsetSet(Option.INVOICE_PDF.label, pdf);
  }

  /**
   * @param terms
   * @return void
   */
  default void setTermsOfTrade(String terms) {
    this.offsetSet(Option.TERMS_OF_TRADE.label, terms);
  }

  /**
   * @param contentData
   * @return void
   */
  default void setContentData(ArrayList<String> contentData) {
    this.offsetSet(Option.CONTENT_DATA.label, contentData);
  }

}

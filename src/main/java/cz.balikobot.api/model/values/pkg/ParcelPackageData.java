package cz.balikobot.api.model.values.pkg;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

public interface ParcelPackageData extends OffsetData {
  /**
   * @param muType
   * @return void
   */
  default void setMuType(String muType) {
    this.offsetSet(Option.MU_TYPE.label, muType);
  }

  /**
   * @param piecesCount
   * @return void
   */
  default void setPiecesCount(int piecesCount) {
    this.offsetSet(Option.PIECES_COUNT.label, piecesCount);
  }

  /**
   * @param muType
   * @return void
   */
  default void setMuTypeOne(String muType) {
    this.offsetSet(Option.MU_TYPE_ONE.label, muType);
  }

  /**
   * @param piecesCount
   * @return void
   */
  default void setPiecesCountOne(int piecesCount) {
    this.offsetSet(Option.PIECES_COUNT_ONE.label, piecesCount);
  }

  /**
   * @param muType
   * @return void
   */
  default void setMuTypeTwo(String muType) {
    this.offsetSet(Option.MU_TYPE_TWO.label, muType);
  }

  /**
   * @param piecesCount
   * @return void
   */
  default void setPiecesCountTwo(int piecesCount) {
    this.offsetSet(Option.PIECES_COUNT_TWO.label, piecesCount);
  }

  /**
   * @param muType
   * @return void
   */
  default void setMuTypeThree(String muType) {
    this.offsetSet(Option.MU_TYPE_THREE.label, muType);
  }

  /**
   * @param piecesCount
   * @return void
   */
  default void setPiecesCountThree(int piecesCount) {
    this.offsetSet(Option.PIECES_COUNT_THREE.label, piecesCount);
  }

  /**
   * @param wrapBackCount
   * @return void
   */
  default void setWrapBackCount(int wrapBackCount) {
    this.offsetSet(Option.WRAP_BACK_COUNT.label, wrapBackCount);
  }

  /**
   * @param wrapBackNote
   * @return void
   */
  default void setWrapBackNote(String wrapBackNote) {
    this.offsetSet(Option.WRAP_BACK_NOTE.label, wrapBackNote);
  }

  /**
   * @return void
   */
  default void setAppDisp() {
    setAppDisp(true);
  }

  /**
   * @param appDisp
   */
  default void setAppDisp(Boolean appDisp) {
    this.offsetSet(Option.APP_DISP.label, (int) (appDisp ? 1 : 0));
  }

  /**
   * @param content
   * @return void
   */
  default void setContent(String content) {
    this.offsetSet(Option.CONTENT.label, content);
  }

  /**
   * @return void
   */
  default void setGetPiecesNumbers() {
    setGetPiecesNumbers(true);
  }

  /**
   * @param getPiecesNumbers
   * @return void
   */
  default void setGetPiecesNumbers(Boolean getPiecesNumbers) {
    this.offsetSet(Option.GET_PIECES_NUMBERS.label, (int) (getPiecesNumbers ? 1 : 0));
  }

  /**
   * @param contentOne
   * @return void
   */
  default void setContentOne(String contentOne) {
    this.offsetSet(Option.CONTENT_ONE.label, contentOne);
  }

  /**
   * @param contentTwo
   * @return void
   */
  default void setContentTwo(String contentTwo) {
    this.offsetSet(Option.CONTENT_TWO.label, contentTwo);
  }

  /**
   * @param contentThree
   * @return void
   */
  default void setContentThree(String contentThree) {
    this.offsetSet(Option.CONTENT_THREE.label, contentThree);
  }

  /**
   * @return void
   */
  default void setAdrService() {
    setAdrService(true);
  }

  /**
   * @param adrService
   * @return void
   */
  default void setAdrService(Boolean adrService) {
    this.offsetSet(Option.ADR_SERVICE.label, (int) (adrService ? 1 : 0));
  }

  /**
   * @param adrContent
   * @return void
   */
  default void setAdrContent(ArrayList<String> adrContent) {
    this.offsetSet(Option.ADR_CONTENT.label, adrContent);
  }

  /**
   * @return void
   */
  default void setVDLService() {
    setVDLService(true);
  }

  /**
   * @param vdlService
   * @return void
   */
  default void setVDLService(Boolean vdlService) {
    this.offsetSet(Option.VDL_SERVICE.label, (int) (vdlService ? 1 : 0));
  }

  /**
   * @param deliveryDate
   * @return void
   */
  default void setContentIssueDate(DateTime deliveryDate) {
    this.offsetSet(Option.CONTENT_ISSUE_DATE.label, DateTimeFormat.forPattern("yyyy-MM-dd").print(deliveryDate));
  }

  /**
   * @param number
   * @return void
   */
  default void setContentInvoiceNumber(String number) {
    this.offsetSet(Option.CONTENT_INVOICE_NUMBER.label, number);
  }

  /**
   * @param value
   * @return void
   */
  default void setContentEAD(String value) {
    this.offsetSet(Option.CONTENT_EAD.label, value);
  }

  /**
   * @param value
   * @return void
   */
  default void setContentMRN(String value) {
    this.offsetSet(Option.CONTENT_MRN.label, value);
  }

  /**
   * @param value
   * @return void
   */
  default void setEADPdf(String value) {
    this.offsetSet(Option.EAD_PDF.label, value);
  }
}

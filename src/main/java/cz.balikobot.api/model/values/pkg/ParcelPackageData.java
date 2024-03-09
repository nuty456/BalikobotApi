package cz.balikobot.api.model.values.pkg;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

/**
 * Represents a class that provides offset data for setting item values at specific offsets.
 */
public interface ParcelPackageData extends OffsetData {
  /**
   * Sets the MuType of the ParcelPackageData.
   *
   * @param muType The MuType to set for the ParcelPackageData.
   */
  default void setMuType(String muType) {
    this.offsetSet(Option.MU_TYPE.label, muType);
  }

  /**
   * Set the number of pieces for the ParcelPackageData.
   *
   * @param piecesCount The number of pieces to set for the ParcelPackageData.
   */
  default void setPiecesCount(int piecesCount) {
    this.offsetSet(Option.PIECES_COUNT.label, piecesCount);
  }

  /**
   * Sets the MuTypeOne of the ParcelPackageData.
   *
   * @param muType the MuTypeOne to set for the ParcelPackageData
   */
  default void setMuTypeOne(String muType) {
    this.offsetSet(Option.MU_TYPE_ONE.label, muType);
  }

  /**
   * Set the number of pieces for the ParcelPackageData to one.
   *
   * @param piecesCount The number of pieces to set for the ParcelPackageData.
   */
  default void setPiecesCountOne(int piecesCount) {
    this.offsetSet(Option.PIECES_COUNT_ONE.label, piecesCount);
  }

  /**
   * Sets the MuTypeTwo of the ParcelPackageData.
   *
   * @param muType The MuTypeTwo to set for the ParcelPackageData.
   */
  default void setMuTypeTwo(String muType) {
    this.offsetSet(Option.MU_TYPE_TWO.label, muType);
  }

  /**
   * Sets the number of pieces for the ParcelPackageData to two.
   *
   * @param piecesCount The number of pieces to set for the ParcelPackageData.
   */
  default void setPiecesCountTwo(int piecesCount) {
    this.offsetSet(Option.PIECES_COUNT_TWO.label, piecesCount);
  }

  /**
   * Sets the MuTypeThree of the ParcelPackageData.
   *
   * @param muType The MuTypeThree to set for the ParcelPackageData.
   */
  default void setMuTypeThree(String muType) {
    this.offsetSet(Option.MU_TYPE_THREE.label, muType);
  }

  /**
   * Set the number of pieces for the ParcelPackageData to three.
   *
   * @param piecesCount The number of pieces to set for the ParcelPackageData.
   */
  default void setPiecesCountThree(int piecesCount) {
    this.offsetSet(Option.PIECES_COUNT_THREE.label, piecesCount);
  }

  /**
   * Sets the wrap back count for the ParcelPackageData.
   *
   * @param wrapBackCount The wrap back count to set for the ParcelPackageData.
   */
  default void setWrapBackCount(int wrapBackCount) {
    this.offsetSet(Option.WRAP_BACK_COUNT.label, wrapBackCount);
  }

  /**
   * Sets the wrap back note for the ParcelPackageData.
   *
   * @param wrapBackNote The wrap back note to set for the ParcelPackageData.
   */
  default void setWrapBackNote(String wrapBackNote) {
    this.offsetSet(Option.WRAP_BACK_NOTE.label, wrapBackNote);
  }

  /**
   * Sets the value of the "APP_DISP" option in the offset data.
   */
  default void setAppDisp() {
    setAppDisp(true);
  }

  /**
   * Sets the value of the "APP_DISP" option in the offset data.
   *
   * @param appDisp The value to set for the "APP_DISP" option.
   */
  default void setAppDisp(Boolean appDisp) {
    this.offsetSet(Option.APP_DISP.label, appDisp ? 1 : 0);
  }

  /**
   * Sets the content of the ParcelPackageData.
   *
   * @param content The content to set for the ParcelPackageData.
   */
  default void setContent(String content) {
    this.offsetSet(Option.CONTENT.label, content);
  }

  /**
   * Sets the value for the "GET_PIECES_NUMBERS" option in the offset data.
   */
  default void setGetPiecesNumbers() {
    setGetPiecesNumbers(true);
  }

  /**
   * Sets the value for the "GET_PIECES_NUMBERS" option in the offset data.
   *
   * @param getPiecesNumbers Whether to set the "GET_PIECES_NUMBERS" option to true or false.
   */
  default void setGetPiecesNumbers(Boolean getPiecesNumbers) {
    this.offsetSet(Option.GET_PIECES_NUMBERS.label, getPiecesNumbers ? 1 : 0);
  }

  /**
   * Sets the content of the ParcelPackageData to the specified contentOne.
   *
   * @param contentOne The content to set for the ParcelPackageData.
   */
  default void setContentOne(String contentOne) {
    this.offsetSet(Option.CONTENT_ONE.label, contentOne);
  }

  /**
   * Sets the contentTwo of the ParcelPackageData.
   *
   * @param contentTwo The contentTwo to set for the ParcelPackageData.
   */
  default void setContentTwo(String contentTwo) {
    this.offsetSet(Option.CONTENT_TWO.label, contentTwo);
  }

  /**
   * Sets the contentThree of the ParcelPackageData.
   *
   * @param contentThree The contentThree to set for the ParcelPackageData.
   */
  default void setContentThree(String contentThree) {
    this.offsetSet(Option.CONTENT_THREE.label, contentThree);
  }

  /**
   * Sets the ADR service option for the ParcelPackageData.
   */
  default void setAdrService() {
    setAdrService(true);
  }

  /**
   * Sets the ADR service option for the ParcelPackageData.
   *
   * @param adrService Whether to enable or disable the ADR service. If true, the ADR service is enabled. If false, the ADR service is disabled.
   */
  default void setAdrService(Boolean adrService) {
    this.offsetSet(Option.ADR_SERVICE.label, adrService ? 1 : 0);
  }

  /**
   * Sets the ADR content for the ParcelPackageData.
   *
   * @param adrContent The ADR content to set for the ParcelPackageData. It is represented as an ArrayList of strings.
   */
  default void setAdrContent(ArrayList<String> adrContent) {
    this.offsetSet(Option.ADR_CONTENT.label, adrContent);
  }

  /**
   * Sets the VDL service option for the ParcelPackageData.
   * If vdlService is true, the VDL service is enabled. If vdlService is false, the VDL service is disabled.
   */
  default void setVDLService() {
    setVDLService(true);
  }

  /**
   * Sets the VDL service option for the ParcelPackageData.
   * If vdlService is true, the VDL service is enabled. If vdlService is false, the VDL service is disabled.
   *
   * @param vdlService The value to set for the VDL service option.
   */
  default void setVDLService(Boolean vdlService) {
    this.offsetSet(Option.VDL_SERVICE.label, vdlService ? 1 : 0);
  }

  /**
   * Sets the content issue date for the ParcelPackageData.
   *
   * @param deliveryDate The content issue date to set for the ParcelPackageData.
   */
  default void setContentIssueDate(DateTime deliveryDate) {
    this.offsetSet(Option.CONTENT_ISSUE_DATE.label, DateTimeFormat.forPattern("yyyy-MM-dd").print(deliveryDate));
  }

  /**
   * Sets the content invoice number for the ParcelPackageData.
   *
   * @param number The content invoice number to set for the ParcelPackageData.
   */
  default void setContentInvoiceNumber(String number) {
    this.offsetSet(Option.CONTENT_INVOICE_NUMBER.label, number);
  }

  /**
   * Sets the content of the ParcelPackageData to the specified value.
   *
   * @param value The content to set for the ParcelPackageData.
   */
  default void setContentEAD(String value) {
    this.offsetSet(Option.CONTENT_EAD.label, value);
  }

  /**
   * Sets the content MRN (Material Receipt Number) for the ParcelPackageData.
   *
   * @param value The content MRN to set for the ParcelPackageData.
   */
  default void setContentMRN(String value) {
    this.offsetSet(Option.CONTENT_MRN.label, value);
  }

  /**
   * Sets the EAD PDF value for the ParcelPackageData.
   *
   * @param value The value to set for the EAD PDF.
   */
  default void setEADPdf(String value) {
    this.offsetSet(Option.EAD_PDF.label, value);
  }
}

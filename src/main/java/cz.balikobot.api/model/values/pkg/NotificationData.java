package cz.balikobot.api.model.values.pkg;

import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

public interface NotificationData extends OffsetData {
  /**
   * @return void
   */
  default void setSmsNotification() {
    setSmsNotification(true);
  }

  /**
   * @param notification
   * @return void
   */
  default void setSmsNotification(Boolean notification) {
    this.offsetSet(Option.SMS_NOTIFICATION.label, (int) (notification ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setPhoneDeliveryNotification() {
    setPhoneDeliveryNotification(true);
  }

  /**
   * @param phoneDeliveryNotification
   * @return void
   */
  default void setPhoneDeliveryNotification(Boolean phoneDeliveryNotification) {
    this.offsetSet(Option.PHONE_DELIVERY_NOTIFICATION.label, (int) (phoneDeliveryNotification ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setPhoneOrderNotification() {
    setPhoneOrderNotification(true);
  }

  /**
   * @param phoneOrderNotification
   * @return void
   */
  default void setPhoneOrderNotification(Boolean phoneOrderNotification) {
    this.offsetSet(Option.PHONE_ORDER_NOTIFICATION.label, (int) (phoneOrderNotification ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setEmailNotification() {
    setEmailNotification(true);
  }

  /**
   * @param emailNotification
   * @return void
   */
  default void setEmailNotification(Boolean emailNotification) {
    this.offsetSet(Option.EMAIL_NOTIFICATION.label, (int) (emailNotification ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setPhoneNotification() {
    setPhoneNotification(true);
  }

  /**
   * @param phoneNotification
   * @return void
   */
  default void setPhoneNotification(Boolean phoneNotification) {
    this.offsetSet(Option.PHONE_NOTIFICATION.label, (int) (phoneNotification ? 1 : 0));
  }

  /**
   * @return void
   */
  default void setB2CNotification() {
    setB2CNotification(true);
  }

  /**
   * @param b2cNotification
   * @return void
   */
  default void setB2CNotification(Boolean b2cNotification) {
    this.offsetSet(Option.B2C_NOTIFICATION.label, (int) (b2cNotification ? 1 : 0));
  }

  /**
   * @param reference
   * @return void
   */
  default void setReference(String reference) {
    this.offsetSet(Option.REFERENCE.label, reference);
  }

  /**
   * @return void
   */
  default void setSM1Service() {
    setSM1Service(true);
  }

  /**
   * @param service
   * @return void
   */
  default void setSM1Service(Boolean service) {
    this.offsetSet(Option.SM1_SERVICE.label, (int) (service ? 1 : 0));
  }

  /**
   * @param text
   * @return void
   */
  default void setSM1Text(String text) {
    this.offsetSet(Option.SM1_TEXT.label, text);
  }

  /**
   * @return void
   */
  default void setSM2Service() {
    setSM2Service(true);
  }

  /**
   * @param service
   * @return void
   */
  default void setSM2Service(Boolean service) {
    this.offsetSet(Option.SM2_SERVICE.label, (int) (service ? 1 : 0));
  }

}

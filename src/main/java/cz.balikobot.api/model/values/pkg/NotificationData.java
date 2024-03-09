package cz.balikobot.api.model.values.pkg;

import cz.balikobot.api.definitions.Option;
import cz.balikobot.api.model.values.pkg.help.OffsetData;

/**
 * Represents a class that provides notification data for setting various notification options.
 * Extends the OffsetData interface to provide offset data setting functionality.
 */
public interface NotificationData extends OffsetData {
  /**
   * Sets the SMS notification to true.
   */
  default void setSmsNotification() {
    setSmsNotification(true);
  }

  /**
   * Sets the SMS notification to the specified value.
   *
   * @param notification the value indicating whether SMS notification should be enabled (true) or disabled (false)
   */
  default void setSmsNotification(Boolean notification) {
    this.offsetSet(Option.SMS_NOTIFICATION.label, notification ? 1 : 0);
  }

  /**
   * Sets the phone delivery notification to true.
   */
  default void setPhoneDeliveryNotification() {
    setPhoneDeliveryNotification(true);
  }

  /**
   * Sets the phone delivery notification to the specified value.
   *
   * @param phoneDeliveryNotification the value indicating whether phone delivery notification should be enabled (true) or disabled (false)
   */
  default void setPhoneDeliveryNotification(Boolean phoneDeliveryNotification) {
    this.offsetSet(Option.PHONE_DELIVERY_NOTIFICATION.label, phoneDeliveryNotification ? 1 : 0);
  }

  /**
   * Sets the phone order notification to true.
   */
  default void setPhoneOrderNotification() {
    setPhoneOrderNotification(true);
  }

  /**
   * Sets the phone order notification to the specified value.
   *
   * @param phoneOrderNotification the value indicating whether phone order notification should be enabled (true) or disabled (false)
   */
  default void setPhoneOrderNotification(Boolean phoneOrderNotification) {
    this.offsetSet(Option.PHONE_ORDER_NOTIFICATION.label, phoneOrderNotification ? 1 : 0);
  }

  /**
   * Sets the email notification to true.
   * This method calls {@link #setEmailNotification(Boolean)} with the value <code>true</code>.
   *
   * @see #setEmailNotification(Boolean)
   */
  default void setEmailNotification() {
    setEmailNotification(true);
  }

  /**
   * Sets the email notification to the specified value.
   *
   * @param emailNotification the value indicating whether email notification should be enabled (true) or disabled (false)
   */
  default void setEmailNotification(Boolean emailNotification) {
    this.offsetSet(Option.EMAIL_NOTIFICATION.label, emailNotification ? 1 : 0);
  }

  /**
   * Sets the phone notification to true.
   */
  default void setPhoneNotification() {
    setPhoneNotification(true);
  }

  /**
   * Sets the phone notification to the specified value.
   *
   * @param phoneNotification the value indicating whether phone notification should be enabled (true) or disabled (false)
   */
  default void setPhoneNotification(Boolean phoneNotification) {
    this.offsetSet(Option.PHONE_NOTIFICATION.label, phoneNotification ? 1 : 0);
  }

  /**
   * Sets the B2C notification to true.
   * This method calls {@link #setB2CNotification(Boolean)} with the value <code>true</code>.
   *
   * @see #setB2CNotification(Boolean)
   */
  default void setB2CNotification() {
    setB2CNotification(true);
  }

  /**
   * Sets the B2C notification value to the specified boolean value.
   *
   * @param b2cNotification the value indicating whether B2C notification should be enabled (true) or disabled (false)
   */
  default void setB2CNotification(Boolean b2cNotification) {
    this.offsetSet(Option.B2C_NOTIFICATION.label, b2cNotification ? 1 : 0);
  }

  /**
   * Sets the reference value for the notification data.
   *
   * @param reference the reference value to be set
   */
  default void setReference(String reference) {
    this.offsetSet(Option.REFERENCE.label, reference);
  }

  /**
   * Sets the SM1 service to the specified value.
   *
   */
  default void setSM1Service() {
    setSM1Service(true);
  }

  /**
   * Sets the SM1 service to the specified value.
   *
   * @param service the value indicating whether SM1 service should be enabled (true) or disabled (false)
   */
  default void setSM1Service(Boolean service) {
    this.offsetSet(Option.SM1_SERVICE.label, service ? 1 : 0);
  }

  /**
   * Sets the value of SM1 text.
   *
   * @param text the text to be set for SM1
   */
  default void setSM1Text(String text) {
    this.offsetSet(Option.SM1_TEXT.label, text);
  }

  /**
   * Sets the SM2 service to the specified value.
   */
  default void setSM2Service() {
    setSM2Service(true);
  }

  /**
   * Sets the SM2 service to the specified value.
   *
   * @param service the value indicating whether SM2 service should be enabled (true) or disabled (false)
   */
  default void setSM2Service(Boolean service) {
    this.offsetSet(Option.SM2_SERVICE.label, service ? 1 : 0);
  }

}

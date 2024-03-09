package cz.balikobot.api.definitions;

import java.util.Arrays;
import java.util.List;

/**
 * Package statuses.
 */
public enum Status {
  /**
   * Ordered
   */
  ORDERED("-1.0"),

  /**
   * Picked up at the sender
   */
  PICKED_UP_FROM_SENDER("2.1"),

  /**
   * Transit
   */
  TRANSIT("2.2"),

  /**
   * Ready to pick up
   */
  READY_TO_PICK_UP("2.3"),

  /**
   * Back on the way to the sender
   */
  SEND_BACK_TO_SENDER("2.4"),

  /**
   * Handed over to the final carrier
   */
  HANDED_TO_FINAL_SHIPPER("2.5"),

  /**
   * Cancellation by the carrier
   */
  CANCELLATION_BY_SHIPPER("3.1"),

  /**
   * Cancellation by the recipient
   */
  CANCELLATION_BY_RECIPIENT("3.2"),

  /**
   * Cancellation by the sender
   */
  CANCELLATION_BY_SENDER("3.3"),

  /**
   * Delivered back to sender
   */
  DELIVERED_BACK_TO_SENDER("4.0"),

  /**
   * Cash on delivery has been credited to the sender's account
   */
  COD_PAID("5.0"),

  /**
   * Carrier error
   */
  ERROR_SHIPPER("0.1"),

  /**
   * Error on the part of the recipient
   */
  ERROR_RECIPIENT("0.2"),

  /**
   * Error on the part of the sender
   */
  ERROR_SENDER("0.3"),

  /**
   * Collection of the consignment at the delivery point
   */
  PICKUP_ON_DELIVERY_POINT("1.1"),

  /**
   * Delivered to address
   */
  DELIVERED_TO_ADDRESS("1.2");

  public final String label;

  Status(String label) {
    this.label = label;
  }

  public static Status valueOfLabel(String label) {
    for (Status e : values()) {
      if (e.label.equals(label)) {
        return e;
      }
    }
    return null;
  }

  /**
   * Package delivered.
   *
   * @param status status
   * @return Boolean
   */
  public static Boolean isDelivered(String status) {
    return inStatuses(status, Arrays.asList(
        PICKUP_ON_DELIVERY_POINT,
        DELIVERED_TO_ADDRESS
    ));
  }

  /**
   * Package delivery failed.
   *
   * @param status status
   * @return Boolean
   */
  public static Boolean isError(String status) {
    return inStatuses(status, Arrays.asList(
        ERROR_SHIPPER,
        ERROR_RECIPIENT,
        ERROR_SENDER
    ));
  }

  /**
   * Package is being delivered to customer.
   *
   * @param status status
   * @return Boolean
   */
  public static Boolean isBeingDelivered(String status) {
    return inStatuses(status, Arrays.asList(
        ORDERED,
        PICKED_UP_FROM_SENDER,
        TRANSIT,
        READY_TO_PICK_UP,
        HANDED_TO_FINAL_SHIPPER
    ));
  }

  /**
   * Package delivery processed ended.
   *
   * @param status status
   * @return Boolean
   */
  public static Boolean isClosed(String status) {
    return inStatuses(status, Arrays.asList(
        DELIVERED_BACK_TO_SENDER,
        COD_PAID,
        PICKUP_ON_DELIVERY_POINT,
        DELIVERED_TO_ADDRESS
    ));
  }

  /**
   * Check if given ID is in any of given statuses.
   *
   * @param status status
   * @param statuses statuses
   * @return Boolean
   */
  private static Boolean inStatuses(String status, List<Status> statuses) {
    final Status statusEnum = Status.valueOf(status);
    return statuses.contains(statusEnum);
  }
}

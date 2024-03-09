package cz.balikobot.api.model.values;

import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

import cz.balikobot.api.definitions.Shipper;

/**
 * Represents an ordered shipment.
 * <p>
 * This class contains information about an ordered shipment, such as the order ID, handover URL, labels URL, file URL, shipper, and package IDs.
 * It also provides constructor methods to create an instance of the OrderedShipment class.
 */
@Data
@AllArgsConstructor
public class OrderedShipment {
  /**
   * ID.
   */
  private String orderId;

  /**
   * The handover URL for the ordered shipment.
   */
  private String handoverUrl;

  /**
   * The URL for accessing labels of an ordered shipment.
   */
  private String labelsUrl;

  /**
   * The URL for accessing a file related to the ordered shipment.
   */
  private String fileUrl;

  /**
   * Represents the shipper of an ordered shipment.
   */
  private Shipper shipper;

  /**
   * Represents a list of package IDs.
   */
  private List<String> packageIds;

  /**
   * Represents an ordered shipment.
   * <p>
   * This class contains information about an ordered shipment, such as the order ID, handover URL, labels URL, file URL, shipper, and package IDs.
   * It also provides constructor methods to create an instance of the OrderedShipment class.
   */
  public OrderedShipment(
      String orderId,
      Shipper shipper,
      List<String> packageIds,
      String handoverUrl,
      String labelsUrl
  ) {
    this.orderId = orderId;
    this.shipper = shipper;
    this.packageIds = packageIds;
    this.handoverUrl = handoverUrl;
    this.labelsUrl = labelsUrl;
    this.fileUrl = null;
  }

  /**
   * Represents an ordered shipment.
   * <p>
   * This class contains information about an ordered shipment, such as the order ID, handover URL, labels URL, file URL, shipper, and package IDs.
   * It also provides constructor methods to create an instance of the OrderedShipment class.
   */
  public OrderedShipment(
      String orderId,
      Shipper shipper,
      List<String> packageIds,
      String handoverUrl,
      String labelsUrl,
      String fileUrl
  ) {
    this.orderId = orderId;
    this.shipper = shipper;
    this.packageIds = packageIds;
    this.handoverUrl = handoverUrl;
    this.labelsUrl = labelsUrl;
    this.fileUrl = fileUrl;
  }

  /**
   * Creates a new instance of OrderedShipment from the given data.
   *
   * @param shipper    The shipper of the ordered shipment.
   * @param packageIds The list of package IDs.
   * @param data       The data containing information about the ordered shipment.
   * @return A new instance of OrderedShipment.
   */
  public static OrderedShipment newInstanceFromData(Shipper shipper, List<String> packageIds, HashMap<Object, Object> data) {
    return new OrderedShipment(
        (String) data.get("order_id"),
        shipper,
        packageIds,
        (String) data.get("handover_url"),
        (String) data.get("labels_url"),
        (String) data.get("file_url")
    );
  }

}

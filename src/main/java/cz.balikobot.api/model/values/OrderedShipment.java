package cz.balikobot.api.model.values;

import java.util.HashMap;
import java.util.List;

import lombok.Data;

import cz.balikobot.api.definitions.Shipper;

@Data
public class OrderedShipment {
  /**
   *
   */
  private String orderId;

  /**
   *
   */
  private String handoverUrl;

  /**
   *
   */
  private String labelsUrl;

  /**
   *
   */
  private String fileUrl;

  /**
   *
   */
  private Shipper shipper;

  /**
   *
   */
  private List<String> packageIds;

  /**
   * OrderedShipment constructor
   *
   * @param orderId
   * @param shipper
   * @param packageIds
   * @param handoverUrl
   * @param labelsUrl
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
   * OrderedShipment constructor
   *
   * @param orderId
   * @param shipper
   * @param packageIds
   * @param handoverUrl
   * @param labelsUrl
   * @param fileUrl
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
   * @param shipper
   * @param packageIds
   * @param data
   * @return \Inspirum\Balikobot\Model\Values\OrderedShipment
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

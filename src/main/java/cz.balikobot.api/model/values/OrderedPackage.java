package cz.balikobot.api.model.values;

import cz.balikobot.api.definitions.Shipper;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;

@Data
public class OrderedPackage {
  /**
   * Package ID
   */
  private String packageId;

  /**
   * Package batch ID (EID)
   */
  private String batchId;

  /**
   * Shipper
   */
  private Shipper shipper;

  /**
   * Carrier ID (for package tracking)
   */
  private String carrierId;

  /**
   * Track URL
   *
   * @var String|null
   */
  private String trackUrl;

  /**
   * Label URL
   *
   * @var String|null
   */
  private String labelUrl;

  /**
   * Carrier ID Swap
   *
   * @var String|null
   */
  private String carrierIdSwap;

  /**
   * Pieces
   *
   * @var ArrayList<String>
   */
  private ArrayList<String> pieces;

  /**
   * Final carrier ID
   *
   * @var String|null
   */
  private String finalCarrierId;

  /**
   * Final track URL
   *
   * @var String|null
   */
  private String finalTrackUrl;

  /**
   * OrderedPackage constructor
   *
   * @param packageId
   * @param shipper
   * @param batchId
   * @param carrierId
   */
  public OrderedPackage(
      String packageId,
      Shipper shipper,
      String batchId,
      String carrierId
  ) {
    this.packageId = packageId;
    this.shipper = shipper;
    this.batchId = batchId;
    this.carrierId = carrierId;
  }

  /**
   * OrderedPackage constructor
   *
   * @param packageId
   * @param shipper
   * @param batchId
   * @param carrierId
   * @param trackUrl
   * @param labelUrl
   * @param carrierIdSwap
   * @param pieces
   * @param finalCarrierId
   * @param finalTrackUrl
   */
  public OrderedPackage(
      String packageId,
      Shipper shipper,
      String batchId,
      String carrierId,
      String trackUrl,
      String labelUrl,
      String carrierIdSwap,
      ArrayList<String> pieces,
      String finalCarrierId,
      String finalTrackUrl
  ) {
    this.packageId = packageId;
    this.shipper = shipper;
    this.batchId = batchId;
    this.carrierId = carrierId;
    this.trackUrl = trackUrl;
    this.labelUrl = labelUrl;
    this.carrierIdSwap = carrierIdSwap;
    this.pieces = pieces;
    this.finalCarrierId = finalCarrierId;
    this.finalTrackUrl = finalTrackUrl;
  }

  /**
   * @param shipper
   * @param data
   * @return \Inspirum\Balikobot\Model\Values\OrderedPackage
   */
  public static OrderedPackage newInstanceFromData(Shipper shipper, HashMap<Object, Object> data) {
    return new OrderedPackage(
        (String) data.get("package_id"),
        shipper,
        (String)data.get("eid"),
        data.get("carrier_id") != null ? (String)data.get("carrier_id") : "",
        (String)data.get("track_url"),
        (String)data.get("label_url"),
        (String)data.get("carrier_id_swap"),
        data.get("pieces") != null ? (ArrayList<String>)data.get("pieces") : new ArrayList<>(),
        (String)data.get("carrier_id_final"),
        (String)data.get("track_url_final")
        );
  }

}

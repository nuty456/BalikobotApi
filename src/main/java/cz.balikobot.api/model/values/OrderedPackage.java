package cz.balikobot.api.model.values;

import cz.balikobot.api.definitions.Shipper;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The OrderedPackage class represents an ordered package.
 */
@Data
@AllArgsConstructor
public class OrderedPackage {
  /**
   * Package ID.
   */
  private String packageId;

  /**
   * Package batch ID (EID).
   */
  private String batchId;

  /**
   * Shipper.
   */
  private Shipper shipper;

  /**
   * Carrier ID (for package tracking).
   */
  private String carrierId;

  /**
   * Track URL.
   */
  private String trackUrl;

  /**
   * Label URL.
   */
  private String labelUrl;

  /**
   * Carrier ID Swap.
   */
  private String carrierIdSwap;

  /**
   * Pieces.
   */
  private ArrayList<String> pieces;

  /**
   * Final carrier ID.
   */
  private String finalCarrierId;

  /**
   * Final track URL.
   */
  private String finalTrackUrl;

  /**
   * Represents an ordered package.
   *
   * @param packageId The package ID (String).
   * @param shipper   The shipper associated with the package.
   * @param batchId   The package batch ID (String).
   * @param carrierId The carrier ID for package tracking (String, can be null).
   * @see Shipper
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
   * Represents an ordered package.
   *
   * @param packageId      The package ID (String).
   * @param shipper        The shipper associated with the package.
   * @param batchId        The package batch ID (String).
   * @param carrierId      The carrier ID for package tracking (String, can be null).
   * @param trackUrl       The track URL for package tracking (String, can be null).
   * @param labelUrl       The label URL for the package (String, can be null).
   * @param carrierIdSwap  The carrier ID swap value (String, can be null).
   * @param pieces         An ArrayList of strings representing the pieces (can be null or empty).
   * @param finalCarrierId The final carrier ID (String, can be null).
   * @param finalTrackUrl  The final track URL (String, can be null).
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
   * Creates a new instance of the OrderedPackage class from the given data.
   *
   * @param shipper The shipper object associated with the package.
   * @param data    A HashMap containing the data for the package. The keys and their corresponding values in the HashMap are:
   *                - package_id: The package ID (String).
   *                - eid: The package batch ID (String).
   *                - carrier_id: The carrier ID for package tracking (String, can be null).
   *                - track_url: The track URL for package tracking (String, can be null).
   *                - label_url: The label URL for the package (String, can be null).
   *                - carrier_id_swap: The carrier ID swap value (String, can be null).
   *                - pieces: An ArrayList of strings representing the pieces (can be null or empty).
   *                - carrier_id_final: The final carrier ID (String, can be null).
   *                - track_url_final: The final track URL (String, can be null).
   * @return A new instance of OrderedPackage with the given data.
   */
  public static OrderedPackage newInstanceFromData(Shipper shipper, HashMap<Object, Object> data) {
    return new OrderedPackage(
        (String) data.get("package_id"),
        shipper,
        (String) data.get("eid"),
        data.get("carrier_id") != null ? (String) data.get("carrier_id") : "",
        (String) data.get("track_url"),
        (String) data.get("label_url"),
        (String) data.get("carrier_id_swap"),
        data.get("pieces") != null ? (ArrayList<String>) data.get("pieces") : new ArrayList<>(),
        (String) data.get("carrier_id_final"),
        (String) data.get("track_url_final")
    );
  }

}

package cz.balikobot.api.model.values;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

import cz.balikobot.api.definitions.Shipper;

/**
 * PackageTransportCost represents the transport cost for a package.
 */
@Data
@AllArgsConstructor
public class PackageTransportCost {
  /**
   * Package batch ID (EID)
   */
  private String batchId;

  /**
   * Shipper
   */
  private Shipper shipper;

  /**
   * Total cost
   */
  private Double totalCost;

  /**
   * Currency code
   */
  private String currencyCode;

  /**
   * costsBreakdown represents the breakdown of transport costs for a package.
   */
  private List<PackageTransportCostPart> costsBreakdown;

  /**
   * Initializes a new instance of the PackageTransportCost class.
   *
   * @param batchId      The package batch ID (EID).
   * @param shipper      The shipper.
   * @param totalCost    The total cost of transport.
   * @param currencyCode The currency code.
   */
  public PackageTransportCost(
      String batchId,
      Shipper shipper,
      Double totalCost,
      String currencyCode
  ) {
    this.batchId = batchId;
    this.shipper = shipper;
    this.totalCost = totalCost;
    this.currencyCode = currencyCode;
  }

  /**
   * Creates a new instance of the PackageTransportCost class from the given data.
   *
   * @param shipper The shipper of the package.
   * @param data    The data containing the package transport cost information.
   * @return A new PackageTransportCost object.
   */
  public static PackageTransportCost newInstanceFromData(Shipper shipper, HashMap<String, Object> data) {
    final List<HashMap<String, Object>> costsBreakdownList = (List<HashMap<String, Object>>) data.get("costs_breakdown");
    final List<PackageTransportCostPart> packageTransportCostPartList = costsBreakdownList.stream().map(i -> new PackageTransportCostPart((String) i.get("name"), (Double) i.get("cost"), (String) i.get("currency"))).collect(Collectors.toList());
    return new PackageTransportCost(
        (String) data.get("eid"),
        shipper,
        (Double) data.get("costs_total"),
        (String) data.get("currency"),
        packageTransportCostPartList
    );
  }

}

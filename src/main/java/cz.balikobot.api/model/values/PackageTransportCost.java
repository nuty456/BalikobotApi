package cz.balikobot.api.model.values;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

import cz.balikobot.api.definitions.Shipper;

@Data
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
   * Cost breakdown
   *
   * @var ArrayList<\Inspirum\Balikobot\Model\Values\PackageTransportCostPart>
   */
  private List<PackageTransportCostPart> costsBreakdown;

  /**
   * PackageTransportCost constructor
   *
   * @param batchId
   * @param shipper
   * @param totalCost
   * @param currencyCode
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
   * PackageTransportCost constructor
   *
   * @param batchId
   * @param shipper
   * @param totalCost
   * @param currencyCode
   * @param costsBreakdown
   */
  public PackageTransportCost(
      String batchId,
      Shipper shipper,
      Double totalCost,
      String currencyCode,
      List<PackageTransportCostPart> costsBreakdown
  ) {
    this.batchId = batchId;
    this.shipper = shipper;
    this.totalCost = totalCost;
    this.currencyCode = currencyCode;
    this.costsBreakdown = costsBreakdown;
  }

  /**
   * @param shipper
   * @param data
   * @return \Inspirum\Balikobot\Model\Values\PackageTransportCost
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

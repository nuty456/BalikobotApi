package cz.balikobot.api.model.values;

import lombok.Data;

@Data
public class PackageTransportCostPart {
  /**
   * Part name
   */
  private String name;

  /**
   * Part cost
   */
  private Double cost;

  /**
   * Currency code
   */
  private String currencyCode;

  /**
   * PackageTransportCost constructor
   *
   * @param name
   * @param cost
   * @param currencyCode
   */
  public PackageTransportCostPart(String name, Double cost, String currencyCode) {
    this.name = name;
    this.cost = cost;
    this.currencyCode = currencyCode;
  }
}

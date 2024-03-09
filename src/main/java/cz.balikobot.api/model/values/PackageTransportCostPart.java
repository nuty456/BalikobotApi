package cz.balikobot.api.model.values;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * PackageTransportCostPart represents a part of the transport cost for a package.
 */
@Data
@AllArgsConstructor
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
}

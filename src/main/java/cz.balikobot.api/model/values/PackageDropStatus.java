package cz.balikobot.api.model.values;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents the status of a dropped package.
 */
@Data
@AllArgsConstructor
public class PackageDropStatus {
  /**
   * Represents the ID of a package.
   */
  private String packageId;

  /**
   * Represents the status of a dropped package.
   */
  private Integer pStatus;

  /**
   * Represents the status message of a dropped package.
   */
  private String statusMessage;
}

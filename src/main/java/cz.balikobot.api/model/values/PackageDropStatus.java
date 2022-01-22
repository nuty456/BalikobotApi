package cz.balikobot.api.model.values;

import lombok.Data;

@Data
public class PackageDropStatus {
  private String packageId;
  private Integer pStatus;
  private String statusMessage;

  public PackageDropStatus(String packageId, Integer pStatus, String statusMessage) {
    this.packageId = packageId;
    this.pStatus = pStatus;
    this.statusMessage = statusMessage;
  }
}

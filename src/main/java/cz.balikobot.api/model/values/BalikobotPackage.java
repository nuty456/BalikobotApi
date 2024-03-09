package cz.balikobot.api.model.values;

import java.util.HashMap;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import cz.balikobot.api.model.values.pkg.CashOnDeliveryData;
import cz.balikobot.api.model.values.pkg.CommonData;
import cz.balikobot.api.model.values.pkg.CustomerData;
import cz.balikobot.api.model.values.pkg.DeliveryData;
import cz.balikobot.api.model.values.pkg.ForeignCountryDeliveryData;
import cz.balikobot.api.model.values.pkg.NotificationData;
import cz.balikobot.api.model.values.pkg.PackageData;
import cz.balikobot.api.model.values.pkg.ParcelPackageData;

/**
 * Represents a package in the Balikobot system.
 * Extends the AbstractPackage class and implements various interfaces to provide additional functionality.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder(toBuilder = true)
public class BalikobotPackage extends AbstractPackage implements CashOnDeliveryData, CommonData, CustomerData, DeliveryData, ForeignCountryDeliveryData, NotificationData, PackageData, ParcelPackageData, Cloneable {

  /**
   * Represents a package in the Balikobot system.
   * Extends the AbstractPackage class and implements various interfaces to provide additional functionality.
   */
  public BalikobotPackage() {
    super();
  }

  /**
   * Represents a package in the Balikobot system. Extends the AbstractPackage class and implements various interfaces to provide additional functionality.
   */
  public BalikobotPackage(HashMap<Object, Object> data) {
    super(data);
  }

  /**
   * Creates a shallow copy of the BalikobotPackage object.
   *
   * @return a new BalikobotPackage object with the same field values as the original object.
   * If cloning is not supported, returns a new BalikobotPackage object with the same field values as the original object.
   */
  @Override
  public BalikobotPackage clone() {
    try {
      BalikobotPackage clone = (BalikobotPackage) super.clone();
      return clone.toBuilder().build();
    } catch (CloneNotSupportedException e) {
      return this.toBuilder().build();
    }
  }
}
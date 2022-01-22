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

@EqualsAndHashCode(callSuper = true)
@Data
@Builder(toBuilder = true)
public class BalikobotPackage extends AbstractPackage implements CashOnDeliveryData, CommonData, CustomerData, DeliveryData, ForeignCountryDeliveryData, NotificationData, PackageData, ParcelPackageData, Cloneable {
  // CashOnDeliveryData cashOnDeliveryData;
  // CustomerData customerData;
  // DeliveryData deliveryData;
  // ForeignCountryDeliveryData foreignCountryDeliveryData;
  // NotificationData notificationData;
  // PackageData packageData;
  // ParcelPackageData parcelPackageData;

  public BalikobotPackage() {
    super();
  }

  public BalikobotPackage(HashMap<Object, Object> data) {
    super(data);
  }

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
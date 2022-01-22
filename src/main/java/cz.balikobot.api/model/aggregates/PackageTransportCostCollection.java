package cz.balikobot.api.model.aggregates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

import cz.balikobot.api.contracts.Countable;
import cz.balikobot.api.contracts.IteratorAggregate;
import cz.balikobot.api.definitions.Shipper;
import cz.balikobot.api.exceptions.InvalidArgumentException;
import cz.balikobot.api.model.values.ArrayAccess;
import cz.balikobot.api.model.values.PackageTransportCost;

@Data
public class PackageTransportCostCollection implements ArrayAccess<Integer ,PackageTransportCost>, Countable, IteratorAggregate<PackageTransportCost> {
  /**
   * Package costs
   *
   * @var ArrayList<int,\Inspirum\Balikobot\Model\Values\PackageTransportCost>|\Inspirum\Balikobot\Model\Values\PackageTransportCost[]
   */
  private ArrayList<PackageTransportCost> costs = new ArrayList();

  /**
   * Shipper code
   *
   * @var String|null
   */
  private Shipper shipper;

  /**
   * OrderedPackageCollection constructor
   *
   * @param shipper
   */
  public PackageTransportCostCollection(Shipper shipper) {
    this.shipper = shipper;
  }

  /**
   * Add package cost
   *
   * @param \Inspirum\Balikobot\Model\Values\PackageTransportCost package
   * @return void
   * @throws \InvalidArgumentException
   */
  public void add(PackageTransportCost packageTransportCost) throws InvalidArgumentException {
    // validate package cost shipper
    this.validateShipper(packageTransportCost);

    // add package cost to collection
    this.costs.add(packageTransportCost);
  }

  /**
   * Get shipper
   *
   * @return String
   */
  public Shipper getShipper() {
    if (this.shipper == null) {
      throw new RuntimeException("Collection is empty");
    }

    return this.shipper;
  }

  /**
   * Get EIDs
   *
   * @return ArrayList<String>
   */
  public List<String> getBatchIds() {
    return this.costs.stream().map(PackageTransportCost::getBatchId).collect(Collectors.toList());
  }

  /**
   * Get total cost for all packages
   *
   * @return Double
   */
  public Double getTotalCost() {
    Double totalCost = 0.0;
    String currencyCode = this.getCurrencyCode();

    for(PackageTransportCost cost: this.costs) {
      if (!cost.getCurrencyCode().equals(currencyCode)) {
        throw new RuntimeException("Package cost currency codes are not the same");
      }

      totalCost += cost.getTotalCost();
    }

    return totalCost;
  }

  /**
   * Get currency code
   *
   * @return String
   */
  public String getCurrencyCode() {
    if (this.costs==null ||this.costs.isEmpty()) {
      throw new RuntimeException("Collection is empty");
    }

    return this.costs.get(0).getCurrencyCode();
  }

  /**
   * Validate shipper
   *
   * @param \Inspirum\Balikobot\Model\Values\PackageTransportCost package
   * @return void
   * @throws \InvalidArgumentException
   */
  private boolean validateShipper(PackageTransportCost pPackage) { //throws InvalidArgumentException {
    // set shipper if first pPackage in collection
    if (this.shipper == null) {
      this.shipper = pPackage.getShipper();
    }

    // validate shipper
    // throw new InvalidArgumentException(
    //     String.format(
    //         "Package is from different shipper (\"%s\" instead of \"%s\")",
    //         pPackage.getShipper(),
    //         this.shipper
    //     )
    // );
    return this.shipper == pPackage.getShipper();
  }

  /**
   * Determine if an item exists at an offset
   *
   * @param key
   * @return Boolean
   */
  public Boolean offsetExists(Integer key) {
    try {
      this.costs.get(key);
      return true;
    } catch (Exception e) {
    }
    return false;
  }

  /**
   * Get an item at a given offset
   *
   * @param key
   * @return \Inspirum\Balikobot\Model\Values\PackageTransportCost
   */
  public PackageTransportCost offsetGet(Integer key) {
    return this.costs.get(key);
  }

  /**
   * Set the item at a given offset
   *
   * @param                                                   key
   * @param \Inspirum\Balikobot\Model\Values\PackageTransportCost value
   * @return void
   */
  public void offsetSet(Integer key, PackageTransportCost value) {
    if (this.validateShipper(value)) {

      this.costs.set(key, value);
    }
  }

  /**
   * Unset the item at a given offset
   *
   * @param key
   * @return void
   */
  public void offsetUnset(Integer key) {
    this.costs.remove(key);
  }

  /**
   * Count elements of an object
   *
   * @return int
   */
  public int count() {
    return this.costs.size();
  }

  /**
   * Get an iterator for the items
   *
   * @return \ArrayIterator<int,\Inspirum\Balikobot\Model\Values\PackageTransportCost>
   */
  public Iterator<PackageTransportCost> getIterator() {
    return this.costs.iterator();
  }
}

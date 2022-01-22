package cz.balikobot.api.model.aggregates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

import cz.balikobot.api.contracts.Countable;
import cz.balikobot.api.contracts.IteratorAggregate;
import cz.balikobot.api.definitions.Shipper;
import cz.balikobot.api.model.values.ArrayAccess;
import cz.balikobot.api.model.values.OrderedPackage;

@Data
public class OrderedPackageCollection implements ArrayAccess<Integer, OrderedPackage>, Countable, IteratorAggregate<OrderedPackage> {
  /**
   * Packages
   *
   * @var ArrayList<int,\Inspirum\Balikobot\Model\Values\OrderedPackage>
   */
  private List<OrderedPackage> packages = new ArrayList<>();

  /**
   * Shipper code
   *
   * @var String|null
   */
  private Shipper shipper;

  /**
   * Labels URL
   *
   * @var String|null
   */
  private String labelsUrl = null;

  /**
   * OrderedPackageCollection constructor
   *
   * @param shipper
   */
  public OrderedPackageCollection(Shipper shipper) {
    this.shipper = shipper;
  }

  /**
   * Add package
   *
   * @param \Inspirum\Balikobot\Model\Values\OrderedPackage package
   * @return void
   * @throws \InvalidArgumentException
   */
  public void add(OrderedPackage orderedPackage) {
    // validate orderedPackage shipper
    if (this.validateShipper(orderedPackage)) {

      // add orderedPackage to collection
      this.packages.add(orderedPackage);
    } else {
      // todo
    }
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
   * Get pPackage IDs
   *
   * @return ArrayList<String>
   */
  public List<String> getPackageIds() {
    return this.packages.stream().map(OrderedPackage::getPackageId).collect(Collectors.toList());
  }

  /**
   * Get carrier IDs
   *
   * @return ArrayList<String>
   */
  public List<String> getCarrierIds() {
    return this.packages.stream().map(OrderedPackage::getCarrierId).collect(Collectors.toList());
  }

  /**
   * @param labelsUrl
   * @return void
   */
  public void setLabelsUrl(String labelsUrl) {
    this.labelsUrl = labelsUrl;
  }

  /**
   * @return String|null
   */
  public String getLabelsUrl() {
    return this.labelsUrl;
  }

  /**
   * Validate shipper
   *
   * @param \Inspirum\Balikobot\Model\Values\OrderedPackage package
   * @return void
   * @throws \InvalidArgumentException
   */
  private boolean validateShipper(OrderedPackage pPackage) { // throws InvalidArgumentException {
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
      this.packages.get(key);
      return true;
    } catch (Exception e) {
    }
    return false;
  }

  /**
   * Get an item at a given offset
   *
   * @param key
   * @return \Inspirum\Balikobot\Model\Values\OrderedPackage
   */
  public OrderedPackage offsetGet(Integer key) {
    return this.packages.get(key);
  }

  /**
   * Set the item at a given offset
   *
   * @param                                            key
   * @param \Inspirum\Balikobot\Model\Values\OrderedPackage value
   * @return void
   */
  public void offsetSet(Integer key, OrderedPackage value) {
    if (this.validateShipper(value)) {

      this.packages.set(key, value);
    }
  }

  /**
   * Unset the item at a given offset
   *
   * @param key
   * @return void
   */
  public void offsetUnset(Integer key) {
    this.packages.remove(key);
  }

  /**
   * Count elements of an object
   *
   * @return int
   */
  public int count() {
    return this.packages.size();
  }

  /**
   * Get an iterator for the items
   *
   * @return \ArrayIterator<int,\Inspirum\Balikobot\Model\Values\OrderedPackage>
   */
  public Iterator<OrderedPackage> getIterator() {
    return this.packages.iterator();
  }
}

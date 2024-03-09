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
import lombok.extern.slf4j.Slf4j;

/**
 * This class represents a collection of OrderedPackage objects.
 * It implements the ArrayAccess, Countable, and IteratorAggregate interfaces.
 * <p>
 * The OrderedPackageCollection class allows adding and accessing packages,
 * as well as providing methods to retrieve information about the packages.
 */
@Data
@Slf4j
public class OrderedPackageCollection implements ArrayAccess<Integer, OrderedPackage>, Countable, IteratorAggregate<OrderedPackage> {
  /**
   * Represents a collection of ordered packages.
   */
  private List<OrderedPackage> packages = new ArrayList<>();

  /**
   * Represents the shipper of a package.
   */
  private Shipper shipper;

  /**
   * The labelsUrl variable stores the URL for the label of an ordered package.
   */
  private String labelsUrl = null;

  /**
   * Represents a collection of ordered packages.
   */
  public OrderedPackageCollection(Shipper shipper) {
    this.shipper = shipper;
  }

  /**
   * Adds an OrderedPackage to the collection.
   *
   * @param orderedPackage The OrderedPackage to be added.
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
   * Validates the shipper of an OrderedPackage.
   *
   * @param pPackage The OrderedPackage to be validated.
   * @return boolean Returns true if the shipper of the pPackage is the same as the shipper of the collection, false otherwise.
   */
  private boolean validateShipper(OrderedPackage pPackage) {
    // set shipper if first pPackage in collection
    if (this.shipper == null) {
      this.shipper = pPackage.getShipper();
    }

    return this.shipper == pPackage.getShipper();
  }

  /**
   * Checks if the given offset exists in the collection.
   *
   * @param key The offset to check.
   * @return {@code true} if the offset exists, {@code false} otherwise.
   */
  public Boolean offsetExists(Integer key) {
    try {
      // todo this.packages.get(key);
      return true;
    } catch (Exception e) {
      log.error(String.format("Exception: %s", e.getMessage()), e);
    }
    return false;
  }

  /**
   * Retrieves the value associated with the given key from the packages collection.
   *
   * @param key The key to retrieve the value for.
   * @return The value associated with the key.
   */
  public OrderedPackage offsetGet(Integer key) {
    return this.packages.get(key);
  }

  /**
   * Sets the value at the specified key offset in the packages collection if the shipper of the value is valid.
   *
   * @param key   The key offset where the value is to be set.
   * @param value The value to be set at the specified key offset.
   */
  public void offsetSet(Integer key, OrderedPackage value) {
    if (this.validateShipper(value)) {

      this.packages.set(key, value);
    }
  }

  /**
   * Removes the value associated with the given key from the packages collection.
   *
   * @param key The key to remove the value for.
   */
  public void offsetUnset(Integer key) {
    this.packages.remove(key);
  }

  /**
   * Returns the count of packages in the collection.
   *
   * @return The count of packages.
   */
  public int count() {
    return this.packages.size();
  }

  /**
   * Returns an iterator over the elements in this collection.
   *
   * @return an iterator over the elements in this collection.
   */
  public Iterator<OrderedPackage> getIterator() {
    return this.packages.iterator();
  }
}

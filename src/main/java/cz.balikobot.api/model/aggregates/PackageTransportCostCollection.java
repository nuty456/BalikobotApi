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
import lombok.extern.slf4j.Slf4j;

/**
 * Package Transport Cost Collection.
 */
@Data
@Slf4j
public class PackageTransportCostCollection implements ArrayAccess<Integer, PackageTransportCost>, Countable, IteratorAggregate<PackageTransportCost> {
  /**
   * Variable that stores a list of PackageTransportCost objects representing different costs.
   * The list is initially empty.
   */
  private ArrayList<PackageTransportCost> costs = new ArrayList();

  /**
   * The shipper variable represents a shipper object.
   */
  private Shipper shipper;

  /**
   * Constructs a new PackageTransportCostCollection object.
   *
   * @param shipper the shipper used for calculating transport costs
   */
  public PackageTransportCostCollection(Shipper shipper) {
    this.shipper = shipper;
  }

  /**
   * Adds a PackageTransportCost to the collection of costs.
   *
   * @param packageTransportCost the PackageTransportCost to be added
   * @throws InvalidArgumentException if the package transport cost is invalid
   */
  public void add(PackageTransportCost packageTransportCost) throws InvalidArgumentException {
    // validate package cost shipper
    this.validateShipper(packageTransportCost);

    // add package cost to collection
    this.costs.add(packageTransportCost);
  }

  /**
   * Retrieves the shipper associated with this object.
   *
   * @return The shipper object.
   * @throws RuntimeException if the shipper is null.
   */
  public Shipper getShipper() {
    if (this.shipper == null) {
      throw new RuntimeException("Collection is empty");
    }

    return this.shipper;
  }

  /**
   * Retrieves a list of batch IDs from the PackageTransportCost objects contained in this instance.
   *
   * @return A list of batch IDs.
   */
  public List<String> getBatchIds() {
    return this.costs.stream().map(PackageTransportCost::getBatchId).collect(Collectors.toList());
  }

  /**
   * Calculates the total cost of all package transport costs in the specified currency.
   *
   * @return the total cost as a Double value
   * @throws RuntimeException if the currency codes of the package costs are not the same
   */
  public Double getTotalCost() {
    Double totalCost = 0.0;
    String currencyCode = this.getCurrencyCode();

    for (PackageTransportCost cost : this.costs) {
      if (!cost.getCurrencyCode().equals(currencyCode)) {
        throw new RuntimeException("Package cost currency codes are not the same");
      }

      totalCost += cost.getTotalCost();
    }

    return totalCost;
  }

  /**
   * Retrieves the currency code of the first element in the costs collection.
   *
   * @return The currency code.
   * @throws RuntimeException if the collection is empty.
   */
  public String getCurrencyCode() {
    if (this.costs == null || this.costs.isEmpty()) {
      throw new RuntimeException("Collection is empty");
    }

    return this.costs.get(0).getCurrencyCode();
  }

  /**
   * Validates the shipper of a PackageTransportCost object.
   *
   * @param pPackage the PackageTransportCost object to be validated
   * @return true if the shipper of the PackageTransportCost object matches the shipper of this object, false otherwise
   */
  private boolean validateShipper(PackageTransportCost pPackage) {
    // set shipper if first pPackage in collection
    if (this.shipper == null) {
      this.shipper = pPackage.getShipper();
    }
    return this.shipper == pPackage.getShipper();
  }

  /**
   * Checks whether the specified key exists in the map of costs.
   *
   * @param key the key to check for existence
   * @return true if the key exists in the map of costs, false otherwise
   */
  public Boolean offsetExists(Integer key) {
    try {
      // todo this.costs.get(key);
      return true;
    } catch (Exception e) {
      log.error(String.format("Exception: %s", e.getMessage()),e);
    }
    return false;
  }

  /**
   * Retrieves the PackageTransportCost object associated with the specified key from the costs map.
   *
   * @param key The key used to retrieve the PackageTransportCost object.
   * @return The PackageTransportCost object associated with the specified key, or null if the key is not found.
   */
  public PackageTransportCost offsetGet(Integer key) {
    return this.costs.get(key);
  }

  /**
   * Sets the value at the specified key in the package costs list, if the given PackageTransportCost object passes the shipper validation.
   *
   * @param key The index at which the value should be set.
   * @param value The PackageTransportCost object to be set.
   */
  public void offsetSet(Integer key, PackageTransportCost value) {
    if (this.validateShipper(value)) {

      this.costs.set(key, value);
    }
  }

  /**
   * Removes the value associated with the specified key from the costs map.
   *
   * @param key the key whose value is to be removed
   */
  public void offsetUnset(Integer key) {
    this.costs.remove(key);
  }

  /**
   * Returns the number of elements in the `costs` list.
   *
   * @return The number of elements in the `costs` list.
   */
  public int count() {
    return this.costs.size();
  }

  /**
   * Returns an iterator over the elements in this collection.
   *
   * @return an Iterator
   */
  public Iterator<PackageTransportCost> getIterator() {
    return this.costs.iterator();
  }
}

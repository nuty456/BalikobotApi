package cz.balikobot.api.model.aggregates;

import cz.balikobot.api.contracts.Countable;
import cz.balikobot.api.contracts.IteratorAggregate;
import cz.balikobot.api.definitions.Shipper;
import cz.balikobot.api.model.values.ArrayAccess;
import cz.balikobot.api.model.values.BalikobotPackage;
import cz.balikobot.api.utils.Uniqid;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Represents a collection of packages.
 */
@Data
@Slf4j
public class PackageCollection implements ArrayAccess<Integer, BalikobotPackage>, Countable, IteratorAggregate<BalikobotPackage> {
  /**
   * Packages
   */
  private List<BalikobotPackage> packages = new ArrayList();

  /**
   * Shipper code
   */
  private Shipper shipper;

  /**
   * Represents a collection of packages.
   */
  public PackageCollection(Shipper shipper) {
    this.shipper = shipper;
  }

  /**
   * Adds a BalikobotPackage to the PackageCollection.
   * If the BalikobotPackage does not have an EID (Electronic Identification),
   * a new EID is generated and set on the BalikobotPackage before adding it to the collection.
   *
   * @param balikobotPackage The BalikobotPackage to be added.
   */
  public void add(BalikobotPackage balikobotPackage) {
    // set collection EID
    if (!balikobotPackage.hasEID()) {
      balikobotPackage.setEID(this.newEID());
    }

    // add balikobotPackage to collection
    this.packages.add(balikobotPackage);
  }

  /**
   * Converts the packages stored in the PackageCollection to an ArrayList of HashMaps.
   *
   * @return An ArrayList of HashMaps, where each HashMap represents the data of a package.
   */
  public List<HashMap<Object, Object>> toArray() {
    List<HashMap<Object, Object>> result = new ArrayList<>();
    // object -> Map
    for (BalikobotPackage aPackage : packages) {
      result.add(aPackage.getData());
    }
    return result;
  }

  /**
   * Generates a new Electronic Identification (EID) for a BalikobotPackage.
   * The EID is a unique identifier used to identify packages in the Balikobot system.
   *
   * @return The generated EID as a String.
   */
  private String newEID() {
    final String s = Uniqid.uniqid("", false) + Calendar.getInstance().getTime().getTime();
    return s.substring(0, 20);
  }

  /**
   * Returns the count of packages in the PackageCollection.
   *
   * @return The number of packages in the PackageCollection.
   */
  @Override
  public int count() {
    return this.packages.size();
  }

  /**
   * Returns an Iterator for the elements of the PackageCollection class.
   *
   * @return Iterator of BalikobotPackage objects
   */
  @Override
  public Iterator<BalikobotPackage> getIterator() {
    return this.packages.iterator();
  }

  /**
   * Checks if an offset exists in the PackageCollection.
   *
   * @param key The offset to check for.
   * @return True if the offset exists, false otherwise.
   */
  @Override
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
   * Retrieves the BalikobotPackage object at the given offset from the packages collection.
   *
   * @param key The offset representing the element to be retrieved.
   * @return The BalikobotPackage object at the specified offset, or null if the offset does not exist.
   */
  @Override
  public BalikobotPackage offsetGet(Integer key) {
    return this.packages.get(key);
  }

  /**
   * Sets the value at the given offset in the packages collection.
   *
   * @param key   The offset representing the element to be set.
   * @param value The value to be set at the given offset.
   */
  @Override
  public void offsetSet(Integer key, BalikobotPackage value) {
    this.packages.set(key, value);
  }

  /**
   * Removes the element at the specified offset in the packages collection.
   *
   * @param key The offset representing the element to be removed.
   */
  @Override
  public void offsetUnset(Integer key) {
    this.packages.remove(key);
  }

}

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

@Data
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
   * PackageCollection constructor
   *
   * @param shipper
   */
  public PackageCollection(Shipper shipper) {
    this.shipper = shipper;
  }

  /**
   * Add package to collection
   *
   * @param \Inspirum\Balikobot\Model\Values\Package package
   * @return void
   */
  public void add(BalikobotPackage balikobotPackage) {
    // clone balikobotPackage
    // todo balikobotPackage = balikobotPackage.clone();

    // set collection EID
    if (!balikobotPackage.hasEID()) {
      balikobotPackage.setEID(this.newEID());
    }

    // add balikobotPackage to collection
    this.packages.add(balikobotPackage);
  }


  /**
   * Get the collection of packages as a plain ArrayList<>
   *
   * @return ArrayList<ArrayList < String, mixed>>
   */
  public List<HashMap<Object, Object>> toArray() {
    List<HashMap<Object, Object>> result = new ArrayList<>();
    // ObjectMapper oMapper = new ObjectMapper();

    // object -> Map
    for (BalikobotPackage aPackage : packages) {
      // HashMap<Object, Object> map = oMapper.convertValue(aPackage.getData(), HashMap.class);
      result.add(aPackage.getData());
    }
    return result;
  }

  /**
   * Get new EID for package batch
   *
   * @return String
   */
  private String newEID() { // todo predelat.. maji limit na 23 znaku
    final String s = Uniqid.uniqid("", false) + Calendar.getInstance().getTime().getTime();
    return s.substring(0, 20); // todo return substr(time() . uniqid(), -20, 20);
  }

  /**
   * Count elements of an object
   *
   * @return int
   */
  @Override
  public int count() {
    return this.packages.size();
  }

  /**
   * Get an iterator for the items
   *
   * @return \ArrayIterator<int,\Inspirum\Balikobot\Model\Values\Package>
   */
  @Override
  public Iterator<BalikobotPackage> getIterator() {
    return this.packages.iterator();
  }

  /**
   * Determine if an item exists at an offset
   *
   * @param key
   * @return Boolean
   */
  @Override
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
   * @return mixed
   */
  @Override
  public BalikobotPackage offsetGet(Integer key) {
    return this.packages.get(key);
  }

  /**
   * Set the item at a given offset
   *
   * @param key
   * @param value
   * @return void
   */
  @Override
  public void offsetSet(Integer key, BalikobotPackage value) {
    this.packages.set(key, value);
  }

  /**
   * Unset the item at a given offset
   *
   * @param key
   * @return void
   */
  @Override
  public void offsetUnset(Integer key) {
    this.packages.remove(key);
  }

}

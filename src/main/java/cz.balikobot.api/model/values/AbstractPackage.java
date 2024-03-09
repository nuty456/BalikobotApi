package cz.balikobot.api.model.values;

import java.util.HashMap;

import lombok.Data;

import cz.balikobot.api.model.values.pkg.CommonData;
import lombok.NoArgsConstructor;

/**
 * The AbstractPackage class represents a package in the system.
 * It provides methods for working with package data and implements the ArrayAccess interface.
 */
@Data
@NoArgsConstructor
public class AbstractPackage implements ArrayAccess {
  /**
   * The CommonData interface represents data that can be accessed using array-like syntax.
   * It extends the OffsetData interface and provides methods for getting and setting data at specific offsets.
   */
  public CommonData commonData;

  /**
   * The data collection that stores package data.
   */
  private HashMap<Object, Object> data = new HashMap<>();

  /**
   * The AbstractPackage class represents a package in the system.
   * It provides methods for working with package data and implements the ArrayAccess interface.
   */
  public AbstractPackage(HashMap<Object, Object> data) {
    this.data = data;
  }

  /**
   * Determines whether an offset exists in the data collection.
   *
   * @param key The offset to check for.
   * @return true if the offset exists, false otherwise.
   */
  @Override
  public Boolean offsetExists(Object key) {
    return this.data.containsKey(key);
  }

  /**
   * Retrieves the value associated with the specified key from the data collection.
   *
   * @param key The key to retrieve the value for.
   * @return The value associated with the specified key, or null if the key is not found.
   */
  @Override
  public Object offsetGet(Object key) {
    return this.data.get(key);
  }

  /**
   * Sets the value at the specified offset in the data collection.
   *
   * @param key   The key of the item to be set.
   * @param value The value to be set at the specified offset.
   */
  @Override
  public void offsetSet(Object key, Object value) {
    this.data.put(key, value);
  }

  /**
   * Removes the item at the specified offset from the package data.
   *
   * @param key the offset of the item to be removed
   */
  @Override
  public void offsetUnset(Object key) {
    this.data.remove(key);
  }

  /**
   * Returns the data from the AbstractPackage object as a HashMap.
   *
   * @return The data from the AbstractPackage object as a HashMap.
   */
  public HashMap<Object, Object> toArray() {
    return this.data;
  }
}

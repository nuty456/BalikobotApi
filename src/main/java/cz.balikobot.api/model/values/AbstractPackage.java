package cz.balikobot.api.model.values;

import java.util.HashMap;

import lombok.Data;

import cz.balikobot.api.model.values.pkg.CommonData;

@Data
public class AbstractPackage implements ArrayAccess {
  public CommonData commonData;

  /**
   * Package data
   *
   * @var ArrayList<String,mixed>
   */
  private HashMap<Object, Object> data = new HashMap<>();

  /**
   * Package constructor
   */
  public AbstractPackage() {
  }

  /**
   * Package constructor
   *
   * @param data
   */
  public AbstractPackage(HashMap<Object, Object> data) {
    this.data = data;
  }

  /**
   * Determine if an item exists at an offset
   *
   * @param key
   * @return Boolean
   */
  @Override
  public Boolean offsetExists(Object key) {
    return this.data.containsKey(key);
  }

  /**
   * Get an item at a given offset
   *
   * @param key
   * @return mixed
   */
  @Override
  public Object offsetGet(Object key) {
    return this.data.get(key);
  }

  /**
   * Set the item at a given offset
   *
   * @param key
   * @param value
   * @return void
   */
  @Override
  public void offsetSet(Object key, Object value) {
    this.data.put(key, value);
  }

  /**
   * Unset the item at a given offset
   *
   * @param key
   * @return void
   */
  @Override
  public void offsetUnset(Object key) {
    this.data.remove(key);
  }

  /**
   * Get the collection of packages as a plain ArrayList<>
   *
   * @return ArrayList<String,mixed>
   */
  public HashMap<Object, Object> toArray() {
    return this.data;
  }
}

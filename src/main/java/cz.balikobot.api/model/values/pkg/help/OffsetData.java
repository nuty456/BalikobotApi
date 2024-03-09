package cz.balikobot.api.model.values.pkg.help;

/**
 * Represents a class that provides offset data for setting item values at specific offsets.
 */
public interface OffsetData {
  /**
   * Sets the value at the specified offset in the data structure.
   *
   * @param key the key representing the offset
   * @param value the value to be set at the offset
   */
  void offsetSet(Object key, Object value);
}

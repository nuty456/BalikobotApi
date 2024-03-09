package cz.balikobot.api.contracts;

import java.util.Iterator;

/**
 * IteratorAggregate.
 * @param <T>
 */
public interface IteratorAggregate<T> extends Traversable {
  /**
   * Returns an Iterator for the elements of this class.
   *
   * @return an Iterator over the elements of this class
   */
  Iterator<T> getIterator();

}

package cz.balikobot.api.contracts;

import java.util.Iterator;

public interface IteratorAggregate<T> extends Traversable {
  /**
   * Retrieve an external iterator
   * @return Traversable An instance of an object implementing <b>Iterator</b> or
   * <b>Traversable</b>
   * @throws Exception on failure.
   */
  Iterator<T> getIterator();

}

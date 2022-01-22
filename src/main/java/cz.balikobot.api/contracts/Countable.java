package cz.balikobot.api.contracts;

public interface Countable {
  /**
   * Count elements of an object
   *
   * @return int The custom count as an integer.
   *     </p>
   *     <p>
   *     The return value is cast to an integer.
   * @link https://php.net/manual/en/countable.count.php
   */
  int count();

}

package cz.balikobot.api.model.values;

public interface ArrayAccess<T, K> {

  /**
   * Whether a offset exists
   * @link https://php.net/manual/en/arrayaccess.offsetexists.php
   * @param offset <p>
   * An offset to check for.
   * </p>
   * @return Boolean true on success or false on failure.
   * </p>
   * <p>
   * The return value will be casted to Boolean if non-Boolean was returned.
   */
  Boolean offsetExists(T offset);

  /**
   * Offset to retrieve
   * @link https://php.net/manual/en/arrayaccess.offsetget.php
   * @param offset <p>
   * The offset to retrieve.
   * </p>
   * @return mixed Can return all value types.
   */
  Object offsetGet(T offset);

  /**
   * Offset to set
   * @link https://php.net/manual/en/arrayaccess.offsetset.php
   * @param offset <p>
   * The offset to assign the value to.
   * </p>
   * @param value <p>
   * The value to set.
   * </p>
   * @return void
   */
  void offsetSet(T offset, K value);

  /**
   * Offset to unset
   * @link https://php.net/manual/en/arrayaccess.offsetunset.php
   * @param offset <p>
   * The offset to unset.
   * </p>
   * @return void
   */
  void offsetUnset(T offset);
}

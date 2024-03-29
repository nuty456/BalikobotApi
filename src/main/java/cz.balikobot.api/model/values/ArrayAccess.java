package cz.balikobot.api.model.values;

/**
 * The ArrayAccess interface provides a set of methods to implement array-like access to an object.
 *
 * @param <T> the type of the offset
 * @param <K> the type of the value
 */
public interface ArrayAccess<T, K> {

  /**
   * Whether an offset exists
   *
   * @param offset <p>
   *               An offset to check for.
   *               </p>
   * @return Boolean true on success or false on failure.
   * </p>
   * <p>
   * The return value will be casted to Boolean if non-Boolean was returned.
   */
  Boolean offsetExists(T offset);

  /**
   * Offset to retrieve
   *
   * @param offset <p>
   *               The offset to retrieve.
   *               </p>
   * @return mixed Can return all value types.
   */
  Object offsetGet(T offset);

  /**
   * Offset to set
   *
   * @param offset <p>
   *               The offset to assign the value to.
   *               </p>
   * @param value  <p>
   *               The value to set.
   *               </p>
   */
  void offsetSet(T offset, K value);

  /**
   * Offset to unset
   *
   * @param offset <p>
   *               The offset to unset.
   *               </p>
   */
  void offsetUnset(T offset);
}

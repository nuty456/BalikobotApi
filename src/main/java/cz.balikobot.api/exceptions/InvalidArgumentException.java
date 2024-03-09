package cz.balikobot.api.exceptions;

/**
 * Invalid Argument Exception.
 */
public class InvalidArgumentException extends Exception {
  public InvalidArgumentException(String message) {
    super(message);
  }
}

package cz.balikobot.api.exceptions;

import java.util.HashMap;

/**
 * Bad Request Exception.
 */
public class BadRequestException extends Exception {
  /**
   *
   */
  public BadRequestException(String message) {
    super(message);
  }

  public BadRequestException(String message, Integer code) {
    super(String.format("%s - %d", message, code));
  }

  public BadRequestException(HashMap<Object, Object> response) {

  }
}
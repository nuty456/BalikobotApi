package cz.balikobot.api.exceptions;

/**
 * Unauthorized Exception.
 */
public class UnauthorizedException extends Exception {
  public UnauthorizedException(String message) {
    super(message);
  }

  public UnauthorizedException(String message, int statusCode) {
    super(message + statusCode);
  }
}
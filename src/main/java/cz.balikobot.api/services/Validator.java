package cz.balikobot.api.services;

import cz.balikobot.api.exceptions.BadRequestException;
import cz.balikobot.api.exceptions.UnauthorizedException;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;

/**
 * The Validator class provides methods for validating status codes and response data.
 */
@Data
public class Validator {
  /**
   * Validates the status code and response data.
   *
   * @param statusCode The HTTP status code.
   * @param response   The response data.
   * @throws UnauthorizedException If the status code is 401 (Unauthorized) or 403 (Forbidden).
   * @throws BadRequestException   If the status code is greater than or equal to 400 (Bad Request).
   */
  public void validateStatus(int statusCode, HashMap<Object, Object> response) throws UnauthorizedException, BadRequestException {
    // unauthorized
    if (statusCode == 401 || statusCode == 403) {
      throw new UnauthorizedException(null, statusCode);
    }

    // request error
    if (statusCode >= 400) {
      StringBuilder statusMessage = new StringBuilder();
      if (response.containsKey("status_message")) {
        statusMessage = new StringBuilder((String) response.get("status_message"));
      } else if (response.containsKey("packages")) {
        final ArrayList<HashMap<Object, Object>> packages = (ArrayList<HashMap<Object, Object>>) response.get("packages");
        if (packages != null && !packages.isEmpty()) {
          for (HashMap<Object, Object> pkg : packages) {
            if (pkg.containsKey("errors")) {
              final ArrayList<HashMap<Object, Object>> errors = (ArrayList<HashMap<Object, Object>>) pkg.get("errors");
              for (HashMap<Object, Object> error : errors) {
                if (error.containsKey("attribute")) {
                  final String attribute = (String) error.get("attribute");
                  final String message = (String) error.get("message");
                  statusMessage.append(String.format("%s - %s", attribute, message)).append("||");
                }
              }
            }
          }
        }
      } else if (response.containsKey("errors")) {
        final ArrayList<HashMap<Object, Object>> errors = (ArrayList<HashMap<Object, Object>>) response.get("errors");
        if (errors != null && !errors.isEmpty()) {
          for (HashMap<Object, Object> error : errors) {
            if (error.containsKey("status_message")) {
              final String packageId = (String) error.get("package_id");
              final String message = (String) error.get("status_message");
              statusMessage.append(String.format("%s - %s", packageId, message)).append("||");
            }
          }
        }
      }
      final int code = response.get("status") != null ? (int) response.get("status") : statusCode;
      throw new BadRequestException(statusMessage.toString(), code);
    }
  }

  /**
   * Validates the status response of an API request.
   *
   * @param responseItem     The specific item in the response.
   * @param response         The full response.
   * @param shouldHaveStatus Indicates whether the response item should have a status.
   * @return true if the status response is valid, false otherwise.
   * @throws UnauthorizedException if the status code is 401 (Unauthorized) or 403 (Forbidden).
   * @throws BadRequestException   if the status code is greater than or equal to 400 (Bad Request).
   */
  public boolean validateResponseStatus(
      HashMap<Object, Object> responseItem,
      HashMap<Object, Object> response,
      Boolean shouldHaveStatus
  ) throws UnauthorizedException, BadRequestException {
    if (!shouldHaveStatus && (responseItem != null && responseItem.containsKey("status") && !((boolean) responseItem.get("status")))) {
      return true;
    }
    // todo 500 ale musi se upravit to nad tim
    this.validateStatus(responseItem != null && responseItem.get("status") != null ? (int) responseItem.get("status") : 200, response != null ? response : responseItem);
    return true;
  }

  /**
   * Validates if each item in the given list contains the specified attribute.
   *
   * @param items     The list of items to validate.
   * @param attribute The attribute to check in each item.
   * @param response  The response data.
   * @throws BadRequestException if any item in the list does not contain the attribute.
   */
  public void validateResponseItemHasAttribute(ArrayList<HashMap<Object, Object>> items, String attribute, HashMap<Object, Object> response) throws BadRequestException {
    for (HashMap<Object, Object> item : items) {
      if (!item.containsKey(attribute)) {
        throw new BadRequestException(response);
      }
    }
  }
}

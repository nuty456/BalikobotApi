package cz.balikobot.api.services;

import cz.balikobot.api.exceptions.BadRequestException;
import cz.balikobot.api.exceptions.UnauthorizedException;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;

@Data
public class Validator {
  /**
   * Validate status code
   *
   * @param statusCode
   * @param response
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
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
        if (packages != null && packages.size() > 0) {
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
        if (errors != null && errors.size() > 0) {
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
   * Validate response item status
   *
   * @param responseItem
   * @param response
   * @param shouldHaveStatus
   * @return void
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
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
    this.validateStatus((int) (responseItem != null && responseItem.get("status") != null ? (int) responseItem.get("status") : 200), response != null ? response : responseItem);
    return true;
  }

  /**
   * Validate that every response item has given attribute
   *
   * @param items
   * @param attribute
   * @param response
   * @return void
   * @throws \Inspirum\Balikobot\Exceptions\BadRequestException
   */
  public void validateResponseItemHasAttribute(ArrayList<HashMap<Object, Object>> items, String attribute, HashMap<Object, Object> response) throws BadRequestException {
    for (HashMap<Object, Object> item : items) {
      if (!item.containsKey(attribute)) {
        throw new BadRequestException(response);
      }
    }
  }

  /**
   * Validate response ArrayList<> has correct indexes
   *
   * @param response
   * @param count
   * @return void
   * @throws \Inspirum\Balikobot\Exceptions\BadRequestException
   */
  public void validateIndexes(HashMap<Object, Object> response, int count) {
    // todo if (ArrayList <>_keys(response) != range(0, count - 1)){
    //   throw new BadRequestException(response);
    // }
  }
}

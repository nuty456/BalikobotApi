package cz.balikobot.api.contracts;

import java.net.URL;
import java.util.HashMap;

import cz.balikobot.api.definitions.API;
import cz.balikobot.api.definitions.Shipper;
import cz.balikobot.api.exceptions.BadRequestException;
import cz.balikobot.api.exceptions.UnauthorizedException;

/**
 * Iterator Aggregate.
 */
public interface RequesterInterface {
  /**
   * Makes a call to the API with the specified parameters.
   *
   * @param version The API version to use.
   * @param shipper The shipper to make the request to.
   * @param request The request string.
   * @param data The data to send with the request.
   * @param shouldHaveStatus Whether the response should include status information.
   * @param gzip Whether to use gzip compression for the request.
   * @return A HashMap containing the response data.
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException If the request is invalid.
   */
  HashMap<Object, Object> call(
      API version,
      Shipper shipper,
      String request,
      HashMap<Object, Object> data,
      Boolean shouldHaveStatus,
      Boolean gzip
  ) throws UnauthorizedException, BadRequestException;

  /**
   * Makes a call to the API with the specified parameters.
   *
   * @param version The API version to use. (API)
   * @param shipper The shipper to make the request to. (Shipper)
   * @param request The request string. (String)
   * @return A HashMap containing the response data. (HashMap<Object, Object>)
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException If the request is invalid.
   */
  HashMap<Object, Object> call(
      API version,
      Shipper shipper,
      String request
  ) throws UnauthorizedException, BadRequestException;

  /**
   * Makes a call to the API with the specified parameters.
   *
   * @param version The API version to use. (API)
   * @param shipper The shipper to make the request to. (Shipper)
   * @param request The request string. (String)
   * @param data The data to send with the request. (HashMap<Object, Object>)
   * @return A HashMap containing the response data. (HashMap<Object, Object>)
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException If the request is invalid.
   */
  HashMap<Object, Object> call(
      API version,
      Shipper shipper,
      String request,
      HashMap<Object, Object> data
  ) throws UnauthorizedException, BadRequestException;

  /**
   * Makes a HTTP request to the specified URL and path with the given request data.
   *
   * @param url  The URL of the API.
   * @param path The path of the API endpoint.
   * @param data The data to send with the request.
   * @return The HTTP response from the API.
   */
  org.apache.http.HttpResponse request(URL url, String path, HashMap<Object, Object> data);
}
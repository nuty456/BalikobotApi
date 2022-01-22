package cz.balikobot.api.contracts;

import java.net.URL;
import java.util.HashMap;

import cz.balikobot.api.definitions.API;
import cz.balikobot.api.definitions.Shipper;
import cz.balikobot.api.exceptions.BadRequestException;
import cz.balikobot.api.exceptions.UnauthorizedException;

public interface RequesterInterface {
  /**
   * Call API
   *
   * @param version
   * @param request
   * @param shipper
   * @param data
   * @param shouldHaveStatus
   * @param gzip
   * @return ArrayList<mixed, mixed>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  HashMap<Object, Object> call(
      API version,
      Shipper shipper,
      String request,
      HashMap<Object, Object> data,
      Boolean shouldHaveStatus,
      Boolean gzip
  ) throws UnauthorizedException, BadRequestException;

  HashMap<Object, Object> call(
      API version,
      Shipper shipper,
      String request
  ) throws UnauthorizedException, BadRequestException;

  HashMap<Object, Object> call(
      API version,
      Shipper shipper,
      String request,
      HashMap<Object, Object> data
  ) throws UnauthorizedException, BadRequestException;

  /**
   * Get API response
   *
   * @param url
   * @param data
   * @return \Psr\Http\Message\ResponseInterface
   */
  org.apache.http.HttpResponse request(URL url, String path, HashMap<Object, Object> data);
}
package cz.balikobot.api.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import cz.balikobot.api.contracts.RequesterInterface;
import cz.balikobot.api.definitions.API;
import cz.balikobot.api.definitions.Shipper;
import cz.balikobot.api.exceptions.BadRequestException;
import cz.balikobot.api.exceptions.UnauthorizedException;
import io.vertx.core.Vertx;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.json.JsonException;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Requester class for making API calls.
 */
@Data
@Slf4j
public class Requester implements RequesterInterface {
  private Vertx vertX;
  /**
   * API User
   */
  private String apiUser;

  /**
   * API key
   */
  private String apiKey;

  /**
   * SSL verification enabled
   */
  private Boolean sslVerify;

  /**
   * Response validator
   */
  private Validator validator;

  /**
   * Constructs a new instance of Requester.
   *
   * @param apiUser   the API user for authentication
   * @param apiKey    the API key for authentication
   * @param sslVerify if SSL verification is required
   * @param vertX     the Vert.x instance
   */
  public Requester(String apiUser, String apiKey, Boolean sslVerify, Vertx vertX) {
    this.vertX = vertX;
    this.apiUser = apiUser;
    this.apiKey = apiKey;
    this.sslVerify = sslVerify;

    this.validator = new Validator();
  }

  /**
   * Executes a method call with the given parameters.
   *
   * @param version The API version to use for the method call.
   * @param shipper The shipper to use for the method call.
   * @param request The request to be executed.
   * @return A hashmap containing the result of the method call.
   * @throws UnauthorizedException If the method call is unauthorized.
   * @throws BadRequestException   If the request is invalid.
   */
  public HashMap<Object, Object> call(
      API version,
      Shipper shipper,
      String request
  ) throws UnauthorizedException, BadRequestException {
    return call(version, shipper, request, new HashMap<>(), true, false);
  }

  /**
   * Calls the specified API with the given parameters and returns a HashMap.
   *
   * @param version The API version to use.
   * @param shipper The shipper object to use.
   * @param request The request to execute.
   * @param data    The data to send with the request.
   * @return A HashMap containing the response from the API.
   * @throws UnauthorizedException If the API call is unauthorized.
   * @throws BadRequestException   If the API call has a bad request.
   */
  public HashMap<Object, Object> call(
      API version,
      Shipper shipper,
      String request,
      HashMap<Object, Object> data
  ) throws UnauthorizedException, BadRequestException {
    return call(version, shipper, request, data, true, false);
  }

  /**
   * Performs a method call to the API server and retrieves the response.
   *
   * @param version          The API version to use.
   * @param shipper          The shipper object.
   * @param request          The request for the API server.
   * @param data             The data to be sent in the request.
   * @param shouldHaveStatus Whether the response should have a status or not.
   * @param gzip             Whether to compress the response using gzip or not.
   * @return A HashMap containing the parsed response data from the API server.
   * @throws UnauthorizedException if the request is unauthorized.
   * @throws BadRequestException   if the request is invalid.
   */
  public HashMap<Object, Object> call(
      API version,
      Shipper shipper,
      String request,
      HashMap<Object, Object> data,
      Boolean shouldHaveStatus,
      Boolean gzip
  ) throws UnauthorizedException, BadRequestException {
    int statusCode = 0;
    String content;
    HashMap<Object, Object> contentHashMap = new HashMap<>();
    try {
      // resolve url
      String path = ((shipper != null ? shipper.label : "") + "/" + request).trim();
      path = path.replace("//", "/");
      URL host = this.resolveHostName(version.toString());

      // add query to compress response : gzip
      if (gzip) {
        path += "?gzip=1";
      }

      // call API server and get response
      org.apache.http.HttpResponse response = this.request(host, path, data);

      // get status code and content
      statusCode = response.getStatusLine().getStatusCode();
      content = EntityUtils.toString(response.getEntity());
      log.info(String.format("Returned response from Balikobot: %s", content));

      // parse response content to assoc ArrayList<>
      contentHashMap = parseContents(content, statusCode < 300);
    } catch (Exception e) {
      log.error(String.format("Exception: %s", e.getMessage()), e);
    }

    // validate response status code
    this.validateResponse(statusCode, contentHashMap, shouldHaveStatus);

    // return response
    return contentHashMap;
  }

  /**
   * Sends an HTTP request to the specified URL with the given path and data.
   *
   * @param url  the URL to send the request to
   * @param path the path to append to the URL
   * @param data the data to include in the request body (null for GET requests)
   * @return the HTTP response from the server
   */
  public org.apache.http.HttpResponse request(URL url, String path, HashMap<Object, Object> data) {
    int statusCode;
    try {
      CredentialsProvider provider = new BasicCredentialsProvider();
      UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(apiUser, apiKey);
      provider.setCredentials(AuthScope.ANY, credentials);


      SSLContextBuilder builder = new SSLContextBuilder();
      builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
      SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
          builder.build());
      CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).setDefaultCredentialsProvider(provider).build();

      if (data != null && !data.isEmpty()) { // POST
        final String urlStr = String.format("%s://%s%s", url.getProtocol(), url.getHost(), url.getPath() + path);
        log.info(String.format("Sending POST request to %s", urlStr));
        final HttpPost request = new HttpPost(urlStr);

        Gson gson = new Gson();
        String json = gson.toJson(data);
        log.info(String.format("Sending JSON data: %s", json));

        StringEntity requestEntity = new StringEntity(
            json,
            ContentType.APPLICATION_JSON);
        request.setEntity(requestEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        final org.apache.http.HttpResponse httpResponse = httpClient.execute(request);
        statusCode = httpResponse.getStatusLine().getStatusCode();
        log.info(String.format("Status code %d", statusCode));
        return httpResponse;
      } else {
        final String urlStr = String.format("%s://%s%s", url.getProtocol(), url.getHost(), url.getPath() + path);
        log.info(String.format("Sending GET request to %s", urlStr));
        final org.apache.http.HttpResponse httpResponse = httpClient.execute(new HttpGet(urlStr));
        statusCode = httpResponse.getStatusLine().getStatusCode();
        log.info(String.format("Status code %d", statusCode));
        return httpResponse;
      }
    } catch (Exception e) {
      log.error(String.format("Exception: %s", e.getMessage()), e);
    }

    return null;
  }

  /**
   * Parses the given content string and returns the decoded result as a HashMap.
   * If an error occurs during decoding, it can be logged depending on the value of the throwOnError parameter.
   *
   * @param content      the content string to be parsed and decoded
   * @param throwOnError a boolean indicating whether to throw an error if decoding fails
   * @return a HashMap representing the decoded content, or null if an error occurred and throwOnError is false
   */
  public static HashMap<Object, Object> parseContents(String content, Boolean throwOnError) {
    try {
      return decode(content);
    } catch (JsonException exception) {
      log.error(String.format("Exception: %s", exception), exception);
    }
    return null;
  }

  /**
   * Decodes the given content into a HashMap of objects and returns it.
   *
   * @param content the content to be decoded
   * @return a HashMap containing the decoded content
   */
  protected static HashMap<Object, Object> decode(String content) {
    try {
      TypeReference<HashMap<Object, Object>> typeRef = new TypeReference<HashMap<Object, Object>>() {
      };
      return new ObjectMapper().readValue(content, typeRef);
    } catch (IOException e) {
      log.error(String.format("Exception: %s", e.getMessage()), e);
    }
    return null;
  }

  /**
   * Resolves the host name based on the given version.
   *
   * @param version the version of the API
   * @return the URL for the resolved host name based on the given version
   */
  private URL resolveHostName(String version) {
    final API apiEnum = API.valueOf(version);
    final URL url = API.URL.get(apiEnum);
    return url != null ? url : API.URL.get(API.V2V1);
  }

  /**
   * Validates the HTTP response based on the provided status code and response body.
   *
   * @param statusCode       The HTTP status code of the response.
   * @param response         The response body as a HashMap.
   * @param shouldHaveStatus Determines whether the response should have a status code (true) or not (false).
   * @throws UnauthorizedException If the request is unauthorized.
   * @throws BadRequestException   If the request is invalid or malformed.
   */
  @SneakyThrows
  private void validateResponse(int statusCode, HashMap<Object, Object> response, Boolean shouldHaveStatus) throws UnauthorizedException, cz.balikobot.api.exceptions.BadRequestException {
    this.validator.validateStatus(statusCode, response);

    this.validator.validateResponseStatus(response, null, shouldHaveStatus);
  }

  /**
   * Converts a JSONObject to a Map.
   *
   * @param json the JSONObject to convert to a Map
   * @return a Map representation of the given JSONObject
   * @throws JSONException if an error occurs while converting the JSONObject
   */
  public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
    Map<String, Object> retMap = new HashMap<>();

    if (json != JSONObject.NULL) {
      retMap = toMap(json);
    }
    return retMap;
  }

  /**
   * Converts a JSONObject to a Map<String, Object>.
   *
   * @param object The JSONObject to convert.
   * @return A Map<String, Object> representing the converted JSONObject.
   * @throws JSONException if there is an error parsing the JSONObject.
   */
  public static Map<String, Object> toMap(JSONObject object) throws JSONException {
    Map<String, Object> map = new HashMap<>();

    Iterator<String> keysItr = object.keys();
    while (keysItr.hasNext()) {
      String key = keysItr.next();
      Object value = object.get(key);

      if (value instanceof JSONArray) {
        value = toList((JSONArray) value);
      } else if (value instanceof JSONObject) {
        value = toMap((JSONObject) value);
      }
      map.put(key, value);
    }
    return map;
  }

  /**
   * Converts a JSONArray to a List of objects.
   *
   * @param array the JSONArray to be converted
   * @return the converted List of objects
   * @throws JSONException if there is an error in the JSON structure
   */
  public static List<Object> toList(JSONArray array) throws JSONException {
    List<Object> list = new ArrayList<>();
    for (int i = 0; i < array.length(); i++) {
      Object value = array.get(i);
      if (value instanceof JSONArray) {
        value = toList((JSONArray) value);
      } else if (value instanceof JSONObject) {
        value = toMap((JSONObject) value);
      }
      list.add(value);
    }
    return list;
  }
}
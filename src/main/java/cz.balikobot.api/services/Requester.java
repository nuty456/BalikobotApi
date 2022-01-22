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
import io.vertx.ext.web.client.HttpResponse;

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

  // private static final Logger log = LoggerFactory.getLogger(NewVertxClient.class);
  // private WebClient client = null;
  // private static final String BASE_URI = "http://localhost:8080";
  // private String url = null;
  // private String host = null;
  // private Integer port = null;
  // private String path = null;
  // private String username = null;
  // private String password = null;
  // private String encoding = null;
  // private HttpRequest<Buffer> httpRequest = null;
  // public String type = null;
  // public String payload = null;
  // public Handler<AsyncResult<HttpResponse<Buffer>>> handler = null;

  /**
   * Balikobot API client
   *
   * @param apiUser
   * @param apiKey
   * @param sslVerify
   * @param vertX
   */
  public Requester(String apiUser, String apiKey, Boolean sslVerify, Vertx vertX) {
    this.vertX = vertX;
    this.apiUser = apiUser;
    this.apiKey = apiKey;
    this.sslVerify = sslVerify;

    this.validator = new Validator();
  }

  /**
   * Call API
   *
   * @param version
   * @param request
   * @param shipper
   * @return ArrayList<mixed, mixed>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public HashMap<Object, Object> call(
      API version,
      Shipper shipper,
      String request
  ) throws UnauthorizedException, BadRequestException {
    return call(version, shipper, request, new HashMap<>(), true, false);
  }

  /**
   * Call API
   *
   * @param version
   * @param request
   * @param shipper
   * @param data
   * @return ArrayList<mixed, mixed>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
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
  public HashMap<Object, Object> call(
      API version,
      Shipper shipper,
      String request,
      HashMap<Object, Object> data,
      Boolean shouldHaveStatus,
      Boolean gzip
  ) throws UnauthorizedException, BadRequestException {
    int statusCode = 0;
    String content = null;
    HashMap<Object, Object> contentHashMap = new HashMap<>();
    try {
      // resolve url
      String path = ((shipper != null ? shipper.label : "") + "/" + request).trim();
      // String path = (shipper.label + "/" + request.label + "/").trim();
      // String path = (shipper.toString() + "/" + request.toString()).trim();
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
      // content = this.getContents(response.getEntity().getContent()., gzip);
      content = EntityUtils.toString(response.getEntity());
      log.info(String.format("Returned response from Balikobot: %s", content));

      // parse response content to assoc ArrayList<>
      contentHashMap = this.parseContents(content, statusCode < 300);
    } catch (Exception e) {
      log.error(String.format("Exception: %s", e.getMessage()), e);
    }

    // validate response status code
    this.validateResponse(statusCode, contentHashMap, shouldHaveStatus);

    // return response
    return contentHashMap;
  }

  /**
   * Get API response
   *
   * @param url
   * @param data
   * @return \Psr\Http\Message\ResponseInterface
   */
  public org.apache.http.HttpResponse request(URL url, String path, HashMap<Object, Object> data) {
    HttpResponse response = null;
    int statusCode = 0;
    try {
      // HttpClient client = new DefaultHttpClient();
      // SSLContext sslContext = SSLContext.getInstance("TLS");
      //
      // TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      // KeyStore ks = KeyStore.getInstance("JKS");
      // File trustFile = new File("clientTrustStore.jks");
      // ks.load(new FileInputStream(trustFile), null);
      // tmf.init(ks);
      // sslContext.init(null, tmf.getTrustManagers(), null);
      // SSLSocketFactory sf = new SSLSocketFactory(sslContext);
      // sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      // Scheme scheme = new Scheme("https", sf, 443);
      // client.getConnectionManager().getSchemeRegistry().register(scheme);
      //

      CredentialsProvider provider = new BasicCredentialsProvider();
      UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(apiUser, apiKey);
      provider.setCredentials(AuthScope.ANY, credentials);


      SSLContextBuilder builder = new SSLContextBuilder();
      builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
      SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
          builder.build());
      CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).setDefaultCredentialsProvider(provider).build();

      // HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
      if (data != null && data.size() > 0) { // POST
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
        // final String urlStr = String.format("%s://%s:%d%s", url.getProtocol(), url.getHost(), url.getPort() > 0 ? url.getPort() : url.getProtocol().toLowerCase().equals("http") ? 80 : 443, url.getPath() + path);
        final String urlStr = String.format("%s://%s%s", url.getProtocol(), url.getHost(), url.getPath() + path);
        log.info(String.format("Sending GET request to %s", urlStr));
        final org.apache.http.HttpResponse httpResponse = httpClient.execute(new HttpGet(urlStr));
        statusCode = httpResponse.getStatusLine().getStatusCode();
        log.info(String.format("Status code %d", statusCode));
        return httpResponse;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
    // // init curl
    // ch = curl_init();
    //
    // // set headers
    // curl_setopt(ch, CURLOPT_URL, url);
    // curl_setopt(ch, CURLOPT_RETURNTRANSFER, true);
    // curl_setopt(ch, CURLOPT_HEADER, false);
    //
    // // disable SSL verification
    // if (this.sslVerify == false) {
    //   curl_setopt(ch, CURLOPT_SSL_VERIFYHOST, false);
    //   curl_setopt(ch, CURLOPT_SSL_VERIFYPEER, false);
    // }
    //
    // // set data
    // if (count(data) > 0) {
    //   curl_setopt(ch, CURLOPT_POST, true);
    //   curl_setopt(ch, CURLOPT_POSTFIELDS, json_encode(data));
    // }
    //
    // // set auth
    // curl_setopt(ch, CURLOPT_HTTPHEADER,[
    //     "Authorization: Basic ".base64_encode(this.apiUser.":". this.apiKey),
    // "Content-Type: application/json",
    //     ]);
    //
    // // execute curl
    // response = curl_exec(ch);
    // statusCode = curl_getinfo(ch, CURLINFO_HTTP_CODE);
    //
    // // check for errors.
    // if (response == false) {
    //   throw new RuntimeException(curl_error(ch), curl_errno(ch));
    // }
    //
    // // close curl
    // curl_close(ch);
    //
    // return new Response((int) statusCode,[],(String) response);
  }

  /**
   * Decode API response JSON to ArrayList<>
   *
   * @param content
   * @return ArrayList<mixed, mixed>
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  public static HashMap<Object, Object> parseContents(String content, Boolean throwOnError) {
    try {
      return decode(content);
    } catch (JsonException exception) {
      log.error(String.format("Exception: %s", exception), exception);
      // if (throwOnError) {
      //   throw new BadRequestException([],400, exception, "Cannot parse response data");
      // }
      //
      // return [];
    }
    return null;
  }

  /**
   * Decode API response JSON to ArrayList<>
   *
   * @param content
   * @return ArrayList<mixed, mixed>
   * @throws \JsonException
   */
  protected static HashMap<Object, Object> decode(String content) {
    try {
      TypeReference<HashMap<Object, Object>> typeRef = new TypeReference<HashMap<Object, Object>>() {
      };
      HashMap<Object, Object> mapping = new ObjectMapper().readValue(content, typeRef);
      return mapping;
    } catch (IOException e) {
      log.error(String.format("Exception: %s", e.getMessage()), e);
    }
    return null;
    // return json_decode(content, true, flags:JSON_THROW_ON_ERROR);
  }

  /**
   * Get API url for given version
   *
   * @param version
   * @return String
   */
  private URL resolveHostName(String version) {
    final API apiEnum = API.valueOf(version);
    final URL url = API.URL.get(apiEnum);
    return url != null ? url : API.URL.get(API.V2V1);
  }

  /**
   * Get response content (even gzipped)
   *
   * @param stream
   * @param gzip
   * @return String
   */
  // private String getContents(StreamInterface stream, Boolean gzip) {
  //   if (!gzip) {
  //     return stream.getContents();
  //   }
  //
  //   try {
  //     inflateStream = new InflateStream(stream);
  //
  //     return inflateStream.getContents();
  //   } catch (Throwable) {
  //     stream.rewind();
  //
  //     return stream.getContents();
  //   }
  // }

  /**
   * Validate response
   *
   * @param statusCode
   * @param response
   * @param shouldHaveStatus
   * @throws \Inspirum\Balikobot\Contracts\ExceptionInterface
   */
  @SneakyThrows
  private void validateResponse(int statusCode, HashMap<Object, Object> response, Boolean shouldHaveStatus) throws UnauthorizedException, cz.balikobot.api.exceptions.BadRequestException {
    this.validator.validateStatus(statusCode, response);

    this.validator.validateResponseStatus(response, null, shouldHaveStatus);
  }

  public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
    Map<String, Object> retMap = new HashMap<String, Object>();

    if (json != JSONObject.NULL) {
      retMap = toMap(json);
    }
    return retMap;
  }

  public static Map<String, Object> toMap(JSONObject object) throws JSONException {
    Map<String, Object> map = new HashMap<String, Object>();

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

  public static List<Object> toList(JSONArray array) throws JSONException {
    List<Object> list = new ArrayList<Object>();
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
package bibit.framework.api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

/**
 * API client for making HTTP requests to the Book API.
 *
 * @param baseUrl Base URL for the Book API
 */
public class ApiClient {

  private String baseUrl;

  public ApiClient(String baseUrl) {

    this.baseUrl = baseUrl;
  }

  /**
   * Send a GET request to the specified endpoint.
   *
   * @param endpoint Endpoint to request
   * @return Response from the Book API
   */
  public Response get(String endpoint) {

    return given().baseUri(baseUrl).when().get(endpoint);
  }

  /**
   * Send a POST request to the specified endpoint.
   *
   * @param endpoint Endpoint to request
   * @param body     Request body to send
   * @return Response from the Book API
   */
  public Response post(String endpoint, Object body) {

    return given()
        .baseUri(baseUrl)
        .contentType("application/json")
        .body(body)
        .when()
        .post(endpoint);
  }

  /**
   * Send a DELETE request to the specified endpoint.
   *
   * @param endpoint Endpoint to request
   * @return Response from the Book API
   */
  public Response delete(String endpoint) {

    return given().baseUri(baseUrl).contentType("application/json").when().delete(endpoint);
  }

  /**
   * Send a PUT request to the specified endpoint.
   *
   * @param endpoint Endpoint to request
   * @param body     Request body to send
   * @return Response from the Book API
   */
  public Response update(String endpoint, Object body) {

    return given().baseUri(baseUrl).contentType("application/json").body(body).when().put(endpoint);
  }
}

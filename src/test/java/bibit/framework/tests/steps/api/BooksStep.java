package bibit.framework.tests.steps.api;

import bibit.framework.api.ApiClient;
import bibit.framework.api.request.CreateBookRequest;
import bibit.framework.api.response.CreateBookGetResponse;
import bibit.framework.api.service.BookService;
import bibit.framework.config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import java.util.List;
import org.junit.Assert;

/** BooksStep class for API tests. */
/**
 * @param driver WebDriver instance
 */
public class BooksStep {

  private ApiClient apiClient;

  private CreateBookRequest request;

  private Response response;

  private BookService bookService;

  private CreateBookGetResponse createBookResponse;

  private List<CreateBookGetResponse> booksArr;

  /** BooksStep constructor. */
  /**
   * @param driver WebDriver instance
   */
  public BooksStep() {

    apiClient = new ApiClient(ConfigReader.get("api.baseUrl"));
    bookService = new BookService(apiClient);

    request = new CreateBookRequest();

    createBookResponse = new CreateBookGetResponse();
  }

  /** User create new book with title, body, and userId. */
  /**
   * @param title Book title
   * @param body Book body
   * @param userId User ID
   */
  @Given("user create new book with title {string} and body {string} and userId {string}")
  public void user_create_new_book(String title, String body, String userId) {
    request.setTitle(title);
    request.setBody(body);
    request.setUserId(userId);

    response = bookService.createBook(request);

    createBookResponse = response.as(CreateBookGetResponse.class);

    System.out.println("Testing get titile " + createBookResponse.getTitle());
  }

  /** Response status should be. */
  /**
   * @param statusCode Expected status code
   */
  @Then("response status should be {int}")
  public void response_status_should_be(int statusCode) {

    Assert.assertEquals(statusCode, response.getStatusCode());
  }

  /** Response should contain title, body, and userId. */
  /**
   * @param expectedTitle Expected title
   * @param expectedBody Expected body
   * @param expectedId Expected user ID
   */
  @Then("response should contain title {string} and body {string} and userId {string}")
  public void response_should_contain_title(
      String expectedTitle, String expectedBody, String expectedId) {

    String actualTitle = createBookResponse.getTitle();

    String actualBody = createBookResponse.getBody();

    String actualId = createBookResponse.getUserId();

    // Assert response body title
    Assert.assertEquals(expectedTitle, actualTitle);

    // Assert response body
    Assert.assertEquals(expectedBody, actualBody);

    // Assert response id
    Assert.assertEquals(expectedId, actualId);
  }

  /** Response should contain id. */
  /**
   * @param expectedId Expected id
   */
  @Then("response should id should not be null")
  public void response_should_id_should_not_be_null() {
    // Assert loop
    for (CreateBookGetResponse elem : booksArr) {
      Assert.assertNotNull(elem.getId());
    }
  }

  /** User get all books data. */
  /**
   * @param expectedId Expected id
   */
  @Given("user get all books data")
  public void user_get_all_books_data() {

    response = bookService.getBookAll();
    booksArr = response.as(new TypeRef<List<CreateBookGetResponse>>() {});
  }

  /** Response should contain id. */
  /**
   * @param expectedId Expected id
   */
  @Then("response success to delete id")
  public void response_success_to_delete_id() {}

  /** User delete id. */
  /**
   * @param id Book ID
   */
  @Given("user delete id {string}")
  public void user_delete_id(String id) {
    response = bookService.deleteBook(id);
  }

  /** User update id with title, body, and userId. */
  /**
   * @param id Book ID
   * @param title Book title
   * @param body Book body
   * @param userId User ID
   */
  @Given("user update id {string} title {string} and body {string} and userId {string}")
  public void user_update_title_and_body_and_id(
      String id, String title, String body, String userId) {
    request.setTitle(title);
    request.setBody(body);
    request.setUserId(userId);

    response = bookService.updateBook(request, id);
    createBookResponse = response.as(CreateBookGetResponse.class);
  }
}

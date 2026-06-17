package bibit.framework.tests.steps.api;


import java.util.List;

import org.junit.Assert;

import bibit.framework.api.ApiClient;
import bibit.framework.api.request.CreateBookRequest;
import bibit.framework.api.response.CreateBookGetResponse;
import bibit.framework.api.service.BookService;
import bibit.framework.config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;



public class BooksStep {


    private ApiClient apiClient;

    private CreateBookRequest request;

    private Response response;

    private BookService bookService;

    private CreateBookGetResponse createBookResponse;

    private List<CreateBookGetResponse> booksArr;

    public BooksStep(){


        apiClient =
            new ApiClient(
                ConfigReader.get("api.baseUrl")
            );
            bookService = new BookService(apiClient);

            request = new CreateBookRequest();

            createBookResponse = new CreateBookGetResponse();
        
    }





    @Given("user create new book with title {string} and body {string} and userId {string}")
    public void user_create_new_book(
            String title,
            String body,
            String userId
    ){
        request.setTitle(title);
        request.setBody(body);
        request.setUserId(userId);

        response =
           bookService.createBook(request);

           createBookResponse =
            response.as(
                CreateBookGetResponse.class
            );

            System.out.println("Testing get titile "+createBookResponse.getTitle());
   }





    @Then("response status should be {int}")
    public void response_status_should_be(
            int statusCode
    ){


        Assert.assertEquals(
            statusCode,
            response.getStatusCode()
        );

    }



    @Then("response should contain title {string} and body {string} and userId {string}")
    public void response_should_contain_title(
            String expectedTitle,
            String expectedBody,
            String expectedId
    ){


        String actualTitle =
            createBookResponse
                .getTitle();

        String actualBody =
            createBookResponse
                .getBody();

        String actualId =
            createBookResponse
                .getUserId();

        // Assert response body title
        Assert.assertEquals(
            expectedTitle,
            actualTitle
        );

        // Assert response body
        Assert.assertEquals(
            expectedBody,
            actualBody
        );

        // Assert response id
        Assert.assertEquals(
            expectedId,
            actualId
        );

    }

    @Then("response should id should not be null")
    public void response_should_id_should_not_be_null() {
        //Assert loop
        for (CreateBookGetResponse elem : booksArr) {
            Assert.assertNotNull(
                elem.getId()
            );
        }


    }

    @Given("user get all books data")
    public void user_get_all_books_data() {
        // Write code here that turns the phrase above into concrete actions

        response = bookService.getBookAll();
        booksArr = response.as(new TypeRef<List<CreateBookGetResponse>>() {});


   }

    @Then("response success to delete id")
    public void response_success_to_delete_id() {
        // Write code here that turns the phrase above into concrete actions
        
    }

    

    @Given("user delete id {string}")
    public void user_delete_id(String id) {
        // Write code here that turns the phrase above into concrete actions
        response = bookService.deleteBook(id);
    }

    @Given("user update id {string} title {string} and body {string} and userId {string}")
    public void user_update_title_and_body_and_id(String id, String title, String body, String userId) {
        // Write code here that turns the phrase above into concrete actions
        request.setTitle(title);
        request.setBody(body);
        request.setUserId(userId);

        response = bookService.updateBook(request, id);
            createBookResponse =
            response.as(
                CreateBookGetResponse.class
            );

    }

}



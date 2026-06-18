package bibit.framework.api.service;

import bibit.framework.api.ApiClient;
import bibit.framework.api.ApiEndpoint;
import bibit.framework.api.request.CreateBookRequest;
import io.qameta.allure.Allure;
import io.restassured.response.Response;

/**
 * * Service layer responsible for handling all Book API operations.
 * * * This class acts as an abstraction between Step Definitions and API
 * endpoints,
 * * allowing test scenarios to interact with book-related
 * services without directly calling RestAssured requests.
 * * * Supported operations:
 * * - Create
 * * - Get Book
 * * * - Update Book
 * * - Delete Book
 * * Author: Erik Enrico Chiesa
 */
public class BookService {

    private final ApiClient apiClient;

    public BookService(ApiClient apiClient) {

        this.apiClient = apiClient;
    }

    /**
     * * Create a new book.
     * * @param request Request payload containing book information
     * * @return API response after successful creation with book details
     * in the response body
     */
    public Response createBook(CreateBookRequest request) {

        Allure.addAttachment("Request", "text/plain", request.toString(), ".txt");

        Response res = apiClient.post(ApiEndpoint.BOOKS, request);

        Allure.addAttachment("Response", "text/plain", res.asPrettyString(), ".txt");

        return res;
    }

    /**
     * * Retrieve all book information
     * *@return API response containing all book details
     */
    public Response getBookAll() {
        Allure.addAttachment("Request", "text/plain", "", ".txt");

        Response res = apiClient.get(ApiEndpoint.BOOKS);

        Allure.addAttachment("Request", "text/plain", res.asPrettyString(), ".txt");

        return res;
    }

    /**
     * * Delete book by ID.
     * * @param bookId Unique identifier of the book
     * * @return API response after successful deletion
     */
    public Response deleteBook(String bookId) {

        Allure.addAttachment("Request", "text/plain", "", ".txt");

        Response res = apiClient.delete(ApiEndpoint.BOOKS + "/" + bookId);

        Allure.addAttachment("Request", "text/plain", res.asPrettyString(), ".txt");

        return res;
    }

    /**
     * * Update book information by ID.
     * * @param request Request payload containing book information
     * * @param bookId Unique identifier of the book
     * * @return API response after successful update with book details
     * in the response body
     */
    public Response updateBook(CreateBookRequest request, String bookId) {

        Allure.addAttachment("Request", "text/plain", request.toString(), ".txt");

        Response res = apiClient.update(ApiEndpoint.BOOKS + "/" + bookId, request);

        Allure.addAttachment("Request", "text/plain", res.asPrettyString(), ".txt");

        return res;
    }
}

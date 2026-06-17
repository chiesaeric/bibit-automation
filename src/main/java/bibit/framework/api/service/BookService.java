package bibit.framework.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import bibit.framework.api.ApiClient;
import bibit.framework.api.ApiEndpoint;
import bibit.framework.api.request.CreateBookRequest;
import io.qameta.allure.Allure;
import io.restassured.response.Response;

public class BookService {

    private final ApiClient apiClient;
    

    public BookService(
            ApiClient apiClient
    ) {

        this.apiClient = apiClient;

    }

    public Response createBook(
            CreateBookRequest request
    ) {

        Allure.addAttachment(
            "Request",
            "text/plain",
            request.toString(),
            ".txt"
        );

        Response res = apiClient.post(
            ApiEndpoint.BOOKS,
            request
        );

        Allure.addAttachment(
            "Response",
            "text/plain",
            res.asPrettyString(),
            ".txt"
        );

        return res;

    }

    public Response getBookAll(
    ) {
        Allure.addAttachment(
            "Request",
            "text/plain",
            "",
            ".txt"
        );

        Response res = apiClient.get(
            ApiEndpoint.BOOKS
        );

        Allure.addAttachment(
            "Request",
            "text/plain",
            res.asPrettyString()
,
            ".txt"
        );
        
        return res;
        

    }

    public Response deleteBook(
        String bookId
    ) {

        Allure.addAttachment(
            "Request",
            "text/plain",
            "",
            ".txt"
        );

        Response res = apiClient.delete(
            ApiEndpoint.BOOKS
            + "/"
            + bookId
        );

        Allure.addAttachment(
            "Request",
            "text/plain",
            res.asPrettyString()
,
            ".txt"
        );
        
        return res;

    }

    public Response updateBook(
        CreateBookRequest request,
        String bookId
    ) {

        Allure.addAttachment(
            "Request",
            "text/plain",
            request.toString(),
            ".txt"
        );

        Response res = apiClient.update(
            ApiEndpoint.BOOKS
            + "/"
            + bookId,
            request
    );

        Allure.addAttachment(
            "Request",
            "text/plain",
            res.asPrettyString()
,
            ".txt"
        );
        
        return res;

    }

}

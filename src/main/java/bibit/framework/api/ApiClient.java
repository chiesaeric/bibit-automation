package bibit.framework.api;


import static io.restassured.RestAssured.given;
import io.restassured.response.Response;



public class ApiClient {


    private String baseUrl;



    public ApiClient(
        String baseUrl
    ){

        this.baseUrl = baseUrl;

    }





    public Response get(
        String endpoint
    ){


        return given()

            .baseUri(baseUrl)

            .when()

            .get(endpoint);

    }


    public Response post(
        String endpoint,
        Object body
    ){


        return given()

            .baseUri(baseUrl)

            .contentType(
                "application/json"
            )

            .body(body)

            .when()

            .post(endpoint);

    }

    public Response delete(
        String endpoint
    ){


        return given()

            .baseUri(baseUrl)

            .contentType(
                "application/json"
            )

            .when()

            .delete(endpoint);

    }

    public Response update(
        String endpoint,
        Object body
    ){


        return given()

            .baseUri(baseUrl)

            .contentType(
                "application/json"
            )

            .body(body)

            .when()

            .put(endpoint);

    }


}
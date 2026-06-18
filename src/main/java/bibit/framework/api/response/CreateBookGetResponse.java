package bibit.framework.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * Response model for creating a book.
 * 
 * @param id     Unique identifier of the created book
 * @param title  Title of the book
 * @param body   Body of the book
 * @param userId User ID associated with the book
 */
public class CreateBookGetResponse {
    private String id;
    private String title;
    private String body;
    private String userId;
}

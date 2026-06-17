package bibit.framework.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBookGetResponse {
    private String id;
    private String title;
    private String body;
    private String userId;

}

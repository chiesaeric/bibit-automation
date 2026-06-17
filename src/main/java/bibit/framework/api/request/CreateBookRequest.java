package bibit.framework.api.request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBookRequest {
    private String id;
    private String title;
    private String body;
    private String userId;
}

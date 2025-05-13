package africa.semicolon.Todo_App.dtos.Response;

import africa.semicolon.Todo_App.Data.model.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaskResponse {
    private String message;
    private Long id;
    private Status status;
}

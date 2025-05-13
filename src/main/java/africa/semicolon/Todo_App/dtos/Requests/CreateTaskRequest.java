package africa.semicolon.Todo_App.dtos.Requests;

import africa.semicolon.Todo_App.Data.model.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaskRequest {
    private String title;
    private String description;
    private Status status;
}

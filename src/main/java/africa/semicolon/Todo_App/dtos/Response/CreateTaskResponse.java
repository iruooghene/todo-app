package africa.semicolon.Todo_App.dtos.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaskResponse {
    private String message;
    private Long id;
}

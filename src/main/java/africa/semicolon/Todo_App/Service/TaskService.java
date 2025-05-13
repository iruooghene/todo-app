package africa.semicolon.Todo_App.Service;

import africa.semicolon.Todo_App.Data.model.Tasks;
import africa.semicolon.Todo_App.dtos.Requests.CreateTaskRequest;
import africa.semicolon.Todo_App.dtos.Response.CreateTaskResponse;

import java.util.List;


public interface TaskService {
    CreateTaskResponse create(CreateTaskRequest request);
    List<Tasks> getAllTasks();
    Tasks deleteTask(Long id);

}

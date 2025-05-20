package africa.semicolon.Todo_App.Service;

import africa.semicolon.Todo_App.Data.Repositories.TasksRepository;
import africa.semicolon.Todo_App.Data.model.Tasks;
import africa.semicolon.Todo_App.dtos.Requests.CreateTaskRequest;
import africa.semicolon.Todo_App.dtos.Response.CreateTaskResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class  TaskServiceImplTest {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TasksRepository tasksRepository;


    @Test
    @DisplayName("test that tasks can be created successfully ")
    public void create() {
        CreateTaskRequest request = new CreateTaskRequest();
        request.setTitle("Title");
        request.setDescription("Description");
        CreateTaskResponse response = taskService.create(request);
        assertNotNull(response);
        assertTrue(response.getId() > 0);
        assertTrue(response.getMessage().contains("success"));

    }

    @Test
    @DisplayName("test to get all tasks")
    @Sql(scripts = {"/db/data.sql"})
    public void getAllTasks() {
        List<Tasks> tasks = taskService.getAllTasks();
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertThat(tasks).hasSize(2);

    }

    @Test
    @Sql(scripts = {"/db/data.sql"})
    void deleteTaskById() {
        taskService.deleteTask(201L);
        boolean exists = tasksRepository.existsById(201L);
        assertThat(exists).isFalse();


    }
}
package africa.semicolon.Todo_App.controller;

import africa.semicolon.Todo_App.Data.model.Tasks;
import africa.semicolon.Todo_App.Service.TaskService;
import africa.semicolon.Todo_App.dtos.Requests.CreateTaskRequest;
import africa.semicolon.Todo_App.dtos.Response.CreateTaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TaskController {

    @Autowired
    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody CreateTaskRequest request) {
        CreateTaskResponse createdTask = taskService.create(request);
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello, Kubernetes!");
    }



}

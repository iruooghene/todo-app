package africa.semicolon.Todo_App.Service;

import africa.semicolon.Todo_App.Data.Repositories.TasksRepository;
import africa.semicolon.Todo_App.Data.model.Status;
import africa.semicolon.Todo_App.Data.model.Tasks;
import africa.semicolon.Todo_App.dtos.Requests.CreateTaskRequest;
import africa.semicolon.Todo_App.dtos.Response.CreateTaskResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    private final TasksRepository tasksRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskServiceImpl(TasksRepository tasksRepository, ModelMapper modelMapper) {
        this.tasksRepository = tasksRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CreateTaskResponse create(CreateTaskRequest request) {
        Tasks task = modelMapper.map(request, Tasks.class);
        task.setStatuses(new HashSet<>());
        var status = task.getStatuses();
        status.add(Status.IN_PROGRESS);
        tasksRepository.save(task);
        var response = modelMapper.map(task, CreateTaskResponse.class);
        response.setMessage("Task created successfully");
        return response;
    }

    @Override
    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    @Override
    public Tasks deleteTask(Long id) {
        if (tasksRepository.existsById(id)){
            tasksRepository.deleteById(id);
        }else {
            throw new RuntimeException("Task not found");
        }


        return null;
    }

}

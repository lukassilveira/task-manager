package lukas.cerusteste.resource;

import lukas.cerusteste.model.Task;
import lukas.cerusteste.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/task")
public class TaskResource {
    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> listAllTasks() {
        List<Task> tasks = taskService.listAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task taskToBeAdded) {
        Task newTask = taskService.addTask(taskToBeAdded);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody Task taskToBeUpdated) {
        System.out.println(taskToBeUpdated.toString());
        Optional<Task> task = taskService.getById(taskToBeUpdated.getId());
        Task _task = task.get();
        _task.setDone(taskToBeUpdated.getDone());
        _task.setName(taskToBeUpdated.getName());
        _task.setDescription(taskToBeUpdated.getDescription());
        taskService.updateTask(_task);
        return new ResponseEntity<>(_task, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{taskToBeDeletedId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskToBeDeletedId) {
        taskService.deleteTask(taskToBeDeletedId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

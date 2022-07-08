package lukas.cerusteste.service;

import lukas.cerusteste.model.Task;
import lukas.cerusteste.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> listAllTasks(){
        return taskRepository.findAll();
    }

    public Task getByName(String taskName){
        return taskRepository.findByName(taskName);
    }

    public Optional<Task> getById(Long taskId){ return taskRepository.findById(taskId); }

    public Task addTask(Task taskToBeAdded) {
        treatDateAndDone(taskToBeAdded);
        return taskRepository.save(taskToBeAdded);
    }

    private void treatDateAndDone(Task taskToBeAdded) {
        if (taskToBeAdded.getCreationDate() == null) taskToBeAdded.setCreationDate(LocalDateTime.now());
        if (taskToBeAdded.isDone() == null) taskToBeAdded.setDone("0");
    }

    public Task updateTask(Task taskToBeUpdated) {
        return taskRepository.save(taskToBeUpdated);
    }

    public void deleteTask(Long taskToBeDeletedId) {
        taskRepository.deleteTaskById(taskToBeDeletedId);
    }
}

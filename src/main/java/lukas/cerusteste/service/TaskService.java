package lukas.cerusteste.service;

import lukas.cerusteste.model.Task;
import lukas.cerusteste.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
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

    public Task addTask(Task taskToBeAdded) {
        return taskRepository.save(taskToBeAdded);
    }

    public Task updateTask(Task taskToBeUpdated) {
        return taskRepository.save(taskToBeUpdated);
    }

    public void deleteTask(Long taskToBeDeletedId) {
        taskRepository.deleteTaskById(taskToBeDeletedId);
    }
}

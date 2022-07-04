package lukas.cerusteste.repository;

import lukas.cerusteste.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    void deleteTaskById(Long taskToBeDeletedId);
}

package africa.semicolon.Todo_App.Data.Repositories;

import africa.semicolon.Todo_App.Data.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Tasks, Long> {
}

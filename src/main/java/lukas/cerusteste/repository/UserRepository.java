package lukas.cerusteste.repository;

import lukas.cerusteste.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

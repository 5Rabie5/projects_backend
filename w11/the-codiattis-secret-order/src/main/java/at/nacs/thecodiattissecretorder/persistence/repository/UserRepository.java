package at.nacs.thecodiattissecretorder.persistence.repository;

import at.nacs.thecodiattissecretorder.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findOneByUsername(String username);
  boolean existsByUsername(String username);
}

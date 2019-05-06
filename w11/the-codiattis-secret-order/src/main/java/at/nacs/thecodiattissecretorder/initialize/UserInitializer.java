package at.nacs.thecodiattissecretorder.initialize;

import at.nacs.thecodiattissecretorder.logic.Maneger;
import at.nacs.thecodiattissecretorder.persistence.model.User;
import at.nacs.thecodiattissecretorder.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class UserInitializer {

  @Bean
  ApplicationRunner initializeUser(PasswordEncoder encoder, UserRepository repository) {
    return args -> {
      User user = createUser(encoder);
      if (repository.existsByUsername(user.getUsername())) {
        return;
      }
      repository.save(user);
    };
  }

  private User createUser(PasswordEncoder encoder) {
    return User.builder()
               .username("chief")
               .password(encoder.encode("chief"))
               .authorities(Set.of("ROLE_ADMIN"))
               .build();
  }

}

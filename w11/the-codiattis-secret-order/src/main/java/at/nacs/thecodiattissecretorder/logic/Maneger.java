package at.nacs.thecodiattissecretorder.logic;

import at.nacs.thecodiattissecretorder.persistence.model.User;
import at.nacs.thecodiattissecretorder.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class Maneger {

  private final UserRepository userRepository;
  private final PasswordEncoder encoder;

  public User createUser(String name, String password) {
    return User.builder()
               .username(name)
               .password(encoder.encode(password))
               .authorities(Set.of("ROLE_USER"))
               .build();
  }

  //@RolesAllowed("ROLE_ADMIN")
  public void save(User user) {
    userRepository.save(user);

  }

  public List<User> getAll() {
    return userRepository.findAll();
  }


}

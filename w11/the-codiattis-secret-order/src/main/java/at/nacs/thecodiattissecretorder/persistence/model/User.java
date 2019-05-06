package at.nacs.thecodiattissecretorder.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String username;

  private String password;

  @Builder.Default
  @ElementCollection(fetch = EAGER)
  private  Set<String> authorities = new HashSet<>();

}

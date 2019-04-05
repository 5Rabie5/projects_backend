package at.nacs.socialnetwork.persistence.repository;

import at.nacs.socialnetwork.persistence.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findAllByFriendsNotNull();
    List<Person> findAllByFriendsNull();
}

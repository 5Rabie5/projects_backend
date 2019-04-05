package at.nacs.socialnetwork.logic;

import at.nacs.socialnetwork.persistence.domain.Person;
import at.nacs.socialnetwork.persistence.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonManager {

    private final PersonRepository personRepository;

    public Person store(Person person) {
        personRepository.save(person);
        return person;
    }

    public List<Person> displayAll() {
        return personRepository.findAll();
    }
    public List<Person> displayAllHaveFriends() {
        return personRepository.findAllByFriendsNotNull();
    }
    public List<Person> displayAllHaveNoFriends() {
        return personRepository.findAllByFriendsNull();
    }
    public void friend(Long id1,Long id2) {
        Person person1 = personRepository.getOne(id1);
        Person person2 = personRepository.getOne(id2);
        person1.getFriends().add(person2);
        person2.getFriends().add(person1);
         personRepository.save(person1);
         personRepository.save(person2);
    }
    public void unFriend(Long id1,Long id2) {
        Person person1 = personRepository.getOne(id1);
        Person person2 = personRepository.getOne(id2);
        person1.getFriends().remove(person2);
        person2.getFriends().remove(person1);
        personRepository.save(person1);
        personRepository.save(person2);
    }
}

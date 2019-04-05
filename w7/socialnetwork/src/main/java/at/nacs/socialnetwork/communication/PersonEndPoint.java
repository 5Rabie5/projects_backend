package at.nacs.socialnetwork.communication;

import at.nacs.socialnetwork.logic.PersonManager;
import at.nacs.socialnetwork.persistence.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonEndPoint {

    private final PersonManager personManager;

    @PostMapping
    Person store(@RequestBody Person person) {
        personManager.store(person);
        return person;
    }

    @GetMapping
    List<Person> displayAll() {
        return personManager.displayAll();
    }

    @GetMapping("/friends/with")
    List<Person> displayAllHaveFriends() {
        return personManager.displayAllHaveFriends();
    }

    @GetMapping("/friends/without")
    List<Person> displayAllHaveNoFriends() {
        return personManager.displayAllHaveNoFriends();
    }

    @PutMapping("/{id1}/friend/{id2}")
    void friend(@PathVariable Long id1, @PathVariable Long id2) {
        personManager.friend(id1, id2);
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    void unfriend(@PathVariable Long id1, @PathVariable Long id2) {
        personManager.unFriend(id1, id2);
    }
}

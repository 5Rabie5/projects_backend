package at.nacs.socialnetwork.communication;

import at.nacs.socialnetwork.logic.PersonManager;
import at.nacs.socialnetwork.persistence.domain.Person;
import at.nacs.socialnetwork.persistence.repository.PersonRepository;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("dataset")
class PersonEndPointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @SpyBean
    PersonManager personManager;
    @MockBean
    PersonRepository personRepository;
    @Setter
    @Getter
    List<Person> persons;
    private String url = "/persons";

    @Test
    void store() {

        restTemplate.postForObject(url, persons.get(0), Person.class);
        verify(personManager).store(persons.get(0));
    }

    @Test
    void displayAll() {

        restTemplate.getForObject(url, Person[].class);
        verify(personManager).displayAll();
    }

    @Test
    void displayAllHaveFriends() {

        url = url + "/friends/with";
        restTemplate.getForObject(url, Person[].class);
        verify(personManager).displayAllHaveFriends();

    }

    @Test
    void displayAllHaveNoFriends() {

        url = url + "/friends/without";
        restTemplate.getForObject(url, Person[].class);
        verify(personManager).displayAllHaveNoFriends();
    }

    @Test
    void friend() {

        Long id1 = 1L;
        Long id2 = 2L;

        url = url + "/" + id1 + "/friend/" + id2;
        restTemplate.put(url, Person.class);
        verify(personManager).friend(id1, id2);

    }

    @Test
    void unfriend() {

        Long id1 = 1L;
        Long id2 = 2L;

        url = url + "/" + id1 + "/unfriend/" + id2;
        restTemplate.put(url, Person.class);
        verify(personManager).unFriend(id1, id2);
    }
}
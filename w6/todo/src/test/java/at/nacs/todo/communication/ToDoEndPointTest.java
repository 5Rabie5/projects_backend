package at.nacs.todo.communication;

import at.nacs.todo.logic.ToDoManager;
import at.nacs.todo.persistence.repository.ToDoRepository;
import at.nacs.todo.persistence.domain.ToDo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ToDoEndPointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @SpyBean
    ToDoManager toDoManager;
    @MockBean
    ToDoRepository toDoRepository;

    @Test
    void get() {
        restTemplate.getForObject("/todos", ToDo[].class);
        verify(toDoManager).get();
    }

    @Test
    void get1() {
        restTemplate.getForObject("/todos/uyt6tuy", ToDo.class);
        verify(toDoManager).getById(anyString());
    }

    @Test
    void post() {
        ToDo toDo= ToDo.builder().title("dance").build();
        restTemplate.postForObject("/todos",toDo, ToDo.class);
        verify(toDoManager).save(toDo);
    }

    @Test
    void put() {
        ToDo toDo= ToDo.builder().title("dance").build();
        restTemplate.put("/todos/uyt6tuy/done", toDo,ToDo.class);
        verify(toDoManager).put(anyString());
    }

    @Test
    void delete() {
        restTemplate.getForObject("/todos/uyt6tuy/done", ToDo.class);
        verify(toDoManager).put(anyString());
    }
}
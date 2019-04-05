package at.nacs.todo.logic;

import at.nacs.todo.persistence.domain.ToDo;
import at.nacs.todo.persistence.repository.ToDoRepository;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@ConfigurationProperties("dataset")
@SpringBootTest(webEnvironment = NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager toDoManager;

    @Autowired
    ToDoRepository toDoRepository;

    @Setter
    List<ToDo> todos;

    @BeforeEach
    void before() {
        toDoRepository.deleteAll();
        toDoRepository.saveAll(todos);
    }

    @Test
    void canStoreNewToDoTest() {
        ToDo toDo1 = ToDo.builder().title("dance").build();
        ToDo resulte = toDoManager.save(toDo1);
        assertThat(resulte.getTitle()).isEqualTo("dance");
        assertThat(resulte.isDone()).isFalse();
        assertThat(resulte.getId()).isNotEmpty();
    }

    @Test
    void canDisplayAllExistingToDosTest() {
        assertThat(toDoRepository.count()).isEqualTo(3);
    }

    @Test
    void markToDoAsDoneTest() {
        String id = toDoManager.get().get(0).getId();
        toDoManager.put(id);
        assertThat(toDoManager.getById(id).isDone()).isTrue();
    }

    @Test
    void deleteToDo() {
        String id = toDoManager.get().get(0).getId();
        toDoManager.delete(id);
        assertThat(toDoManager.getById(id)).isNull();
    }
}

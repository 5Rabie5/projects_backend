package at.nacs.todo.persistence.repository;

import at.nacs.todo.persistence.domain.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {

}

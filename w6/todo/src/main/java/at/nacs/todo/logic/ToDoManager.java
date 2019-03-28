package at.nacs.todo.logic;

import at.nacs.todo.persistence.domain.ToDo;
import at.nacs.todo.persistence.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoManager {

    private final ToDoRepository toDoRepository;

    public List<ToDo> get() {
        return toDoRepository.findAll();
    }

    public ToDo getById(String id) {
        if (toDoRepository.findById(id).isPresent()) {
            return toDoRepository.findById(id).get();
        }
        return null;
    }

    public ToDo save(ToDo toDo) {
        toDoRepository.save(toDo);
        return toDo;
    }

    public ToDo put(String id) {

        if (toDoRepository.findById(id).isPresent()) {
            ToDo toDo = toDoRepository.findById(id).get();
            toDo.setDone(true);
            toDoRepository.save(toDo);
            return toDo;
        }
        return null;
    }

    public void delete(String id) {
        if (toDoRepository.findById(id).isPresent()) {
            toDoRepository.deleteById(id);
        }
    }

    public void deleteAll() {

        toDoRepository.deleteAll();
    }


}

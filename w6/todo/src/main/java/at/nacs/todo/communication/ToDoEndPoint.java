package at.nacs.todo.communication;

import at.nacs.todo.logic.ToDoManager;
import at.nacs.todo.persistence.domain.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ToDoEndPoint {
    private final ToDoManager toDoManager;

    @GetMapping("/todos")
    public List<ToDo> get() {
        return toDoManager.get();
    }

    @GetMapping("/todos/{id}")
    public ToDo get(@PathVariable String id) {
        return toDoManager.getById(id);
    }

    @PostMapping("/todos")
    public ToDo post(@RequestBody ToDo toDo) {
        toDoManager.save(toDo);
        return toDo;
    }

    @PutMapping("/todos/{id}/done")
    public ToDo put(@PathVariable String id) {

        return toDoManager.put(id);
    }

    @DeleteMapping("/todos/{id}")
    public void delete(@PathVariable String id) {
        toDoManager.delete(id);
    }
}

package pl.codeleak.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public Collection<Todo> getAll() {
        return todoRepository.findAll();
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public Todo getOne(@PathVariable int id) {
        return todoRepository.findById(id);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void getOne(@PathVariable int id, @RequestBody @Valid Todo todo) {
        todoRepository.update(id, todo);
    }

    @RequestMapping(value = "/todo", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid Todo todo) {
        todoRepository.addTodo(todo);
    }
}

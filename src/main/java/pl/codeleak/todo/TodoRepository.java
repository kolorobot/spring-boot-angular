package pl.codeleak.todo;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

@Component
public class TodoRepository {

    static SortedMap<Integer, Todo> todos;

    static {
        SortedMap<Integer, Todo> _todos = new TreeMap<>();
        _todos.put(1, new Todo(1, "Get the milk"));
        _todos.put(2, new Todo(2, "Bring kids to school"));
        todos = Collections.synchronizedSortedMap(_todos);
    }

    Collection<Todo> findAll() {
        return todos.values();
    }

    Todo findById(int id) {
        if (todos.containsKey(id)) {
            return todos.get(id);
        }
        throw new IllegalArgumentException("Todo not found");
    }

    int addTodo(Todo todo) {
        if (todos.isEmpty()) {
            return 1;
        }
        int id = todos.lastKey() + 1;
        Todo _todo = new Todo(id, todo.title);
        todos.put(id, _todo);
        return id;
    }

    void update(int id, Todo todo) {
        Todo _todo = findById(id);
        _todo.done = todo.done;
        _todo.title = todo.title;
    }
}

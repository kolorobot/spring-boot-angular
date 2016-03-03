package pl.codeleak.todo;

import org.hibernate.validator.constraints.NotBlank;

public class Todo {

    public Integer id;

    @NotBlank
    public String title;

    public boolean done;

    public Todo(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Todo() {
    }
}

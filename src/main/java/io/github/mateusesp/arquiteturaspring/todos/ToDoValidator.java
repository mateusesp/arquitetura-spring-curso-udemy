package io.github.mateusesp.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class ToDoValidator {

    private final ToDoRepository repository;

    public ToDoValidator(ToDoRepository repository) {
        this.repository = repository;
    }

    public void validateToDoDescription(ToDoEntity toDo) {
        if (existsToDoDescription(toDo.getDescricao())) {
            throw new IllegalArgumentException("Already exists a TODO with this description: " + toDo.getDescricao());
        }
    }

    private boolean existsToDoDescription(String description) {
        return repository.existsByDescricao(description);
    }
}

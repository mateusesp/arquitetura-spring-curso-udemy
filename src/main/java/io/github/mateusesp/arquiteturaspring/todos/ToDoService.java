package io.github.mateusesp.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private final ToDoRepository repository;

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public ToDoEntity save(ToDoEntity newToDo) {
        return repository.save(newToDo);
    }

    public void updateStatus(ToDoEntity toDo) {
        repository.save(toDo);
    }

    public ToDoEntity getById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}

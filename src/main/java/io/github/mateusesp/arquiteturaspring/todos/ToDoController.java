package io.github.mateusesp.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/todos")
public class ToDoController {

    private final ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @PostMapping
    public ToDoEntity save(@RequestBody ToDoEntity toDo) {
        try {
            return service.save(toDo);
        } catch (IllegalArgumentException e) {
            var errorMessage = e.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }

    }

    @PutMapping("{id}")
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody ToDoEntity toDo) {

        toDo.setId(id);
        service.updateStatus(toDo);
    }

    @GetMapping("{id}")
    public ToDoEntity getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }
}

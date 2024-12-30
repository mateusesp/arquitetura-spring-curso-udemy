package io.github.mateusesp.arquiteturaspring.todos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todos")
public class ToDoController {

    private final ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @PostMapping
    public ToDoEntity save(@RequestBody ToDoEntity toDo) {
        return service.save(toDo);
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

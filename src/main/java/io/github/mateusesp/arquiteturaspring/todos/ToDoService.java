package io.github.mateusesp.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private final ToDoRepository repository;
    private final ToDoValidator validator;
    private final MailSender mailSender;

    public ToDoService(ToDoRepository repository, ToDoValidator validator, MailSender mailSender) {
        this.repository = repository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public ToDoEntity save(ToDoEntity newToDo) {
        validator.validateToDoDescription(newToDo);
        return repository.save(newToDo);
    }

    public void updateStatus(ToDoEntity toDo) {
        repository.save(toDo);
        String status = toDo.getConcluido() ? "Done" : "Not Completed";
        mailSender.send("ToDo " + toDo.getDescricao() + "has been updated to: " + status);
    }

    public ToDoEntity getById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}

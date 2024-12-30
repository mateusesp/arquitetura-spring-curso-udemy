package io.github.mateusesp.arquiteturaspring.todos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Integer> {

    boolean existsByDescricao(String descricao);
}

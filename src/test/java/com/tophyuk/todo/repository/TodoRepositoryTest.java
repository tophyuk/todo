package com.tophyuk.todo.repository;

import com.tophyuk.todo.domain.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void create() {
        Todo todo = new Todo();
        todo.setContents("밥먹기");
        todo.setComplete(Boolean.TRUE);
        todo.setModifiedDate(LocalDate.now());
        this.todoRepository.save(todo);
    }

}

package com.tophyuk.todo.repository;

import com.tophyuk.todo.domain.Todo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void create() {
        //given
        Todo todo = new Todo();
        todo.setContents("밥먹기");
        todo.setComplete(Boolean.TRUE);
        todo.setModifiedDate(LocalDate.now());

        //when
        Todo saveTodo = this.todoRepository.save(todo);

        //then
        Assertions.assertThat(saveTodo.getContents()).isEqualTo(todo.getContents());
    }

    @Test
    void delete() {
        //given
        Long id = Long.valueOf(2);
        Todo findId = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

        //when
        todoRepository.delete(findId);

        //then
        assertThatThrownBy(() -> todoRepository.findById(id)).isInstanceOf(IllegalArgumentException.class);

    }

}

package com.tophyuk.todo.repository;

import com.tophyuk.todo.domain.Todo;
import com.tophyuk.todo.service.TodoService;
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

    @Autowired
    private TodoService todoService;

    @Test
    void create() {
        //given
        Todo todo = new Todo();
        todo.setContents("밥먹기");
        todo.setComplete(Boolean.TRUE);
        todo.setModifiedDate(LocalDate.now());

        //when
        Todo saveTodo = this.todoService.create(todo.getContents());

        //then
        Assertions.assertThat(saveTodo.getContents()).isEqualTo(todo.getContents());
    }

    @Test
    void delete() {
        //given
        Long id = Long.valueOf(50);

        //when
        todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        todoService.delete(id);

        //then
        assertThatThrownBy(() -> todoRepository.findById(id)).isNotInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void update() {
        //given
        Long id = Long.valueOf(47);
        String contents = "샤워하기3";
        Boolean complete = Boolean.TRUE;
        Todo updateParam = new Todo(id, contents, true);

        //when
        Todo beforeTodo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        todoService.update(id, updateParam);
        Todo afterTodo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

        //then
        Assertions.assertThat(beforeTodo.getContents()).isNotEqualTo(afterTodo.getContents());
    }

}

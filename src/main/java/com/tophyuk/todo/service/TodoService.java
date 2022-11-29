package com.tophyuk.todo.service;

import com.tophyuk.todo.domain.Todo;
import com.tophyuk.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getList() {
        return todoRepository.findAll();
    }

    public void create(String content){
        Todo todo = new Todo();
        todo.setContents(content);
        todo.setComplete(false);
        todo.setModifiedDate(LocalDate.now());
        todoRepository.save(todo);
    }
}

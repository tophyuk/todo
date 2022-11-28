package com.tophyuk.todo.service;

import com.tophyuk.todo.domain.Todo;
import com.tophyuk.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getList() {
        return todoRepository.findAll();
    }
}

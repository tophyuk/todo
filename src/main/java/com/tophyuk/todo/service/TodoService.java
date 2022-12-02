package com.tophyuk.todo.service;

import com.tophyuk.todo.domain.Todo;
import com.tophyuk.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getList() {
        return todoRepository.findAll();
    }

    public Todo getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 할 일이 없습니다. id=" + id));
        return todo;
    }

    public Todo create(String content){
        Todo todo = new Todo();
        todo.setContents(content);
        todo.setComplete(false);
        todo.setModifiedDate(LocalDate.now());
        todoRepository.save(todo);
        return todo;
    }

    @Transactional
    public void delete(Long id) {
        Todo findTodo = todoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 할 일이 없습니다. id=" + id));
        todoRepository.delete(findTodo);
    }

    @Transactional
    public void update(Long id, Todo updateParam) {
        Todo findTodo = todoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 할 일이 없습니다. id=" + id));

        findTodo.setContents(updateParam.getContents());
        findTodo.setComplete(updateParam.getComplete());

        todoRepository.save(findTodo);
    }
}

package com.tophyuk.todo.web;

import com.tophyuk.todo.domain.Todo;
import com.tophyuk.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public String home(Model model) {
        List<Todo> resultList = todoService.getList();
        model.addAttribute("resultList", resultList);
        return "index";
    }

    @PostMapping
    public String create(@RequestParam String content) {
        todoService.create(content);
        return "redirect:/todo";
    }
}

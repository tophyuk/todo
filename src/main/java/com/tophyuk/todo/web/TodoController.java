package com.tophyuk.todo.web;

import com.tophyuk.todo.domain.Todo;
import com.tophyuk.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @RequestMapping("/")
    public String home (Model model){
        List<Todo> resultList = todoService.getList();
        model.addAttribute("resultList", resultList);
        return "index";
    }
}

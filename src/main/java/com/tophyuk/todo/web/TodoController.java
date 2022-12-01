package com.tophyuk.todo.web;

import com.tophyuk.todo.domain.Todo;
import com.tophyuk.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @RequestMapping("/")
    public String root(){
        return "redirect:/todo";
    }

    @RequestMapping("/todo")
    public String home(Model model) {
        List<Todo> resultList = todoService.getList();
        model.addAttribute("resultList", resultList);
        return "index";
    }


    @PostMapping("/todo")
    public String create(@RequestParam String content) {
        todoService.create(content);
        return "redirect:/todo";
    }

    @DeleteMapping("/todo/delete/{id}")
    public String delete(@PathVariable Long id) {
        log.info("id={}", id);
        todoService.delete(id);
        return "redirect:/todo";
    }

}

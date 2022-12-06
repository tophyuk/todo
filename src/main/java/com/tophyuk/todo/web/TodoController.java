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

    //주석 추가
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

    @DeleteMapping("/todo/{id}")
    public String delete(@PathVariable Long id) {
        log.info("id={}", id);
        todoService.delete(id);
        return "redirect:/todo";
    }

    @GetMapping("/todo/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        log.info("id={}", id);

        Todo todo = todoService.getTodo(id);
        model.addAttribute("todo", todo);
        return "/form/updateForm";
    }

    @PostMapping("/todo/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Todo todo) {
        log.info("todo ={}", todo);
        todoService.update(id, todo);
        return "redirect:/todo";
    }

}

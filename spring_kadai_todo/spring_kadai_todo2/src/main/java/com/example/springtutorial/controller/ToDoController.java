package com.example.springtutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {
    private final com.example.springtutorial.service.ToDoService service;

    public ToDoController(com.example.springtutorial.service.ToDoService service) {
        this.service = service;
    }

    @GetMapping("/todo")
    public String showToDoList(Model model) {
        model.addAttribute("todoList", service.findAll());
        return "todoView";
    }
}

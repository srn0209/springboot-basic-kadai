package com.example.springtutorial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springtutorial.entity.ToDo;
import com.example.springtutorial.repositoty.ToDoRepository;

@Service
public class ToDoService {
    private final ToDoRepository repository;

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public List<ToDo> findAll() {
        return repository.findAll();
    }
}

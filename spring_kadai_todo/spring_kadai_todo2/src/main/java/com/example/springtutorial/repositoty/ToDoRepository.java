package com.example.springtutorial.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<com.example.springtutorial.entity.ToDo, Integer> {
}

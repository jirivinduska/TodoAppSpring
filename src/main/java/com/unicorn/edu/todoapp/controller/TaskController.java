package com.unicorn.edu.todoapp.controller;

import com.unicorn.edu.todoapp.repository.entity.Task;
import com.unicorn.edu.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public void addTask (@RequestBody Task task, Model model) {
        System.out.println("saving user: "+task);
        taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks () {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById (@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById (@PathVariable Long id) {
        taskService.deleteById(id);
    }
}


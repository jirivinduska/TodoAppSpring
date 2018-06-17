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
        System.out.println("saving task: "+task);
        taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks () {
        return taskService.getAllTasks();
    }

    @GetMapping("/filter/completed")
    public List<Task> getCompletedTasks () {
        return taskService.getCompletedTasks();
    }

    @GetMapping("/filter/uncompleted")
    public List<Task> getUncompletedTasks () {
        return taskService.getUncompletedTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById (@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/complete/{id}")
    public Task completeTaskById (@PathVariable Long id) {
        return taskService.completeTaskById(id);
    }

    @GetMapping("/{id}/{name}")
    public Task editTaskById (@PathVariable Long id,@PathVariable String name) {
       return taskService.editTaskById(id,name);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById (@PathVariable Long id) {
        taskService.deleteById(id);
    }
}


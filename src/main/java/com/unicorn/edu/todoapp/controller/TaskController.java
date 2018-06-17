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

    @PostMapping("/tasks")
    public void addTask (@RequestBody Task task, Model model) {
        taskService.addTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks () {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/filter/completed")
    public List<Task> getCompletedTasks () {
        return taskService.getCompletedTasks();
    }

    @GetMapping("/tasks/filter/uncompleted")
    public List<Task> getUncompletedTasks () {
        return taskService.getUncompletedTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById (@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/tasks/complete/{id}")
    public Task completeTaskById (@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (!task.getStatus())
            return taskService.completeTaskById(id);
        else
            return taskService.uncompleteTaskById(id);
    }

    @PostMapping("/tasks/{id}/{name}")
    public Task editTaskById (@PathVariable Long id,@PathVariable String name) {
       return taskService.editTaskById(id,name);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTaskById (@PathVariable Long id) {
        taskService.deleteById(id);
    }
}


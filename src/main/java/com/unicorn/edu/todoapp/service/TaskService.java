package com.unicorn.edu.todoapp.service;

import com.unicorn.edu.todoapp.repository.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

    Task addTask(Task task);

    List getAllTasks();

    Task getTaskById(Long id);

    void deleteById(Long id);
}

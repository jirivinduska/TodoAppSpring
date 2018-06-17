package com.unicorn.edu.todoapp.service;

import com.unicorn.edu.todoapp.repository.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

    Task addTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task completeTaskById(Long id);

    Task uncompleteTaskById(Long id);

    Task editTaskById(Long id, String name);

    List<Task> getCompletedTasks();

    List<Task> getUncompletedTasks();

    void deleteById(Long id);


}

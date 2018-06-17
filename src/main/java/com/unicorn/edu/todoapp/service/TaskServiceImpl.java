package com.unicorn.edu.todoapp.service;

import com.unicorn.edu.todoapp.repository.TaskRepository;
import com.unicorn.edu.todoapp.repository.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        if (taskRepository.findById(id).isPresent()) {
            return taskRepository.findById(id).get();
        } else {
            return notSuchTask(id);
        }
    }

    @Override
    public List<Task> getCompletedTasks() {
        return taskRepository.findAllByStatus(false);
    }

    @Override
    public List<Task> getUncompletedTasks() {
        return taskRepository.findAllByStatus(true);
    }

    @Override
    public Task completeTaskById(Long id) {
        if (taskRepository.findById(id).isPresent()) {
            Task task = taskRepository.findById(id).get();
            task.setStatus(true);
            taskRepository.save(task);
            return taskRepository.findById(id).get();
        }
        else
           return notSuchTask(id);
    }

    @Override
    public Task uncompleteTaskById(Long id) {
        if (taskRepository.findById(id).isPresent()) {
            Task task = taskRepository.findById(id).get();
            task.setStatus(false);
            taskRepository.save(task);
            return taskRepository.findById(id).get();
        }
        else
            return notSuchTask(id);
    }

    @Override
    public Task editTaskById(Long id,String name) {
        if (taskRepository.findById(id).isPresent()) {
            Task task = taskRepository.findById(id).get();
            task.setName(name);
            taskRepository.save(task);
            return taskRepository.findById(id).get();
        }
        else
            return notSuchTask(id);
    }



    @Override
    public void deleteById(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        }
    }

    private Task notSuchTask(Long id){
        Task task = new Task();
        task.setName("Task s id " + id.toString() + " neexistuje!");
        return task;
    }
}

package com.unicorn.edu.todoapp.repository;

import com.unicorn.edu.todoapp.repository.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}

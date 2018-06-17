package com.unicorn.edu.todoapp.repository;

import com.unicorn.edu.todoapp.repository.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    boolean existsById(Long id);
    List<Task> findAllByStatus(boolean status);
}

package com.github.todoapp.repository;

import com.github.todoapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findByName(String name);

    List<Task> findAllByUsername(String username);
}

package com.github.todoapp.controller;

import com.github.todoapp.entity.Task;
import com.github.todoapp.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@Slf4j
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping(path = "/")
    public String hom

    //POST
    @PostMapping("/user/addTask")
    public Task addTask(@RequestBody Task task) {
        log.info("Task object {}", task.toString());
        return taskService.saveTask(task);
    }

    @PostMapping("/user/addTasks")
    public List<Task> addTasks(@RequestBody List<Task> tasks) {
        return taskService.saveTasks(tasks);
    }

    //GET
    @GetMapping("/user/tasks")
    public List<Task> getAllTasks() {
        return taskService.getTasks();
    }
    @GetMapping("/taskById/{id}")
    public Task findTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }
    @GetMapping("/taskByName/{name}")
    public Task findTaskByName(@PathVariable String name) {
        return taskService.getTaskByName(name);
    }
    @GetMapping("/listTasByUsername/{username}")
    public List<Task> findTasksByUsername(@PathVariable String username) {
            return taskService.getTasksForUser(username);
    }

    //PUT
    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task)
    {
        System.out.println("UPDATED");
        return taskService.updateTask(task);
    }


    //DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        return taskService.deleteTask(id);
    }
}

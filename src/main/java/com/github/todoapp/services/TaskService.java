package com.github.todoapp.services;

import com.github.todoapp.entity.Task;
import com.github.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    //POST
    public Task saveTask(Task task) {
        System.out.println(task.toString());
        return taskRepository.save(task);
    }

    //Optional
    public List<Task> saveTasks(List<Task> tasks) {
        return taskRepository.saveAll(tasks);
    }

    //GET
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElse(null);
    }
    public Task getTaskByName(String name) {
        return taskRepository.findByName(name);
    }
    public List<Task> getTasksForUser(String username) {
        return taskRepository.findAllByUsername(username);
    }

    //PUT
    public Task updateTask(Task task) {
        System.out.println("updates");
        Task existing_task = taskRepository.findById(task.getId()).orElse(null);
        existing_task.setName(task.getName());
        existing_task.setDetail(task.getDetail());
        existing_task.setCompleted(task.getCompleted());
        return taskRepository.save(existing_task);
    }

    //DELETE
    public String deleteTask(int id) {
        taskRepository.deleteById(id);
        return id + " id -> task removed";
    }
}

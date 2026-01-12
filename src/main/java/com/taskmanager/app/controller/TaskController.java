package com.taskmanager.app.controller;

import com.taskmanager.app.entity.Task;
import com.taskmanager.app.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Create task for a project
    @PostMapping("/project/{projectId}")
    public Task createTask(
            @PathVariable UUID projectId,
            @RequestBody Task task) {
        return taskService.createTask(projectId, task);
    }

    // Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Get task by id
    @GetMapping("/{id}")
    public Task getTask(@PathVariable UUID id) {
        return taskService.getTaskById(id);
    }

    // Delete task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
    }
}

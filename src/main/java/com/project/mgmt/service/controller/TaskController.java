package com.project.mgmt.service.controller;

import com.project.mgmt.service.domain.Task;
import com.project.mgmt.service.dto.TaskRequest;
import com.project.mgmt.service.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/tasks")
    public Task save(@RequestBody TaskRequest task) {
        return taskService.save(task).get();
    }

    @PutMapping("/tasks")
    public Task update(@RequestBody TaskRequest task) {
        return taskService.save(task).get();
    }
}


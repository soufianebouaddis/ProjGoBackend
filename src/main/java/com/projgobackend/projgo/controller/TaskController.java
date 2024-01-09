package com.projgobackend.projgo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projgobackend.projgo.dto.TaskDto;
import com.projgobackend.projgo.entity.Task;
import com.projgobackend.projgo.entity.enums.TaskStatus;
import com.projgobackend.projgo.mapper.TaskMapper;
import com.projgobackend.projgo.service.TaskImpl;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/task/")
@CrossOrigin
public class TaskController {
    private TaskImpl taskService;
    private TaskMapper taskMapper;

    public TaskController(TaskImpl taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping("addtask")
    public ResponseEntity<Task> saveTask(@RequestBody @Valid TaskDto taskDto) {
        Task task = taskMapper.mapFromEntity(taskDto);
        task.setStatus(TaskStatus.CREATED);
        taskDto = taskMapper.mapToEntity(task);
        return ResponseEntity.ok().body(taskService.saveTask(taskDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return ResponseEntity.ok().body(taskService.fetchOne(id));
    }

    @PutMapping("updatetask/{id}")
    public ResponseEntity<Optional<Task>> updateTask(@PathVariable Long id, @RequestBody @Valid TaskDto taskDto) {
        return ResponseEntity.ok().body(taskService.updateTask(id, taskDto));
    }

    @GetMapping("tasks")
    public ResponseEntity<List<Task>> fetchAllTasks() {
        return ResponseEntity.ok().body(taskService.fetchAllTasks());
    }

}
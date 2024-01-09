package com.projgobackend.projgo.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.projgobackend.projgo.dto.TaskDto;
import com.projgobackend.projgo.entity.Task;

public interface TaskInterface {
    public Task saveTask(TaskDto taskDto);

    public List<Task> fetchAllTasks();

    public Task fetchOne(Long id);

    public Optional<Task> updateTask(Long id, TaskDto TaskDto);
}
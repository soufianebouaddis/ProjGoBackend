package com.projgobackend.projgo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projgobackend.projgo.dto.TaskDto;
import com.projgobackend.projgo.entity.Task;
import com.projgobackend.projgo.exception.CustomNotFoundException;
import com.projgobackend.projgo.mapper.TaskMapper;
import com.projgobackend.projgo.repository.TaskRepository;
import com.projgobackend.projgo.service.interfaces.TaskInterface;

@Service
public class TaskImpl implements TaskInterface {
    private TaskMapper taskMapper;
    private TaskRepository taskRepository;

    public TaskImpl(TaskMapper taskMapper, TaskRepository taskRepository) {
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }

    @Override
    public Task saveTask(TaskDto taskDto) {
        Task task = taskMapper.mapFromEntity(taskDto);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> fetchAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task fetchOne(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("Task not Found with ID : " + id));
    }

    @Override
    public Optional<Task> updateTask(Long id, TaskDto taskDto) {
        return taskRepository.findById(id).map((newTask) -> {
            Task.builder()
                    .name(taskDto.getName())
                    .status(taskDto.getStatus())
                    .description(taskDto.getDescription())
                    .date(taskDto.getDate())
                    .startTime(taskDto.getStartTime())
                    .endTime(taskDto.getEndTime())
                    .taskCategory(taskDto.getTaskCategory())
                    .build();
            return taskRepository.save(newTask);
        });

    }

}
package com.projgobackend.projgo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.projgobackend.projgo.dto.TaskDto;
import com.projgobackend.projgo.entity.Task;
import com.projgobackend.projgo.mapper.MapperInterface.MapperInterface;

@Component
public class TaskMapper implements MapperInterface<Task, TaskDto> {
    private ModelMapper modelMapper;

    public TaskMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TaskDto mapToEntity(Task o) {
        return modelMapper.map(o, TaskDto.class);
    }

    @Override
    public Task mapFromEntity(TaskDto o) {
        return modelMapper.map(o, Task.class);
    }

}
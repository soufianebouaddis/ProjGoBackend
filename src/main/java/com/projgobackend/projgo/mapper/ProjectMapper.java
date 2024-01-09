package com.projgobackend.projgo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.projgobackend.projgo.dto.ProjectDto;
import com.projgobackend.projgo.entity.Project;
import com.projgobackend.projgo.mapper.MapperInterface.MapperInterface;

@Component
public class ProjectMapper implements MapperInterface<Project, ProjectDto> {
    private ModelMapper modelMapper;

    public ProjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto mapToEntity(Project o) {
        return modelMapper.map(o, ProjectDto.class);
    }

    @Override
    public Project mapFromEntity(ProjectDto o) {
        return modelMapper.map(o, Project.class);
    }

}
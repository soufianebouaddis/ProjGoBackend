package com.projgobackend.projgo.service.interfaces;

import java.util.List;

import com.projgobackend.projgo.dto.ProjectDto;
import com.projgobackend.projgo.entity.Project;

public interface ProjectInterface {
    public Project saveProject(ProjectDto projectDto);

    public List<Project> fetchAllProjects();
}
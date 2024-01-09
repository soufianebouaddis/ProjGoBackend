package com.projgobackend.projgo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projgobackend.projgo.dto.ProjectDto;
import com.projgobackend.projgo.entity.Project;
import com.projgobackend.projgo.entity.Task;
import com.projgobackend.projgo.entity.Response.AffectTaskToProjectResponse;
import com.projgobackend.projgo.mapper.ProjectMapper;
import com.projgobackend.projgo.mapper.TaskMapper;
import com.projgobackend.projgo.repository.ProjectRepository;
import com.projgobackend.projgo.repository.TaskRepository;
import com.projgobackend.projgo.service.interfaces.ProjectInterface;

@Service
public class ProjectImpl implements ProjectInterface {
    private ProjectRepository projectRepository;
    private ProjectMapper projectMapper;
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public ProjectImpl(ProjectRepository projectRepository, ProjectMapper projectMapper, TaskRepository taskRepository,
            TaskMapper taskMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public Project saveProject(ProjectDto projectDto) {
        Project project = projectMapper.mapFromEntity(projectDto);
        return projectRepository.save(project);
    }

    @Override
    public List<Project> fetchAllProjects() {
        return projectRepository.findAll();
    }

    public AffectTaskToProjectResponse affectTaskToProject(Long idproject, Long idTask) {
        Project project = projectRepository.findById(idproject).get();
        Task task = taskRepository.findById(idTask).get();
        if (task != null && project != null) {
            project.getTaskList().add(task);
            projectRepository.save(project);
            return new AffectTaskToProjectResponse(projectMapper.mapToEntity(project), taskMapper.mapToEntity(task));
        }
        return new AffectTaskToProjectResponse();
    }
    public Project getProjectFromTask(Long id){
        return projectRepository.findByTaskList_Id(id);
    }
}
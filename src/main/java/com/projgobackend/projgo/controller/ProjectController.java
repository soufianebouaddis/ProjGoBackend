package com.projgobackend.projgo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projgobackend.projgo.dto.ProjectDto;
import com.projgobackend.projgo.entity.Project;
import com.projgobackend.projgo.entity.Response.AffectTaskToProjectResponse;
import com.projgobackend.projgo.service.ProjectImpl;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/project/")
@CrossOrigin
public class ProjectController {
    private ProjectImpl projectService;

    public ProjectController(ProjectImpl projectService) {
        this.projectService = projectService;
    }

    @PostMapping("addproject")
    public ResponseEntity<Project> saveProject(@RequestBody @Valid ProjectDto project) {
        return ResponseEntity.ok().body(projectService.saveProject(project));
    }

    @GetMapping("projects")
    public ResponseEntity<List<Project>> fetchAllProjects() {
        return ResponseEntity.ok().body(projectService.fetchAllProjects());
    }

    @PostMapping("affect/{idproject}/{idtask}")
    public ResponseEntity<AffectTaskToProjectResponse> affectTaskToProject(@PathVariable Long idproject,
            @PathVariable Long idtask) {
        return ResponseEntity.ok().body(projectService.affectTaskToProject(idproject, idtask));
    }
    @GetMapping("{id}")
    public ResponseEntity<Project> getProjectFromTask(@PathVariable Long id){
        return ResponseEntity.ok().body(projectService.getProjectFromTask(id));
    }
}
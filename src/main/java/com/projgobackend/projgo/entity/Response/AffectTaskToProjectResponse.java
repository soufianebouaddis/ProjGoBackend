package com.projgobackend.projgo.entity.Response;

import com.projgobackend.projgo.dto.ProjectDto;
import com.projgobackend.projgo.dto.TaskDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AffectTaskToProjectResponse {
    private ProjectDto project;
    private TaskDto task;
}
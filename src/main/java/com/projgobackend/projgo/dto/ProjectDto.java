package com.projgobackend.projgo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectDto {
    @NotNull(message = "Title cannot be null")
    private String title;
    @NotNull(message = "Image cannot be null")
    private String image;
}
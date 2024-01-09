package com.projgobackend.projgo.dto;

import java.time.Instant;
import java.time.LocalDate;

import com.projgobackend.projgo.entity.enums.TaskCategory;
import com.projgobackend.projgo.entity.enums.TaskStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskDto {
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "TaskCategory cannot be null")
    @Enumerated(EnumType.STRING)
    private TaskCategory taskCategory;
    @NotNull(message = "TaskStatus cannot be null")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @NotNull(message = "Date cannot be null")
    private LocalDate date;
    @NotNull(message = "startTime cannot be null")
    private Instant startTime;
    @NotNull(message = "endTime cannot be null")
    private Instant endTime;
    @NotNull(message = "Description cannot be null")
    private String description;
}
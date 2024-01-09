package com.projgobackend.projgo.entity;

import java.time.*;
import com.projgobackend.projgo.entity.enums.TaskCategory;
import com.projgobackend.projgo.entity.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private TaskCategory taskCategory;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private String description;
}
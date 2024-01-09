package com.projgobackend.projgo.entity.Response;

import com.projgobackend.projgo.dto.TaskDto;
import com.projgobackend.projgo.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AffectResponse {
    private UserDto user;
    private TaskDto task;
}
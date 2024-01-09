package com.projgobackend.projgo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projgobackend.projgo.dto.UserDto;
import com.projgobackend.projgo.entity.Task;
import com.projgobackend.projgo.entity.User;
import com.projgobackend.projgo.entity.Response.AffectResponse;
import com.projgobackend.projgo.exception.CustomNotFoundException;
import com.projgobackend.projgo.mapper.TaskMapper;
import com.projgobackend.projgo.mapper.UserMapper;
import com.projgobackend.projgo.repository.TaskRepository;
import com.projgobackend.projgo.repository.UserRepository;
import com.projgobackend.projgo.service.interfaces.UserInterface;

@Service
public class UserImpl implements UserInterface {
    private UserMapper userMapper;
    private UserRepository userRepository;
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public UserImpl(UserMapper userMapper, UserRepository userRepository, TaskRepository taskRepository,
            TaskMapper taskMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public User saveUser(UserDto userDto) {
        User user = userMapper.mapFromEntity(userDto);
        return userRepository.save(user);
    }

    @Override
    public User fetchOneUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("User not Found with ID : " + id));
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    public AffectResponse affecTaskToUser(Long idUser, Long idTask) {
        User user = userRepository.findById(idUser).get();
        Task task = taskRepository.findById(idTask).get();
        if (user != null && task != null) {
            user.getTaskList().add(task);
            userRepository.save(user);
            return new AffectResponse(userMapper.mapToEntity(user), taskMapper.mapToEntity(task));
        }
        return new AffectResponse();
    }
}
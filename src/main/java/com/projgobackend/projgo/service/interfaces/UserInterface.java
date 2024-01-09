package com.projgobackend.projgo.service.interfaces;

import java.util.List;

import com.projgobackend.projgo.dto.UserDto;
import com.projgobackend.projgo.entity.User;

public interface UserInterface {
    public User saveUser(UserDto userDto);

    public User fetchOneUser(Long id);

    public List<User> fetchAllUsers();
}
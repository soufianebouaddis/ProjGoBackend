package com.projgobackend.projgo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.projgobackend.projgo.dto.UserDto;
import com.projgobackend.projgo.entity.User;
import com.projgobackend.projgo.mapper.MapperInterface.MapperInterface;

@Component
public class UserMapper implements MapperInterface<User, UserDto> {
    private ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto mapToEntity(User o) {
        return modelMapper.map(o, UserDto.class);
    }

    @Override
    public User mapFromEntity(UserDto o) {
        return modelMapper.map(o, User.class);
    }

}
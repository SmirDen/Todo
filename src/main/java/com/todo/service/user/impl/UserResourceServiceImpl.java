package com.todo.service.user.impl;

import com.todo.dto.user.UserRequestDto;
import com.todo.dto.user.UserResponseDto;
import com.todo.entity.User;
import com.todo.mapper.UserMapper;
import com.todo.repository.UserRepository;
import com.todo.service.user.UserResourceService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserResourceServiceImpl implements UserResourceService {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Override
    public List<UserResponseDto> findAll() {
        return userMapper.userToUserResponseDto(userRepository.findAll().list());
    }

    @Override
    public UserResponseDto findById(Long id) {
        return userMapper.userToUserResponseDto(userRepository.findById(id));
    }

    @Override
    public void addUser(UserRequestDto user) {
        userRepository.persist(userMapper.userRequestDtoToUser(user));
    }

    @Override
    public void updateUser(UserRequestDto user, Long id) {
        User userFind = userRepository.findById(id);

        userFind.setPassword(user.getPassword());
        userFind.setEmail(user.getEmail());
        userFind.setUsername(user.getUsername());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
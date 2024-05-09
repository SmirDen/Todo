package com.todo.service;

import com.todo.dto.user.UserRequestDto;
import com.todo.dto.user.UserResponseDto;
import com.todo.entity.User;
import com.todo.mapper.UserMapper;
import com.todo.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    public List<UserResponseDto> findAll() {
        return userMapper.userToUserResponseDto(userRepository.findAll().list());
    }

    public UserResponseDto findById(Long id) {
        return userMapper.userToUserResponseDto(userRepository.findById(id));
    }

    @Transactional
    public void addUser(UserRequestDto user) {
        userRepository.persist(userMapper.userRequestDtoToUser(user));
    }

    @Transactional
    public void updateUser(UserRequestDto user, Long id) {
        User userFind = userRepository.findById(id);

        userFind.setPassword(user.getPassword());
        userFind.setEmail(user.getEmail());
        userFind.setUsername(user.getUsername());
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
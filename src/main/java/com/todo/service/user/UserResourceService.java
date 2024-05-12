package com.todo.service.user;

import com.todo.dto.user.UserRequestDto;
import com.todo.dto.user.UserResponseDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserResourceService {
    List<UserResponseDto> findAll();
    UserResponseDto findById(Long id);
    @Transactional
    void addUser(UserRequestDto user);
    @Transactional
    void updateUser(UserRequestDto user, Long id);
    @Transactional
    void deleteUser(Long id);
}

package com.todo.service.user;

import com.todo.dto.user.UserRequestDto;
import com.todo.dto.user.UserResponseDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserResourceService {
    List<UserResponseDto> findAll();
    UserResponseDto findById(Long id);
    void addUser(UserRequestDto user);
    void updateUser(UserRequestDto user, Long id);
    void deleteUser(Long id);
}

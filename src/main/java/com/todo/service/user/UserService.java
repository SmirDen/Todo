package com.todo.service.user;

import com.todo.entity.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    @Transactional
    void addUser(User user);
    @Transactional
    void updateUser(User user, Long id);
    @Transactional
    void deleteUser(Long id);
}

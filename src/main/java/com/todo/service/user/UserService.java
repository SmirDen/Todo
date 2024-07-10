package com.todo.service.user;

import com.todo.entity.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void addUser(User user);
    void updateUser(User user, Long id);
    void deleteUser(Long id);
}

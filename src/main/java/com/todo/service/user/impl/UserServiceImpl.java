package com.todo.service.user.impl;

import com.todo.entity.User;
import com.todo.repository.UserRepository;
import com.todo.service.user.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {
    @Inject
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll().list();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void addUser(User user) {
        userRepository.persist(user);
    }

    @Override
    public void updateUser(User user, Long id) {
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

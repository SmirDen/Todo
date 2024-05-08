package com.todo.service;

import com.todo.entity.User;
import com.todo.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll().list();
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void addUser(User user) {
        userRepository.persist(user);
    }

    @Transactional
    public void updateUser(User user, Long id) {
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
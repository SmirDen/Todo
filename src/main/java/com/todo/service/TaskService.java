package com.todo.service;

import com.todo.entity.Task;
import com.todo.repository.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TaskService {

    @Inject
    TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll().list();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id);
    }

    @Transactional
    public void addTask(Task task) {
        taskRepository.persist(task);
    }

    @Transactional
    public void updateTask(Task task, Long id) {
        Task taskFind = taskRepository.findById(id);

        taskFind.setTaskName(task.getTaskName());
        taskFind.setTaskDescription(task.getTaskDescription());
        taskFind.setDeadline(task.getDeadline());
        taskFind.setStatus(task.getStatus());
    }

    @Transactional
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

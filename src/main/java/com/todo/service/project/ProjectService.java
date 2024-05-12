package com.todo.service.project;

import com.todo.entity.Project;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project findById(Long id);
    @Transactional
    void addProject(Project project);
    @Transactional
    void updateProject(Project project, Long id);
    @Transactional
    void deleteProject(Long id);
}

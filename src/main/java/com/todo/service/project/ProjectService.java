package com.todo.service.project;

import com.todo.entity.Project;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project findById(Long id);
    void addProject(Project project);
    void updateProject(Project project, Long id);
    void deleteProject(Long id);
}

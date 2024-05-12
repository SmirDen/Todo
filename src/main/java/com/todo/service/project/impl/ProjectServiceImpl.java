package com.todo.service.project.impl;

import com.todo.entity.Project;
import com.todo.repository.ProjectRepository;
import com.todo.service.project.ProjectService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProjectServiceImpl implements ProjectService {

    @Inject
    ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll().list();
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public void addProject(Project project) {
        projectRepository.persist(project);
    }

    @Override
    public void updateProject(Project project, Long id) {
        Project projectFind = projectRepository.findById(id);
        projectFind.setProjectName(project.getProjectName());
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}

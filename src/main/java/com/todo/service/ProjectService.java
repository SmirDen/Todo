package com.todo.service;

import com.todo.entity.Project;
import com.todo.repository.ProjectRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProjectService {

    @Inject
    ProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAll().list();
    }

    public Project findById(Long id) {
        return projectRepository.findById(id);
    }

    public void addProject(Project project) {
        projectRepository.persist(project);
    }

    public void updateProject(Project project, Long id) {
        Project projectFind = projectRepository.findById(id);

        projectFind.setProjectName(project.getProjectName());
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}


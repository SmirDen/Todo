package com.todo.service;

import com.todo.entity.Project;
import com.todo.repository.ProjectRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

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

    @Transactional
    public void addProject(Project project) {
        projectRepository.persist(project);
    }

    @Transactional
    public void updateProject(Project project, Long id) {
        Project projectFind = projectRepository.findById(id);

        projectFind.setProjectName(project.getProjectName());
    }

    @Transactional
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}


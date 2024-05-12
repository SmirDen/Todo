package com.todo.service.project.impl;

import com.todo.dto.project.ProjectRequestDto;
import com.todo.dto.project.ProjectResponseDto;
import com.todo.entity.Project;
import com.todo.mapper.ProjectMapper;
import com.todo.repository.ProjectRepository;
import com.todo.service.project.ProjectResourceService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProjectResourceServiceImpl implements ProjectResourceService {

    @Inject
    ProjectRepository projectRepository;

    @Inject
    ProjectMapper projectMapper;

    @Override
    public List<ProjectResponseDto> findAll() {
        return projectMapper.projectToProjectResponseDto(projectRepository.findAll().list());
    }

    @Override
    public ProjectResponseDto findById(Long id) {
        return projectMapper.projectToProjectResponseDto(projectRepository.findById(id));
    }

    @Override
    public void addProject(ProjectRequestDto project) {
        projectRepository.persist(projectMapper.projectRequestDtoToProject(project));
    }

    @Override
    public void updateProject(ProjectRequestDto project, Long id) {
        Project projectFind = projectRepository.findById(id);
        projectFind.setProjectName(project.getProjectName());
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}


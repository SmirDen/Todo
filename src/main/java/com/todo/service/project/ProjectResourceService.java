package com.todo.service.project;

import com.todo.dto.project.ProjectRequestDto;
import com.todo.dto.project.ProjectResponseDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ProjectResourceService {
    List<ProjectResponseDto> findAll();
    ProjectResponseDto findById(Long id);
    @Transactional
    void addProject(ProjectRequestDto project);
    @Transactional
    void updateProject(ProjectRequestDto project, Long id);
    @Transactional
    void deleteProject(Long id);
}

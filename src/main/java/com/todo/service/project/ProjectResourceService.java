package com.todo.service.project;

import com.todo.dto.project.ProjectRequestDto;
import com.todo.dto.project.ProjectResponseDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ProjectResourceService {
    List<ProjectResponseDto> findAll();
    ProjectResponseDto findById(Long id);
    void addProject(ProjectRequestDto project);
    void updateProject(ProjectRequestDto project, Long id);
    void deleteProject(Long id);
}

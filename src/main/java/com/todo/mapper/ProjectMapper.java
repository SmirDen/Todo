package com.todo.mapper;

import com.todo.dto.project.ProjectRequestDto;
import com.todo.dto.project.ProjectResponseDto;
import com.todo.entity.Project;
import com.todo.mapper.reference.UserReferenceMapper;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "jakarta",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {UserReferenceMapper.class, UserMapper.class}
)
public interface ProjectMapper {

    @Named("projectToProjectResponseDtoMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "id", target = "id")
    @Mapping(source = "projectName", target = "projectName")
    @Mapping(source = "user", target = "user", qualifiedByName = "userToUserResponseDtoMapper")
    ProjectResponseDto projectToProjectResponseDto(Project project);

    @Named("projectListToProjectResponseDtoListMapper")
    @BeanMapping(ignoreByDefault = true)
    List<ProjectResponseDto> projectToProjectResponseDto(List<Project> projectList);

    @Named("projectRequestDtoToProjectMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "projectName", target = "projectName")
    @Mapping(source = "user", target = "user")
    Project projectRequestDtoToProject(ProjectRequestDto projectRequestDto);
}
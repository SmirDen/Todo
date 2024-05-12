package com.todo.dto.project;

import com.todo.dto.user.UserResponseDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@NoArgsConstructor
@Schema(name = "ProjectResponseDto", description = "Project information")
public class ProjectResponseDto {

    private Long id;
    private UserResponseDto user;
    private String projectName;
}

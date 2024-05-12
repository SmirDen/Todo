package com.todo.dto.project;

import com.todo.dto.user.UserReferenceDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@NoArgsConstructor
@Schema(name = "ProjectRequestDto", description = "Information for creating/updating a project")
public class ProjectRequestDto {

    private UserReferenceDto user;
    private String projectName;
}

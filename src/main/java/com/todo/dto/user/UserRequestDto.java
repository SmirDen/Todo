package com.todo.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@NoArgsConstructor
@Schema(name = "UserRequestDto", description = "Information for creating/updating a user")
public class UserRequestDto {

    private String username;
    private String password;
    private String email;
}

package com.todo.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@NoArgsConstructor
@Schema(name = "UserResponseDto", description = "User information")
public class UserResponseDto {

    private Long id;
    private String username;
    private String password;
    private String email;
}

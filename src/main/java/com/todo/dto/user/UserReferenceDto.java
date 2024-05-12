package com.todo.dto.user;

import com.todo.dto.base.BaseReferenceDto;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@Schema(description = "Information for creating references")
public class UserReferenceDto extends BaseReferenceDto {
}

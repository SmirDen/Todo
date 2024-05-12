package com.todo.dto.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseReferenceDto {
    private Long id;
    private String referenceName;
}

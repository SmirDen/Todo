package com.todo.mapper.reference;

import com.todo.dto.user.UserReferenceDto;
import com.todo.dto.user.UserResponseDto;
import com.todo.entity.User;
import com.todo.mapper.UserMapper;
import com.todo.service.user.UserService;
import jakarta.inject.Inject;
import org.mapstruct.*;


@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class UserReferenceMapper {

    @Inject
    UserService userService;

    @Inject
    UserMapper userMapper;

    @Named("userReferenceDtoToUserResponseDtoMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    UserResponseDto userReferenceDtoToUserResponseDto(UserReferenceDto userReferenceDto) {
        return userMapper.userToUserResponseDto(userService.findById(userReferenceDto.getId()));
    }

    @Named("userReferenceDtoToUserMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User userReferenceDtoToUser(UserReferenceDto userReferenceDto) {
        return userService.findById(userReferenceDto.getId());
    }
}

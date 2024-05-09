package com.todo.mapper;

import com.todo.dto.user.UserRequestDto;
import com.todo.dto.user.UserResponseDto;
import com.todo.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Named("userToUserResponseDtoMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    UserResponseDto userToUserResponseDto(User user);

    @Named("userListToUserResponseDtoListMapper")
    @BeanMapping(ignoreByDefault = true)
    List<UserResponseDto> userToUserResponseDto(List<User> userList);

    @Named("userRequestDtoToUserMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User userRequestDtoToUser(UserRequestDto userRequestDto);
}

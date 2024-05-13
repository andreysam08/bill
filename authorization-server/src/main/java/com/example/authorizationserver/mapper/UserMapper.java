package com.example.authorizationserver.mapper;

import com.example.authorizationserver.dto.UserDto;
import com.example.authorizationserver.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User map(UserDto userDto);
    List<UserDto> map (List<User> users);

    UserDto map(User user);
}

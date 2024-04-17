package ru.example.demo.mapper;

import org.mapstruct.Mapper;
import ru.example.demo.entity.User;
import ru.example.demo.dto.UserDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User map(UserDto userDto);
    List<UserDto> map (List<User> users);
}

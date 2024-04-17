package ru.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.demo.entity.User;
import ru.example.demo.service.UserService;
import ru.example.demo.dto.UserDto;
import ru.example.demo.mapper.UserMapper;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserDto> getUsers() {
        List<User> allUsers = userService.getAllUsers();
        return userMapper.map(allUsers);
    }
}

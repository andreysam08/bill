package com.example.authorizationserver.controller;

import com.example.authorizationserver.dto.UserDto;
import com.example.authorizationserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping
    @RequestMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public UserDto findUser(@PathVariable UUID userId) {
        return userService.findUser(userId);
    }
}

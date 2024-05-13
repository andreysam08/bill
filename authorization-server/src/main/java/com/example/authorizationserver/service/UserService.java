package com.example.authorizationserver.service;

import com.example.authorizationserver.dto.UserDto;
import com.example.authorizationserver.mapper.UserMapper;
import com.example.authorizationserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.example.authorizationserver.entity.User> findUser = userRepository.findByUsername(username);
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return findUser.map(user -> User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .passwordEncoder(encoder::encode)
                .roles(user.getRole())
                .build()).orElseThrow();
    }

    public List<UserDto> getAllUsers() {
        return userMapper.map(userRepository.findAll());
    }

    public UserDto findUser(UUID userId) {
        return userMapper.map(userRepository.findById(userId).orElseThrow());
    }
}

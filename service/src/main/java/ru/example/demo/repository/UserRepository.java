package ru.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.demo.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}

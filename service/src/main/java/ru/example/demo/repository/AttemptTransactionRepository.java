package ru.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.demo.entity.AttemptTransaction;

import java.util.UUID;

public interface AttemptTransactionRepository extends JpaRepository<AttemptTransaction, UUID> {
}

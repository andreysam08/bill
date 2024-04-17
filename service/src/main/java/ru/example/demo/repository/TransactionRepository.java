package ru.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.demo.entity.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    public List<Transaction> findByCreationDateBetween(LocalDateTime startTime, LocalDateTime endTime);
}

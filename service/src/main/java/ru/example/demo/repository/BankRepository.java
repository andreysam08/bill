package ru.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.demo.entity.Bank;

import java.util.UUID;

public interface BankRepository extends JpaRepository<Bank, UUID> {
}

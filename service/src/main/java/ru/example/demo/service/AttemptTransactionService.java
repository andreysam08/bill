package ru.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.example.demo.entity.AttemptTransaction;
import ru.example.demo.repository.AttemptTransactionRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttemptTransactionService {
    private final AttemptTransactionRepository attemptTransactionRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public AttemptTransaction saveAttemptTransaction(AttemptTransaction attemptTransaction) {
        return attemptTransactionRepository.save(attemptTransaction);
    }

    @Transactional(readOnly = true)
    public AttemptTransaction findById(UUID id) {
        return attemptTransactionRepository.findById(id).orElseThrow();
    }
}

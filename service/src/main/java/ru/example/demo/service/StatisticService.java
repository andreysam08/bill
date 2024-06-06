package ru.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.demo.dto.StatisticDto;
import ru.example.demo.entity.Transaction;
import ru.example.demo.entity.enums.TransactionType;
import ru.example.demo.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final TransactionRepository transactionRepository;
    public StatisticDto getStatistics(LocalDateTime startTime) {
        LocalDateTime endTime = LocalDateTime.now();
        List<Transaction> transactions = transactionRepository.findByCreationDateAfter(startTime);
        return StatisticDto.builder()
                .startTime(startTime)
                .endTime(endTime)
                .enrollment(transactions.stream()
                        .filter(it -> it.getType().equals(TransactionType.CREDIT))
                        .map(Transaction::getAmount)
                        .reduce(BigDecimal::add).orElse(BigDecimal.valueOf(0)))
                .withdrawal(transactions.stream()
                        .filter(it -> it.getType().equals(TransactionType.WITHDRAWAL))
                        .map(Transaction::getAmount)
                        .reduce(BigDecimal::add).orElse(BigDecimal.valueOf(0)))
                .build();
    }
}

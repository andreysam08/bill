package ru.example.demo.scheduling;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.example.demo.entity.Transaction;
import ru.example.demo.entity.enums.TransactionType;
import ru.example.demo.feign.StatisticDto;
import ru.example.demo.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class Scheduler {
    private final TransactionRepository transactionRepository;
    private final RestTemplate restTemplate;

    @Scheduled(fixedDelay = 30, timeUnit = TimeUnit.SECONDS)
    public void sendStatistics() {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minus(30, ChronoUnit.SECONDS);
        List<Transaction> transactions = transactionRepository.findByCreationDateBetween(startTime, endTime);
        StatisticDto statisticDto = StatisticDto.builder()
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
        restTemplate.exchange("/statistics", HttpMethod.POST, new HttpEntity<>(statisticDto), Object.class);

    }
}

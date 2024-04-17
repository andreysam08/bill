package ru.example.demo.dto;

import ru.example.demo.entity.enums.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionDtoRequest(UUID accountId,
                                    TransactionType type,
                                    BigDecimal amount) {
}

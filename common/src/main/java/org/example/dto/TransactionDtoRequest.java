package org.example.dto;

import org.example.enums.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionDtoRequest(UUID accountId,
                                    TransactionType type,
                                    BigDecimal amount) {
}

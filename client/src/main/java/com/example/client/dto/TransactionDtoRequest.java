package com.example.client.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionDtoRequest(UUID accountId,
                                    TransactionType type,
                                    BigDecimal amount) {
}

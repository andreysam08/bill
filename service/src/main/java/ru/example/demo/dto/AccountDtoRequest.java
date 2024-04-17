package ru.example.demo.dto;

import java.math.BigDecimal;
import java.util.UUID;


public record AccountDtoRequest(BigDecimal balance,
                                UUID bankId,
                                UUID userId) {
}

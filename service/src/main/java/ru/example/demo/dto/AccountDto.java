package ru.example.demo.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private UUID id;
    BigDecimal balance;
    BankDto bankDto;
}

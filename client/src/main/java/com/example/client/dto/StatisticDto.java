package com.example.client.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class StatisticDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal enrollment;
    private BigDecimal withdrawal;
}

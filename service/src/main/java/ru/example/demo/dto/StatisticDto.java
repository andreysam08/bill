package ru.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StatisticDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal enrollment;
    private BigDecimal withdrawal;
}

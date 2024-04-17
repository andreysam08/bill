package ru.example.demo.feign;

import lombok.*;

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

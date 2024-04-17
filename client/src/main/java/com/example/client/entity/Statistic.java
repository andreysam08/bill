package com.example.client.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Statistic extends BaseEntity{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal enrollment;
    private BigDecimal withdrawal;
}

package com.example.client.repository;

import com.example.client.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatisticRepository extends JpaRepository<Statistic, UUID> {
}

package com.example.client.scheduling;

import com.example.client.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.example.dto.StatisticDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class Scheduler {
    private final WebClient webClient;
    @Value("${statistic-service.url}")
    private String statisticUrl;
    private final StatisticService statisticService;

    @Scheduled(fixedDelay = 30, timeUnit = TimeUnit.SECONDS)
    public void sendStatistics() {
        StatisticDto forEntity = webClient.get()
                .uri(statisticUrl + "/statistics", uriBuilder -> uriBuilder.queryParam("startTime", LocalDateTime.now().minusMinutes(5).toString())
                        .build())
                .retrieve()
                .bodyToMono(StatisticDto.class)
                .block();
        statisticService.saveStatistic(forEntity);
    }
}

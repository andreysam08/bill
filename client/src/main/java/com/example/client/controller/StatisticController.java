package com.example.client.controller;

import com.example.client.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.example.dto.StatisticDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;
    @PostMapping
    public void saveStatistics(@RequestBody StatisticDto statisticDto) {
        statisticService.saveStatistic(statisticDto);
    }

    @GetMapping("/data")
    public List<StatisticDto> getData() {
        return statisticService.getStatistics();
    }

    @GetMapping("/ignore-traces")
    public String getDataTest() {
        return "Test";
    }
}

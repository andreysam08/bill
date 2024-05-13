package com.example.client.controller;

import com.example.client.dto.StatisticDto;
import com.example.client.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("statistics")
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
}

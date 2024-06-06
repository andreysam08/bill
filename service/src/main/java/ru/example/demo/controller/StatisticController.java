package ru.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.example.demo.dto.StatisticDto;
import ru.example.demo.service.StatisticService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;
    @GetMapping
    public StatisticDto getData(@RequestParam LocalDateTime startTime) {
        return statisticService.getStatistics(startTime);
    }
}

package com.example.client.service;

import com.example.client.dto.StatisticDto;
import com.example.client.mapper.StatisticMapper;
import com.example.client.repository.StatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final StatisticRepository statisticRepository;
    private final StatisticMapper statisticMapper;
    public void saveStatistic(StatisticDto statisticDto) {
        statisticRepository.save(statisticMapper.map(statisticDto));
    }
}

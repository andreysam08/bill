package com.example.client.mapper;

import com.example.client.dto.StatisticDto;
import com.example.client.entity.Statistic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatisticMapper {
    Statistic map(StatisticDto statisticDto);
}

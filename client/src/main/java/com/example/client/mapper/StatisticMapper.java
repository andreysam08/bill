package com.example.client.mapper;

import com.example.client.entity.Statistic;
import org.example.dto.StatisticDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatisticMapper {
    Statistic map(StatisticDto statisticDto);

    List<StatisticDto> map(List<Statistic> statistics);
}

package com.diet.mappers;

import com.diet.dto.StatisticsDto;
import com.diet.entities.Statistics;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StatisticsMapper implements Function<StatisticsDto, Statistics> {

    @Override
    public Statistics apply(StatisticsDto statisticsDto) {
        return Statistics
                .builder()
                    .water(statisticsDto.getWater())
                    .walk(statisticsDto.getWalk())
                    .elliptical(statisticsDto.getElliptical())
                    .rowingMachine(statisticsDto.getRowingMachine())
                    .allActivitiesCompleted(statisticsDto.getAllActivitiesCompleted())
                    .weight(statisticsDto.getWeight())
                    .dietDate(statisticsDto.getDietDate())
                .build();
    }
}
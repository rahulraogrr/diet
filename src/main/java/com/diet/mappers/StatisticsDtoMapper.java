package com.diet.mappers;

import com.diet.dto.StatisticsDto;
import com.diet.entities.Statistics;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StatisticsDtoMapper implements Function<Statistics, StatisticsDto> {

    @Override
    public StatisticsDto apply(Statistics statistics) {
        return StatisticsDto
                .builder()
                .id(statistics.getId())
                .water(statistics.getWater())
                .walk(statistics.getWalk())
                .dietDate(statistics.getDietDate())
                .elliptical(statistics.getElliptical())
                .overallStatus(statistics.getOverallStatus())
                .rowingMachine(statistics.getRowingMachine())
                .weight(statistics.getWeight())
                .build();
    }
}
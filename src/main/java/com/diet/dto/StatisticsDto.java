package com.diet.dto;

import com.diet.entities.Statistics;
import com.diet.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Statistics} entity
 */
@Data
@Builder
@AllArgsConstructor
public class StatisticsDto implements Serializable {
    private final Long id;
    private final Date dietDate;
    private final Float water;
    private final Float walk;
    private final Float elliptical;
    private final Float rowingMachine;
    private final Float weight;
    private final Status overallStatus;
}
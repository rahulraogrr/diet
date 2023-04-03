package com.diet.dto;

import com.diet.entities.Statistics;
import com.diet.enums.YesNo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Statistics} entity
 */
@Data
@Builder
@AllArgsConstructor
public class StatisticsDto implements Serializable {

    @Schema(
            title = "id",
            name = "id",
            example = "1",
            description = "ID of the Statistics Entity. Required when we send browse request"
    )
    private final Long id;

    @Schema(
            title = "dietDate",
            name = "dietDate",
            description = "Diet Date"
    )
    private final LocalDate dietDate;

    @Schema(
            title = "water",
            name = "water",
            description = "water in ml",
            example = "1000"
    )
    private final Float water;

    @Schema(
            title = "walk",
            name = "walk",
            description = "walk in km",
            example = "1"
    )
    private final Float walk;

    @Schema(
            title = "elliptical",
            name = "elliptical",
            description = "Elliptical in minutes",
            example = "10"
    )
    private final Float elliptical;

    @Schema(
            title = "rowingMachine",
            name = "rowingMachine",
            description = "Rowing Machine in minutes",
            example = "10"
    )
    private final Float rowingMachine;

    @Schema(
            title = "weight",
            name = "weight",
            description = "Weight in kg",
            example = "90"
    )
    private final Float weight;

    @Schema(
            title = "allActivitiesCompleted",
            name = "allActivitiesCompleted",
            description = "All Activities Completed Yes/No",
            example = "NO",
            enumAsRef = true,
            implementation = YesNo.class
    )
    private final YesNo allActivitiesCompleted;
}
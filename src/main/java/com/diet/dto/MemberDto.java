package com.diet.dto;

import com.diet.entities.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link Member} entity
 */
@Data
@Builder
@AllArgsConstructor
public class MemberDto implements Serializable {

    @Schema(
            title = "id",
            name = "id",
            example = "1",
            description = "ID of the Member Entity. Required when we send browse request"
    )
    private final int id;

    @Schema(
            title = "firstName",
            name = "firstName",
            description = "First Name",
            example = "Rahul Rao",
            required = true
    )
    private final String firstName;

    @Schema(
            title = "lastName",
            name = "lastName",
            description = "Last Name",
            example = "Gonda",
            required = true
    )
    private final String lastName;

    @Schema(
            title = "dateOfBirth",
            name = "dateOfBirth",
            description = "Date Of Birth",
            example = "1989-03-25",
            required = true
    )
    private final Date dateOfBirth;

    @Schema(
            title = "dietStats",
            name = "dietStats",
            description = "Statistics table list",
            required = true
    )
    private final Set<StatisticsDto> dietStats;
}
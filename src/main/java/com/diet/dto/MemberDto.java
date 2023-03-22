package com.diet.dto;

import com.diet.entities.Member;
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
    private final int id;
    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;
    private final Set<StatisticsDto> dietStats;
}
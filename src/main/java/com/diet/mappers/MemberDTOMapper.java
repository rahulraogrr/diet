package com.diet.mappers;

import com.diet.dto.MemberDto;
import com.diet.entities.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MemberDTOMapper implements Function<Member, MemberDto> {

    private final StatisticsDtoMapper statisticsDtoMapper;

    @Override
    public MemberDto apply(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .dateOfBirth(member.getDateOfBirth())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .dietStats(member.getStatistics()
                        .stream()
                        .map(statisticsDtoMapper)
                        .collect(Collectors.toSet()))
                .build();
    }
}
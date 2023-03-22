package com.diet.mappers;

import com.diet.dto.MemberDto;
import com.diet.entities.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MemberMapper implements Function<MemberDto, Member> {

    private final StatisticsMapper statisticsMapper;

    @Override
    public Member apply(MemberDto memberDto) {
        return Member
                .builder()
                    .firstName(memberDto.getFirstName())
                    .lastName(memberDto.getLastName())
                    .dateOfBirth(memberDto.getDateOfBirth())
                    .statistics(memberDto.getDietStats()
                            .stream()
                            .map(statisticsMapper)
                            .collect(Collectors.toSet()))
                .build();
    }
}
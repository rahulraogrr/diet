package com.diet.services.impl;

import com.diet.entities.Member;
import com.diet.exceptions.custom.NotFoundException;
import com.diet.repositories.MemberRepository;
import com.diet.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("MemberServiceImpl")
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Integer id, Member member) {

        Member existingMember = getMemberById(id)
                .orElseThrow(() -> new NotFoundException("Member Not Found"));

        existingMember.setFirstName(member.getFirstName());
        existingMember.setLastName(member.getLastName());
        existingMember.setDateOfBirth(member.getDateOfBirth());

        existingMember.setStatistics(member.getStatistics());

        return memberRepository.save(existingMember);
    }

    @Override
    public Optional<Member> getMemberById(Integer id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
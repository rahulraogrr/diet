package com.diet.services;

import com.diet.dto.MemberDto;
import com.diet.entities.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Member createMember(Member member);
    Member updateMember(Integer id, Member member);
    Optional<Member> getMemberById(Integer id);
    List<Member> getAllMembers();
}
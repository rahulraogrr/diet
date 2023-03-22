package com.diet.controllers;

import com.diet.dto.MemberDto;
import com.diet.mappers.MemberDTOMapper;
import com.diet.mappers.MemberMapper;
import com.diet.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    private final MemberDTOMapper memberDTOMapper;

    private final MemberMapper memberMapper;

    @PostMapping
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberDto){
        return new ResponseEntity<>(memberDTOMapper.apply(
                memberService.createMember(memberMapper.apply(memberDto))
        ), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDto> updateMember(@PathVariable Integer id, @RequestBody MemberDto memberDto){
        return new ResponseEntity<>(memberDTOMapper.apply(
                memberService.updateMember(id,memberMapper.apply(memberDto))
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMember(@PathVariable Integer id){
        return new ResponseEntity<>(memberDTOMapper.apply(
                    memberService.getMemberById(id)
                            .orElseThrow(()-> new RuntimeException("Member Not Found"))),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MemberDto>> getAllMembers(){
        return new ResponseEntity<>(memberService.getAllMembers()
                .stream()
                .map(memberDTOMapper)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

}
package com.diet.controllers;

import com.diet.dto.MemberDto;
import com.diet.exceptions.custom.NotFoundException;
import com.diet.exceptions.models.BadRequestError;
import com.diet.exceptions.models.InternalServerError;
import com.diet.exceptions.models.NotFoundError;
import com.diet.mappers.MemberDTOMapper;
import com.diet.mappers.MemberMapper;
import com.diet.services.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
@Tag(name = "members", description = "MemberController")
public class MemberController {
    private final MemberService memberService;
    private final MemberDTOMapper memberDTOMapper;
    private final MemberMapper memberMapper;

    @Operation(summary = "Save Member", description = "Save A New Member To Database", tags = {"members"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(schema = @Schema(implementation = MemberDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = BadRequestError.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Resource Not Found", content = @Content(schema = @Schema(implementation = NotFoundError.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = InternalServerError.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberDto){
        return new ResponseEntity<>(memberDTOMapper.apply(
                memberService.createMember(memberMapper.apply(memberDto))
        ), HttpStatus.OK);
    }

    @Operation(summary = "Modify Member By id", description = "Modify Member By Passing His id", tags = {"members"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(schema = @Schema(implementation = MemberDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = BadRequestError.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Resource Not Found", content = @Content(schema = @Schema(implementation = NotFoundError.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = InternalServerError.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDto> updateMember(@PathVariable Integer id, @RequestBody MemberDto memberDto){
        return new ResponseEntity<>(memberDTOMapper.apply(
                memberService.updateMember(id,memberMapper.apply(memberDto))
        ), HttpStatus.OK);
    }

    @Operation(summary = "Get Member By Username", description = "Get Member By Passing His id", tags = {"members"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(schema = @Schema(implementation = MemberDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = BadRequestError.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Resource Not Found", content = @Content(schema = @Schema(implementation = NotFoundError.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = InternalServerError.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDto> getMember(@PathVariable Integer id){
        return new ResponseEntity<>(memberDTOMapper.apply(
                    memberService.getMemberById(id)
                            .orElseThrow(()-> new NotFoundException("Member Not Found"))),
                HttpStatus.OK);
    }

    @Operation(summary = "Get All Members", description = "Get All Members From Database", tags = {"members"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(schema = @Schema(implementation = MemberDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = BadRequestError.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Resource Not Found", content = @Content(schema = @Schema(implementation = NotFoundError.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = InternalServerError.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MemberDto>> getAllMembers(){
        return new ResponseEntity<>(memberService.getAllMembers().stream()
                .map(memberDTOMapper)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

}
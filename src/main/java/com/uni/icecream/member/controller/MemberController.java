package com.uni.icecream.member.controller;


import com.uni.icecream.common.ResponseDto;
import com.uni.icecream.member.dto.MemberDto;
import com.uni.icecream.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MemberController {
    private final MemberService memberService;
    private List<MemberDto> members;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    /*회원 정보 조회*/
    @GetMapping("/members/{memberCode}")
    public ResponseEntity<ResponseDto> selectMyMemberInfo(@PathVariable Long memberCode) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원 정보 조회 성공", memberService.selectMyInfo(memberCode)));
    }

    /*회원 정보 수정*/
    @PutMapping("/members")
    public ResponseEntity<ResponseDto> updateMemberInfo(@ModelAttribute MemberDto memberDto) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원 정보 수정 성공",  memberService.updateMyInfo(memberDto)));
    }

    /*회원 탈퇴*/
    @DeleteMapping("/members/{memberCode}")
    public ResponseEntity<ResponseDto> deleteMemberInfo(@PathVariable Long memberCode) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원 탈퇴 성공",  memberService.deleteMyInfo(memberCode)));
    }
}

package com.uni.icecream.member.controller;


import com.uni.icecream.common.ResponseDto;
import com.uni.icecream.member.dto.MemberDto;
import com.uni.icecream.member.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    /* 회원가입 */
    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signup(@RequestBody MemberDto memberDto) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED, "회원가입 성공", authService.signup(memberDto)));
    }

    /* 로그인 */
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody MemberDto memberDto) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "로그인 성공", authService.login(memberDto)));
    }

}
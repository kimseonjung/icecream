package com.uni.icecream.member.service;

import com.uni.icecream.member.dao.MemberMapper;
import com.uni.icecream.member.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Service
public class MemberService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    /*회원 정보 조회*/
    @GetMapping
    public MemberDto selectMyInfo(@PathVariable Long memberCode) {
        log.info("[MemberService] getMyInfo Start ==============================");

        MemberDto member = memberMapper.selectByMemberCode(memberCode);
        log.info("[MemberService] {}", member);
        log.info("[MemberService] getMyInfo End ==============================");

        return member;
    }

    /*회원 정보 수정*/
    @Transactional
    public Object updateMyInfo(MemberDto memberDto) {


            log.info("[MemberService] updateMyInfo Start ===================================");
            log.info("[MemberService] memberDto : " + memberDto);

            int result = 0;

            memberDto.setMemberPassword(passwordEncoder.encode(memberDto.getMemberPassword()));

            result = memberMapper.updateMyInfo(memberDto);


            log.info("[ProductService] updateProduct End ===================================");
            log.info("[ProductService] result > 0 성공: "+ result);

            return (result > 0) ? "회원 정보 수정 성공" : "회원 정보 수정 실패";
        }

    /*회원 탈퇴*/
    public int deleteMyInfo(Long memberCode) {

        return memberMapper.deleteMyInfo(memberCode);
    }
}
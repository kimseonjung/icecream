package com.uni.icecream.member.dao;

import com.uni.icecream.member.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;


@Mapper
public interface MemberMapper {

    MemberDto selectByEmail(String email);

    /* 회원가입 */
    int insertMember(MemberDto member);

    /* 로그인 */
    Optional<MemberDto> findByMemberId(String memberId);

    /*회원 정보 조회*/
    MemberDto selectByMemberCode(Long memberCode);

    /*회원 정보 수정*/
    int updateMyInfo(MemberDto memberDto);

    /*회원 탈퇴*/
    int deleteMyInfo(Long memberCode);
}

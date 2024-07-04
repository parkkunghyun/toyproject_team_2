package com.twoteam.toyproject.service;

import com.twoteam.toyproject.dto.MemberDTO;
import com.twoteam.toyproject.entity.Member;
import com.twoteam.toyproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // MemberDTO를 Member 엔티티로 변환하는 메서드
    public Member convertToEntity(MemberDTO memberDTO) {
        return new Member(
                null,
                memberDTO.getMemberEmail(),
                memberDTO.getMemberPW(),
                memberDTO.getMemberName(),
                memberDTO.getMemberMBTI()
        );
    }
    // 회원가입 로직 구현
    public void registerMember(MemberDTO memberDTO) {
        // DTO를 엔티티로 변환
        Member member = convertToEntity(memberDTO);

        // 저장 로직 (Repository 사용)
        memberRepository.save(member);
    }
    // 이메일과 비밀번호로 회원 조회하는 메서드 추가
    // 이메일과 비밀번호로 회원 조회하는 메서드
    public Member findMemberByEmailAndPassword(String memberEmail, String memberPW) {
        return memberRepository.findByMemberEmailAndMemberPW(memberEmail, memberPW);
    }
}

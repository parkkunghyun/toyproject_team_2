package com.twoteam.toyproject.repository;

import com.twoteam.toyproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 이메일을 통해 멤버를 찾는 메서드 추가
    Member findByMemberEmail(String memberEmail);
}
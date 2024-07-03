package com.twoteam.toyproject.repository;

import com.twoteam.toyproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberEmailAndMemberPW(String memberEmail, String memberPW);
}

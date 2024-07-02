package com.twoteam.toyproject.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {

    @Column(length = 10)
    private String memberName;

    @Column(unique = true, nullable = false, length = 30)
    private String memberEmail;

    @Column(length = 255)
    private String memberPW;

    // 필요 없는 getMemberPWConfirm() 메소드 제거
}

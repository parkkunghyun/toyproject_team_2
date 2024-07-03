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

    @Column(length = 1) // "E" 또는 "I"만 입력되므로 길이 1로 설정
    private String memberMBTI;
}

package com.twoteam.toyproject.entity;

import com.twoteam.toyproject.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long idx;

    @Column(nullable = false, unique = true)
    private String memberEmail;

    @Column(nullable = false)
    private String memberPW;

    @Column(nullable = false)
    private String memberName;
}

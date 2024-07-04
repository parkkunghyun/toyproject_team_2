package com.twoteam.toyproject.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private String memberName;
}

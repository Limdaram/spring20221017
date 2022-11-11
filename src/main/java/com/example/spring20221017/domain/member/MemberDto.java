package com.example.spring20221017.domain.member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDto {
    private String id;
    private String password;
    private String email;

    private LocalDateTime inserted;
}

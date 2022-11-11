package com.example.spring20221017.domain.lecture;

import lombok.Data;

@Data
public class JavaBean23 {
    private String name;
    // 객체 안에 객체
    private JavaBean24 job;
}

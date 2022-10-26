package com.example.spring20221017.lectureMain.p01lombok;

import lombok.AllArgsConstructor;

//@RequiredArgsConstructor // final 필드 초기화하는 생성자 생성 : JavaBean7(String, int);
@AllArgsConstructor // : JavaBean7(String, int, String);
public class JavaBean7 {
    private final String name;
    private final int age;
    private String address;

    JavaBean7(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

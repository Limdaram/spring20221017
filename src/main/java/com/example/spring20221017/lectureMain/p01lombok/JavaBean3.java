package com.example.spring20221017.lectureMain.p01lombok;

import lombok.Getter;
import lombok.Setter;

public class JavaBean3 {
    @Getter
    @Setter
    // name에 대한 getter setter가 만들어 졌다
    private String name;

    @Getter
    @Setter
    // age에 대한 getter setter가 만들어 졌다
    private int age;
}

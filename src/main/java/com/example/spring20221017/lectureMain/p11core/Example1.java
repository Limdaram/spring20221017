package com.example.spring20221017.lectureMain.p11core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Example1 {
    private Example2 ex2;

    public Example1() {

    }

    @Autowired
    public Example1(Example2 ex2) {
        this.ex2 = ex2;
    }

    public Example2 getEx2() {
        return ex2;
    }
}

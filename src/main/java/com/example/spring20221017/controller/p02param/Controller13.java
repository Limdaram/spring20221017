package com.example.spring20221017.controller.p02param;

import com.example.spring20221017.domain.JavaBean01;
import com.example.spring20221017.domain.JavaBean02;
import com.example.spring20221017.domain.JavaBean03;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex13")
public class Controller13 {
    @RequestMapping("sub01")
    public void method01(JavaBean01 bean1) {
        System.out.println("method01");
        System.out.println("이름 : " + bean1.getName());
        System.out.println("주소 : " + bean1.getAddress());
        System.out.println("이메일 : " + bean1.getEmail());

    }
    @RequestMapping("sub02")
    public void method02(JavaBean02 bean2) {
        System.out.println("이름 : " + bean2.getName());
        System.out.println("나이 : " + bean2.getAge());
        System.out.println("암호 : " + bean2.getPassword());
        System.out.println("이메일 : " + bean2.getEmail());
    }

    @RequestMapping("sub03")
    public void method03(JavaBean03 bean3) {
        System.out.println("점수 : " + bean3.getScore());
        System.out.println("이름 : " + bean3.getClassName());
        System.out.println("번호 : " + bean3.getStudentNumber());
        System.out.println("지역 : " + bean3.getLocation());
        System.out.println("평균 : " + bean3.getAvg());
        // System.out.println(bean3);
    }
}

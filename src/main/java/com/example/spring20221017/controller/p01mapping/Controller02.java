package com.example.spring20221017.controller.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex02")
public class Controller02 {
    // 요청경로 "/ex02/sub01"
    @RequestMapping("sub01") // 슬래시 생략 가능
    public void method01() {
        System.out.println("ex02 sub01 메소드 일함");
    }
    // 요청경로 "/ex02/sub02"
    @RequestMapping("sub02")
    public void method02() {
        System.out.println("ex02 sub02 메소드 일함");
    }

    @RequestMapping("sub03")
    public void method03() {
        System.out.println("ex03 sub03 메소드 일함");
    }

}

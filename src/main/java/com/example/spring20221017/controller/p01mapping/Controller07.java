package com.example.spring20221017.controller.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex07")
public class Controller07 {
    @GetMapping("sub01")
    public void method01() {
        System.out.println("method01");
    }
    // 특정 param이 있을때만 일하기
    // 더 구체적인 경로
    @GetMapping(value = "sub01", params = "name")
    public void method02() {
        System.out.println("method02");
    }

    @GetMapping("sub02")
    public void method03() {
        System.out.println("method03");
    }

    @GetMapping(value="sub02", params="address")
    public void method04() {
        System.out.println("method04");
    }

    @GetMapping(value="sub03", params="address=seoul")
    public void method05() {
        System.out.println("method05");
    }

    @GetMapping(value="sub03")
    public void method06() {
        System.out.println("method06");
    }

    @GetMapping(value="sub04")
    public void method07() {
        System.out.println("method07");
    }

    // 여러 파라미터 명시 가능
    @GetMapping(value="sub04", params={"name", "age"})
    public void method08() {
        System.out.println("method08");
    }
}

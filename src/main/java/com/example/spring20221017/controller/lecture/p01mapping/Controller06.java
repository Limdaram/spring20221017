package com.example.spring20221017.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ex06")
public class Controller06 {
    // 좀 더 구체적으로 reqeustmapping을 작성한 메소드가 우선권을 갖는다
    // @RequestMapping(value = "sub01", method = RequestMethod.GET)
    @GetMapping("sub01") // GetMapping이라고 더 구체적으로 작성했기 때문에 여기 method get이 우선
    public void method01() {
        System.out.println("method01");
    }
    @RequestMapping("sub01")
    public void method02() {
        System.out.println("method02");
    }

    @PostMapping("sub01")
    public void method03() {
        System.out.println("method03");
    }
}

package com.example.spring20221017.controller.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ex04")
public class Controller04 {

    @RequestMapping("sub01")
    public void method01() {
        System.out.println("메소드01 일함");
    }
    // 특정 방식으로만 올때 일하기
    @RequestMapping(value = "sub02", method = RequestMethod.GET)
    public void method02() {
        System.out.println("메소드02 일함");
    }

    @RequestMapping(value = "sub03", method = RequestMethod.POST)
    public void method03() {
        System.out.println("메소드03 일함");
    }

    @RequestMapping(
        value = "sub04",
        method = {RequestMethod.GET, RequestMethod.POST})
    public void method04() {
        System.out.println("method04");
    }

}

package com.example.spring20221017.controller.p09fetch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex42")
public class Controller42 {
    @RequestMapping("sub")
    public void method0() {
    }
    @GetMapping(path = "sub01", produces = "text/plain")
    public void method1() {
        System.out.println("/ex42/sub01 plain 메소드 일함");
    }
    @GetMapping(path = "sub01", produces = "text/html")
    public void method2() {
        System.out.println("/ex42/sub01 html 메소드 일함");
    }
}

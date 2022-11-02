package com.example.spring20221017.controller.p09fetch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex39")
public class Controller39 {
    @RequestMapping("sub01")
    public void method1() {

    }

    @RequestMapping("sub02")
    public void method2() {
        System.out.println("sub02 fetch");
    }

    @RequestMapping("sub03")
    public void method3() {
        System.out.println("sub03 fetch");
    }
}

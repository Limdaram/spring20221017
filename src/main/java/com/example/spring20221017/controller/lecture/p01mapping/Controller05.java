package com.example.spring20221017.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.GET;

@Controller
@RequestMapping("ex05")
public class Controller05 {
    @RequestMapping(value = "sub01", method = RequestMethod.GET)
    public void method1() {
        System.out.println("method1");
    }
    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping("sub02")
    public void method2() {
        System.out.println("method2");
    }
    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping("sub03")
    public void method3() {
        System.out.println("method3");
    }

    @GetMapping("sub04")
    public void method4() {
        System.out.println("method4");
    }

    @PostMapping("sub05")
    public void method5() {
        System.out.println("method5");
    }
}

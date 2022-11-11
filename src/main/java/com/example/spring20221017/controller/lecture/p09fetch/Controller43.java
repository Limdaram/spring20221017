package com.example.spring20221017.controller.lecture.p09fetch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex43")
public class Controller43 {
    @RequestMapping("sub")
    public void method () {

    }

    @RequestMapping("sub01")
    public void method1(String name, String address) {
        System.out.println("첫번째 메소드 일함");
        System.out.println(name);
        System.out.println(address);
    }

    @GetMapping("sub02")
    public void method2(String email, Integer age) {
        System.out.println("두번째 메소드 일함");
        System.out.println(email);
        System.out.println(age);
    }

    @GetMapping("sub03")
    public void method3(String name, String email) {
        System.out.println("세번째 메소드 일함");
        System.out.println(name);
        System.out.println(email);
    }

    @GetMapping("sub04")
    public void method4(String address, Integer age) {
        System.out.println("네번째 메소드 일함");
        System.out.println(address);
        System.out.println(age);
    }

    @PostMapping("sub05")
    public void method5(String address, Integer age) {
        System.out.println("5번 메소드 일함");
        System.out.println(address);
        System.out.println(age);
    }

    @PostMapping("sub06")
    public void method6(String name, String email) {
        System.out.println("6번 메소드 일함");
        System.out.println(name);
        System.out.println(email);
    }

    @PostMapping("sub07")
    public void method7(String name, String email) {
        System.out.println("7번 메소드 일함");
        System.out.println(name);
        System.out.println(email);
    }

    @PostMapping("sub08")
    public void method8(String address, Integer age) {
        System.out.println("8번 메소드 일함");
        System.out.println(address);
        System.out.println(age);
    }
}

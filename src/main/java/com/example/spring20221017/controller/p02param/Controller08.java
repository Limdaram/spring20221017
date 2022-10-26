package com.example.spring20221017.controller.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
// 참고 reference
// https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments

@Controller
@RequestMapping("ex08")
public class Controller08 {
    @GetMapping("sub01")
    public void method01() {
        System.out.println("method01");
    }
    @GetMapping("sub02")
    public void method02(HttpServletRequest request) {
        System.out.println("method02");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name);
        System.out.println(age);
    }
    @GetMapping("sub03")
    public void method03(HttpServletRequest req) {
        String address = req.getParameter("address");
        System.out.println(address);
    }
}



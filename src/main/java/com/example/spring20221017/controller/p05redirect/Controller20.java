package com.example.spring20221017.controller.p05redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex20")
public class Controller20 {
    // 쿼리스트링으로 붙여서 넘겨주기
    @RequestMapping("sub01")
    public String method1() {
        return "redirect:/ex20/sub02?name=daram";
    }
    @RequestMapping("sub02")
    public String method2(String  name) {
        System.out.println("redirect 잘됨 sub02");
        System.out.println(name);
        return null;
    }

    @RequestMapping("sub03")
    public String method3() {
        return "redirect:/ex20/sub04?address=seoul&age=26";
    }
    @RequestMapping("sub04")
    public String method4(String address, Integer age) {
        System.out.println(address);
        System.out.println(age);
        return null;
    }
}

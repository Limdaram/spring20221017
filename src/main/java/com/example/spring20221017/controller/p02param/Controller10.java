package com.example.spring20221017.controller.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex10")
public class Controller10 {
    @GetMapping(path = "sub01", params = "name")
    public void method01(@RequestParam("name") String name) {
        System.out.println(name);
    }

    @GetMapping("sub02")
    public void method02() {
        System.out.println("name 파라미터 없을 때 일함");
    }

    // 파라미터 값이 있어도, 없어도 일함
    @GetMapping("sub03")
    public void method03(@RequestParam(name = "city", required = false) String c) {
        System.out.println(c);
    }

    @GetMapping("sub04")
    public void method04(@RequestParam(name = "address", required = false) String a) {
        System.out.println("주소 : " + a);
    }

    // 파라미터 값이 없을 때 디폴트 값
    @GetMapping("sub05")
    public void method05(@RequestParam(name = "city", defaultValue = "seoul") String c) {
        System.out.println(c);
    }

    @GetMapping("sub06")
    public void method06(@RequestParam(name = "address", defaultValue = "seoul") String a) {
        System.out.println(a);
    }
}

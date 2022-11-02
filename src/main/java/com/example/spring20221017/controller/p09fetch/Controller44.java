package com.example.spring20221017.controller.p09fetch;

import com.example.spring20221017.domain.JavaBean20;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex44")
public class Controller44 {
    @RequestMapping("sub")
    public void method() {

    }
    @PostMapping("sub01")
    public void method01(String name, String address) {
        System.out.println("1번 메소드 일함");
        System.out.println(name);
        System.out.println(address);
    }
    @PostMapping("sub02")
    public void method02(@RequestBody String data) {
        System.out.println("2번 메소드 일함");
        System.out.println(data);
    }
    @PostMapping("sub03")
    public void method03(@RequestBody JavaBean20 data) {
        System.out.println("3번 메소드 일함");
        System.out.println(data);
    }
}

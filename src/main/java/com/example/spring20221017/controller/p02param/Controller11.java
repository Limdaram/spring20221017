package com.example.spring20221017.controller.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex11")
public class Controller11 {
    @GetMapping("sub01")
    public void method01(@RequestParam("address") String address) {
        System.out.println(address);
    }

    @GetMapping("sub02")
    public void method02(@RequestParam String address) {
        // request param의 이름과 method arguments의 이름이 같을때
        // @RequestParam의 value 속성 생략 가능
        System.out.println(address);
    }

    @GetMapping("sub03")
    public void method03(String address) {
        // 메소드 파라미터가 기본타입 (8개, 또는 wrapper), String이면
        // @RequestParam이 붙은 것으로 간주
        System.out.println(address);
    }

    @GetMapping("sub04")
    public void method04(String city, int age, String name) {
        System.out.println(city);
        System.out.println(age);
        System.out.println(name);
    }
}

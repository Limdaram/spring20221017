package com.example.spring20221017.controller.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("ex12")
public class Controller12 {
    // 여러 값을 ,로 받기
    @RequestMapping("sub01")
    public void method01(@RequestParam("city") String city) {
        System.out.println(city);
    }

    // 여러 값을 배열로 받기
    @RequestMapping("sub02")
    public void method02(@RequestParam("city") String[] city) {
        System.out.println(city);
        System.out.println(Arrays.toString(city));
    }

    // 여러 값을 list로 받기
    @RequestMapping("sub03")
    public void method03(@RequestParam("city") List<String> city) {
        System.out.println(city);
        System.out.println(city.size());
    }

    // 위 3개의 @ReqeustParam value attribute 생략 가능

    @RequestMapping("sub04")
    public void method04(String name, String address, int age, String email, String password) {
        System.out.println("이름 : " + name);
        System.out.println("주소 : " + address);
        System.out.println("나이 : " + age);
        System.out.println("이메일 : " + email);
        System.out.println("암호 : " + password);
    }



}

package com.example.spring20221017.controller.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex09")
public class Controller09 {
    @GetMapping("sub01")
    public void method01(@RequestParam(name="address") String a) {
        System.out.println(a);
    }

    @GetMapping("sub02")
    public void method02(@RequestParam(name="name") String b) {
        System.out.println("이름 : " + b);
    }
    // value로 쓸 수 있다
    @GetMapping("sub03")
    public void method03(@RequestParam(value="name") String b) {
        System.out.println("이름 : " + b);
    }
    // value는 생략할 수 있다
    @GetMapping("sub04")
    public void method04(@RequestParam("name") String b) {
        System.out.println("이름 : " + b);
    }

    @GetMapping("sub05")
    public void method05(@RequestParam("name") String a, @RequestParam("address") String b) {
        System.out.println("name : " + a);
        System.out.println("address : " + b);
    }

    @GetMapping("sub06")
    public void method06(@RequestParam("address") String a, @RequestParam("age") int b) {
        System.out.println("주소 : " + a);
        System.out.println("나이 : " + b);
    }

    @GetMapping("sub08")
    public void method08(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        System.out.println("num1 + num2 = " + (a + b));
    }

    // request param -> method param 바인딩 될 때
    // 자동 형변환되는 type : String, 기본타입(primitive), wrapper

    @GetMapping("sub09")
    public void method09(@RequestParam("a") String a,
                         @RequestParam("b") double b,
                         @RequestParam("c") Double c,
                         @RequestParam("d") int d,
                         @RequestParam("e") Integer e) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

    }

}

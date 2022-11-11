package com.example.spring20221017.controller.lecture.p09fetch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("ex40")
public class Controller40 {
    @RequestMapping("sub0")
    public void method0() {
        // jsp로 포워드
    }
    @GetMapping("sub01")
    public void method01() {
        System.out.println("ex40/sub01/ get 방식 요청");
    }
    @GetMapping("sub02")
    public void method02() {
        System.out.println("ex40/sub02/ get 방식 요청");
    }
    @PostMapping("sub03")
    public void method03() {
        System.out.println("ex40/sub03/ post 방식 요청");
    }
    @GetMapping("sub04")
    public void method04() {
        System.out.println("ex40/sub04/ get 방식 요청");
    }
    @PostMapping("sub04")
    public void method05() {
        System.out.println("ex40/sub04/ post 방식 요청");
    }
//    @RequestMapping(path = "sub04", method = RequestMethod.PUT)
    @PutMapping("sub04")
    public void method06() {
        System.out.println("ex40/sub04 put 방식 요청");
    }
//    @RequestMapping(path = "sub04", method = RequestMethod.DELETE)
    @DeleteMapping("sub04")
    public void method07() {
        System.out.println("ex40/sub04 delete 방식 요청");
    }
    @GetMapping("sub05")
    public void method08() {
        System.out.println("sub05 get");
    }
    @PostMapping("sub05")
    public void method09() {
        System.out.println("sub05 post");
    }
    @PutMapping("sub05")
    public void method10() {
        System.out.println("sub05 put");
    }
    @DeleteMapping("sub05")
    public void method11() {
        System.out.println("sub05 delete");
    }
}

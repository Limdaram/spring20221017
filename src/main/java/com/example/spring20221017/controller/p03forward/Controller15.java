package com.example.spring20221017.controller.p03forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex15")
public class Controller15 {
    @RequestMapping("sub01")
    public void method01() {
        System.out.println("method01");
    }
    @RequestMapping("sub02")
    public void method02() {
        System.out.println("method02");
    }
    @RequestMapping("sub03")
    public String method03() {
        return null; // void 처럼 default view name을 사용해서 view로 포워드
    }
    // reqeust param이 있을 때, 없을 때
    @RequestMapping("sub04")
    public String method04() {
        return null;
    }
    @RequestMapping("sub05")
    public String method05(String name) {
        if (name == null) {
            return null;
        }
        return "ex15/sub051";
    }

//    @RequestMapping("sub06")
//    public String method06(String address) {
//        if (address == null) {
//            return null;
//        }
//        return "ex15/sub061";
//    }
    @RequestMapping(path = "sub06", params = "address")
    public String method06() {
        return "ex15/sub061";
    }
    @RequestMapping("sub06")
    public void method07() {

    }
}

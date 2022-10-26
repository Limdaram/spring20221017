package com.example.spring20221017.controller.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex03")
public class Controller03 {
    // /ex03/sub01
    // /ex03/sub02
    // /ex03/sub03
    @RequestMapping({"sub01", "sub02", "sub03"})
    public void method01() {
        System.out.println("ex03 method01");
    }

    @RequestMapping({"sub04", "sub05"})
    public void method02() {
        System.out.println("ex03 method02");
    }

//  @RequestMapping("sub06")
    @RequestMapping(value = "sub06")
    public void method04() {
        System.out.println("ex03 method04");
    }
//  @RequestMapping("sub07")
    @RequestMapping(path = "sub07")
    public void method05() {
        System.out.println("ex03 method05");
    }
}

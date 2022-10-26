package com.example.spring20221017.controller.p04attribute;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("ex16")
public class Controller16 {
    @RequestMapping("sub01")
    public void method01(HttpServletRequest request) {
        request.setAttribute("myName", "daram");
    }

    @RequestMapping("sub02")
    public void method02(HttpServletRequest request) {
        request.setAttribute("address", "seoul");
    }
}

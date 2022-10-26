package com.example.spring20221017.controller.p03forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("ex14")
public class Controller14 {
    public void method01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("method01");
        String path = "/WEB-INF/views/ex14/sub01.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @RequestMapping("sub02")
    public String method02() {
        System.out.println("method02");
        return "abc";
    }

    @RequestMapping("sub03")
    public String method03() {
        System.out.println("method03");
        return "def";
    }

    @RequestMapping("sub04")
    public String method04() {
        System.out.println("method04");
        return "ex14/sub04";
    }

    @RequestMapping("sub05")
    public String method05() {
        System.out.println("method05");
        return "ex14/sub05";
    }
}

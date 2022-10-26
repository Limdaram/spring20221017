package com.example.spring20221017.controller.p04attribute;

import com.example.spring20221017.domain.Student;
import com.example.spring20221017.domain.JavaBean03;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex17")
public class Controller17 {
    @RequestMapping("sub01")
    public  void method01(Model model) {
        model.addAttribute("myName", "daram");
    }

    @RequestMapping("sub02")
    public void method02(Model model) {
        model.addAttribute("email", "asdf@daum.net");
    }

    @RequestMapping("sub03")
    public void method03(Model model) {
        model.addAttribute("name", "daram" );
        model.addAttribute("address", "seoul");
        model.addAttribute("age", "26");
        model.addAttribute("email", "asdf@daum.net.");
    }
    @RequestMapping("sub04")
    public void method04(Model model) {
        JavaBean03 obj = new JavaBean03();
        obj.setAvg(99.9);
        obj.setClassName("spring");
        obj.setLocation("seoul");
        obj.setScore(100);
        obj.setStudentNumber("22");
        model.addAttribute("student", obj);

    }
    @RequestMapping("sub05")
    public void method05(Model model) {
        Student s = new Student();
        s.setName("daram");
        s.setClassName("spring");
        s.setStudentNumber("22");
//        model.addAttribute("student", s)
        model.addAttribute(s); // 이름이 같을 땐 생략가능
        model.addAttribute("hello");
    }
}


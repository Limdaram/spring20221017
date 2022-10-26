package com.example.spring20221017.controller.p05redirect;

import com.example.spring20221017.domain.JavaBean03;
import com.example.spring20221017.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("ex22")
public class Controller22 {
    @RequestMapping("sub01")
    public String method1(Model model) {
        model.addAttribute("name", "daram");
        return "redirect:/ex22/sub02";
    }
    @RequestMapping("sub02")
    public void method2(Model model) {
        boolean hasName = model.containsAttribute("name");
        System.out.println(hasName);
    }
    @RequestMapping("sub03")
    public String method3(HttpSession session) {
        session.setAttribute("name", "Limdaram");
        return "redirect:/ex22/sub04";
    }
    @RequestMapping("sub04")
    public void method4(HttpSession session) {
        String name = (String) session.getAttribute("name");
        System.out.println(name);
    }
    @RequestMapping("sub05")
    public String method5(HttpSession session) {
        Student student = new Student();
        student.setName("daram");
        student.setClassName("spring");
        student.setStudentNumber("22");
        return "redirect:/ex22/sub06";
    }
    @RequestMapping("sub06")
    public void method6(HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        System.out.println(student.getName());
        System.out.println(student.getClassName());
        System.out.println(student.getStudentNumber());
    }
    // RedirectAttributes로 객체 넘기기
    @RequestMapping("sub07")
    public String method7(RedirectAttributes rttr) {
        Student student = new Student();
        student.setName("Limdaram");
        student.setClassName("spring");
        student.setStudentNumber("26");
        rttr.addFlashAttribute("student", student);
        return "redirect:/ex22/sub08";
    }
    @RequestMapping("sub08")
    public void method8(Student student) {
        System.out.println(student);
    }
    @RequestMapping("sub09")
    public String method9(RedirectAttributes rttr) {
        JavaBean03 bean = new JavaBean03();
        bean.setClassName("spring");
        bean.setLocation("seoul");
        bean.setStudentNumber("22");
        bean.setScore(100);
        bean.setAvg(99.9);
        rttr.addFlashAttribute("bean", bean);
        return "redirect:/ex22/sub10";
    }
    @RequestMapping("sub10")
    public void method10 (@ModelAttribute("bean") JavaBean03 bean) {
//        System.out.println(bean.getClassName());
//        System.out.println(bean.getLocation());
//        System.out.println(bean.getStudentNumber());
//        System.out.println(bean.getScore());
//        System.out.println(bean.getAvg());
    }
}

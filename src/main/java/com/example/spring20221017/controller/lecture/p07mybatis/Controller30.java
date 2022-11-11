package com.example.spring20221017.controller.lecture.p07mybatis;

import com.example.spring20221017.domain.lecture.JavaBean06;
import com.example.spring20221017.mapper.lecture.Mapper03;
import com.example.spring20221017.domain.lecture.JavaBean04;
import com.example.spring20221017.domain.lecture.JavaBean05;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex30")
public class Controller30 {

    @Autowired
    private Mapper03 mapper;

    @RequestMapping("sub01")
    public void method01() {
        JavaBean04 customer = mapper.getCustomer();
        System.out.println(customer);
    }

    @RequestMapping("sub02")
    public void method02() {
        JavaBean05 employee = mapper.getEmployee();
        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
    }

    @RequestMapping("sub03")
    public void method03() {
        JavaBean05 emp = mapper.getEmployee2();
        System.out.println(emp.getFirstName());
        System.out.println(emp.getLastName());
    }

    @RequestMapping("sub04")
    public void method04() {
        JavaBean04 cus = mapper.getCustomer2();
        System.out.println(cus.getName());
        System.out.println(cus.getCountry());
    }

    @RequestMapping("sub05")
    public void method05() {
        JavaBean06 prod = mapper.getProduct();
        System.out.println(prod.getName());
        System.out.println(prod.getPrice());
    }
}

package com.example.spring20221017.controller.lecture.p07mybatis;

import com.example.spring20221017.domain.lecture.JavaBean11;
import com.example.spring20221017.domain.lecture.JavaBean12;
import com.example.spring20221017.mapper.lecture.Mapper06;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex33")
public class Controller33 {

    @Autowired
    private Mapper06 mapper;

    @RequestMapping("sub01")
    public void method01() {
        JavaBean11 category = mapper.getCategory();
        System.out.println(category.getId());
        System.out.println(category.getName());
        category.getProductName().forEach(System.out::println);
    }

    @RequestMapping("sub02")
    public void method02() {
        JavaBean12 supplier = mapper.getSupplier();
        System.out.println(supplier.getId());
        System.out.println(supplier.getName());
        supplier.getProductName().forEach(System.out::println);
    }
}

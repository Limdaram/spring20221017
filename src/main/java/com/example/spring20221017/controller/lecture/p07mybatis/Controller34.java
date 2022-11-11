package com.example.spring20221017.controller.lecture.p07mybatis;

import com.example.spring20221017.domain.lecture.JavaBean13;
import com.example.spring20221017.domain.lecture.JavaBean14;
import com.example.spring20221017.domain.lecture.JavaBean15;
import com.example.spring20221017.mapper.lecture.Mapper07;
import com.example.spring20221017.mapper.lecture.Mapper08;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("ex34")
public class Controller34 {
    @Autowired
    private Mapper07 mapper;

    @Autowired
    private Mapper08 mapper8;

    @RequestMapping("sub01")
    public void method1() {
        JavaBean13 category = mapper.getCategory();
        System.out.println(category.getId());
        System.out.println(category.getName());
        category.getProduct().forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });
    }

    @RequestMapping("sub02")
    public void method2() {
        JavaBean15 supplier = mapper.getSupplier();
        System.out.println(supplier.getId());
        System.out.println(supplier.getName());

        List<JavaBean14> product = supplier.getProduct();
        product.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });
    }

    // 쿼리에서 특수기호 (<,>) 처리
    @RequestMapping("sub03")
    public void method3() {
        System.out.println("------- entity 로 해결 -------");
        mapper8.getProductName().forEach(System.out::println);

        System.out.println("------- CDATA 로 해결 ---------");
        mapper8.getProductName2().forEach(System.out::println);
    }

    @RequestMapping("sub04")
    public void method4() {
        System.out.println("------- entity 로 해결 -------");
        mapper8.getEmployeeFirstName().forEach(System.out::println);

        System.out.println("------- CDATA 로 해결 ---------");
        mapper8.getEmployeeFirstName2().forEach(System.out::println);
    }
}

package com.example.spring20221017.controller.p07mybatis;

import com.example.spring20221017.mapper.Mapper02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("ex29")
public class Controller29 {
    @Autowired
    private Mapper02 mapper;

    @RequestMapping("sub01")
    public void method1() {
        List<String> names = mapper.getCustomerNames();
        System.out.println(names.size());
        System.out.println(names.get(0));
        System.out.println(names.get(1));
    }

    @RequestMapping("sub02")
    public void method2() {
        List<Integer> ids = mapper.getCustomerIds();
        System.out.println(ids.size());
        System.out.println(ids.get(0));
        System.out.println(ids.get(1));
    }

    @RequestMapping("sub03")
    public void method3() {
        List<Double> priceList = mapper.getProductPrices();
        System.out.println(priceList.size());
        System.out.println(priceList.get(0));
        System.out.println(priceList.get(1));
    }

    @RequestMapping("sub04")
    public void method4() {
        List<LocalDate> birthDate = mapper.getEmployeeBirthDate();
        System.out.println(birthDate.size());
        birthDate.forEach(System.out::println);
    }
}

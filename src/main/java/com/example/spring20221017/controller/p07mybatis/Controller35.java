package com.example.spring20221017.controller.p07mybatis;

import com.example.spring20221017.domain.JavaBean04;
import com.example.spring20221017.mapper.Mapper09;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.JavaBean;
import java.util.List;

@Controller
@RequestMapping("ex35")
public class Controller35 {
    @Autowired
    private Mapper09 mapper;

    @RequestMapping("sub01")
    public void method01() {
        String name1 = mapper.getCustomerNameById(1);
        String name2 = mapper.getCustomerNameById(2);

        System.out.println(name1);
        System.out.println(name2);
    }

    @RequestMapping("sub02")
    public void method02() {
        String fname1 = mapper.getEmployeeFirstNameById(1);
        String fname2 = mapper.getEmployeeFirstNameById(2);

        System.out.println(fname1);
        System.out.println(fname2);
    }

    @RequestMapping("sub03")
    public void method03() {
        List<String> berlin = mapper.getCustomerNameByCityAndCountry("Germany","Berlin");
        List<String> london = mapper.getCustomerNameByCityAndCountry("UK", "London");

        System.out.println(berlin);
        System.out.println(london);

    }

    @RequestMapping("sub04")
    public void method04() {
        String londona = mapper.getSupplierNameByCityAndCountry("UK", "Londona");
        String newOl = mapper.getSupplierNameByCityAndCountry("USA", "new Orleans");

        System.out.println(londona);
        System.out.println(newOl);
    }

    @RequestMapping("sub05")
    public void method05(JavaBean04 p) {
        String name = mapper.getContactName(p);
        System.out.println(name);
    }

    @RequestMapping("sub06")
    public void method06(JavaBean04 b) {
        String c = mapper.getSupplierContactName(b);
        System.out.println(c);
    }
}

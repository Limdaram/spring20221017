package com.example.spring20221017.controller.lecture.p09fetch;

import com.example.spring20221017.domain.lecture.JavaBean18;
import com.example.spring20221017.domain.lecture.JavaBean19;
import com.example.spring20221017.mapper.lecture.Mapper11;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("ex48")
public class Controller48 {
    @Autowired
    private Mapper11 mapper;

    @GetMapping("sub")
    public void method() {

    }
    @GetMapping("sub01")
    @ResponseBody
    public List<JavaBean18> method01() {
        List<JavaBean18> customers = mapper.getCustomers();
        return customers;
    }
    @GetMapping("sub02")
    @ResponseBody
    public List<JavaBean19> method02() {
        List<JavaBean19> suppliers = mapper.getSuppliers();
        return suppliers;
    }
}

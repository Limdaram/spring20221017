package com.example.spring20221017.controller.p07mybatis;

import com.example.spring20221017.domain.JavaBean18;
import com.example.spring20221017.domain.JavaBean19;
import com.example.spring20221017.mapper.Mapper10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex36")
public class Controller36 {
    @Autowired
    private Mapper10 mapper;

    @RequestMapping("sub01")
    public void method01() {
        int cnt = mapper.removeCustomer();
        System.out.println(cnt + "개 레코드 삭제됨");
    }

    @RequestMapping("sub02")
    public void method02() {
        int cnt = mapper.removeEmployee();
        System.out.println(cnt + "개 직원 레코드 삭제됨");
    }

    @RequestMapping("sub03")
    public void method03(int id) {
        int cnt = mapper.removeCustomerById(id);
        System.out.println(cnt + "개 고객 레코드 삭제됨");
    }

    @RequestMapping("sub04")
    public void method04(@RequestParam(name = "id", defaultValue = "0") int id) {
        int cnt = mapper.removeEmployeeId(id);
        System.out.println(cnt + "개 직원 레코드 삭제됨");
    }

    @RequestMapping("sub05")
    public void method05() {
        int cnt = mapper.addCustomer();
        System.out.println(cnt + "개 고객 정보 입력됨");
    }

    @RequestMapping("sub06")
    public void method06() {
        int cnt = mapper.addSupplier();
        System.out.println(cnt + "개 공급자 정보 입력됨");
    }
    @GetMapping("sub07")
    public void customerForm() {

    }

    @PostMapping("sub07")
    public void method07(JavaBean18 customer) {
        int cnt = mapper.insertCustomer(customer);
        System.out.println(cnt + "개 고객 정보 입력됨");
    }

    @GetMapping("sub08")
    public void supplierForm() {

    }

    @PostMapping("sub08")
    public void method08(JavaBean19 supplier) {
        int cnt = mapper.insertSupplier(supplier);
        System.out.println(cnt + "개 공급자 정보 입력됨");
    }
}

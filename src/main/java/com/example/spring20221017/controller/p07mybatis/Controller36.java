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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.JavaBean;

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

    @GetMapping("sub09")
    public String getMethod09() {
        return "/ex36/sub07";
    }

    @PostMapping("sub09")
    public String postMethod09(JavaBean18 customer, RedirectAttributes rttr) {
        System.out.println("key : " + customer.getId()); // 0
        int cnt = mapper.insertCustomerAndGetKey(customer);
        System.out.println(cnt + "개 고객 정보 입력");
        System.out.println("key : " + customer.getId()); // 생성된 키값
        rttr.addFlashAttribute("message",customer.getId() + "번 고객 등록 완료");
        return "redirect:/ex36/sub09";
    }

    @GetMapping("sub10")
    public String getMethod10() {
        // forward to / WEB-INF/views/ex36/sub08.jsp
        return "/ex36/sub08";
    }

    @PostMapping("sub10")
    public String postMethod10(JavaBean19 supplier, RedirectAttributes rttr) {
        System.out.println("key : " + supplier.getId());
        int cnt = mapper.insertSupplierAndGetKey(supplier);
        System.out.println(cnt + "개 공급자 정보 입력");
        System.out.println("key : " + supplier.getId());
        rttr.addFlashAttribute("message", supplier.getId() + "번 공급자 등록 완료");
        return "redirect:/ex36/sub10";
    }
}

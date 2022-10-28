package com.example.spring20221017.controller.p07mybatis;

import com.example.spring20221017.domain.JavaBean18;
import com.example.spring20221017.domain.JavaBean19;
import com.example.spring20221017.mapper.Mapper11;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("ex37")
public class Controller37 {
    @Autowired
    private Mapper11 mapper;

    @GetMapping("sub01")
    public void method(@RequestParam(name = "id", defaultValue = "0") int id, Model model) {
        JavaBean18 customer = mapper.getCustoemrById(id);
        model.addAttribute("customer", customer);
    }

    @PostMapping("sub01")
    public String method(JavaBean18 customer, RedirectAttributes rttr) {
        // 1. 파라미터 수집

        // 2. 비지니스 로직 처리
        int cnt = mapper.updateCustomer(customer);
        System.out.println(cnt + "개 고객정보 수정됨");
        int number = customer.getId();
        System.out.println(number + "번 고객정보 수정됨");

        // 3. 어트리뷰트 추가
        rttr.addAttribute("id", customer.getId());
        // 4. 리다이렉트
        return "redirect:/ex37/sub01";
    }

    @GetMapping("sub02")
    public void method1(@RequestParam(name="id", defaultValue = "0") int id, Model model) {
        JavaBean19 supplier = mapper.getSupplierById(id);
        model.addAttribute("supplier", supplier);
    }

    @PostMapping("sub02")
    public String method1(JavaBean19 supplier, RedirectAttributes rttr) {
        int cnt = mapper.updateSupplier(supplier);
        System.out.println(cnt + "개 공급자 정보 수정됨");
        int number = supplier.getId();
        System.out.println(number + "번 공급자 정보 수정됨");
        rttr.addAttribute("id", supplier.getId());
        return "redirect:/ex37/sub02";
    }
}

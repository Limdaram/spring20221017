package com.example.spring20221017.controller.lecture.p09fetch;

import com.example.spring20221017.domain.lecture.JavaBean18;
import com.example.spring20221017.domain.lecture.JavaBean19;
import com.example.spring20221017.mapper.lecture.Mapper10;
import com.example.spring20221017.mapper.lecture.Mapper11;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ex47")
public class Controller47 {

    @Autowired
    private Mapper11 mapper;

    @Autowired
    private Mapper10 mapper1;

    @RequestMapping("sub")
    public void method() {

    }
    @GetMapping("sub01")
    @ResponseBody
    public Map<String, String> method1() {
        return Map.of("address", "seoul", "name", "daram", "job","student");
    }
    @GetMapping("sub03")
    @ResponseBody
    public Map<String, Object> method3() {
        return Map.of("color", List.of("blue", "red"), "model", 5, "location", "USA");
    }
    // database 사용하기
    @GetMapping("sub04")
    @ResponseBody
    public JavaBean18 method4() {
        return mapper.getCustoemrById(30);
    }
    @GetMapping("sub05")
    @ResponseBody
    public JavaBean19 method5() {
        return mapper.getSupplierById(10);
    }
    @GetMapping("sub06/{id}")
    @ResponseBody
    public JavaBean18 method6(@PathVariable int id) {
        return mapper.getCustoemrById(id);
    }
    @GetMapping("sub07/{id}")
    @ResponseBody
    public JavaBean19 method7(@PathVariable int id) {
        return mapper.getSupplierById(id);
    }
    @GetMapping("sub08/{id}")
    @ResponseBody
    public Map<String, Object> method8(@PathVariable int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        JavaBean18 customer = mapper.getCustoemrById(id);

        if (customer != null) {
            map.put("customer", customer);
            map.put("message", "조회 완료되었습니다.");
        } else {
            map.put("message", "조회되지 않았습니다.");
        }
        return map;
    }
    @GetMapping("sub09/{id}")
    @ResponseBody
    public Map<String, Object> method9(@PathVariable int id) {
        Map<String, Object> map = new HashMap<>();
        JavaBean19 supplier = mapper.getSupplierById(id);

        if (supplier != null) {
            map.put("supplier", supplier);
            map.put("message", "조회 완료되었습니다.");
        } else {
            map.put("message", "조회되지 않았습니다.");
        }
        return map;
    }
    @PutMapping("sub10")
    @ResponseBody
    public Map<String, String> method10 (@RequestBody JavaBean18 customer) {
        Map<String, String> map = new HashMap<>();
        int cnt = mapper.updateCustomer(customer);
        if(cnt == 1) {
            map.put("message", customer.getId() + "번 고객정보가 변경되었습니다.");
        } else {
            map.put("message", customer.getId() + "번 고객정보가 변경되지 않았습니다.");

        }
        return map;
    }
    @PutMapping("sub11")
    @ResponseBody
    public Map<String, Object> method11 (@RequestBody JavaBean19 supplier) {
        Map<String, Object> map = new HashMap<>();
        int cnt = mapper.updateSupplier(supplier);
        if(cnt == 1) {
            map.put("message", supplier.getId() + "번 공급자정보가 변경되었습니다.");
        } else {
            map.put("message", supplier.getId() + "번 공급자정보가 변경되지 않았습니다.");

        }
        return map;
    }
    @PostMapping("sub12")
    @ResponseBody
    public Map<String, Object> method12 (@RequestBody JavaBean18 customer) {
        Map<String, Object> map = new HashMap<>();
        int cnt = mapper1.insertCustomer(customer);
        if(cnt == 1) {
            map.put("message", customer.getId() + "번 고객정보가 추가되었습니다.");
        } else {
            map.put("message", customer.getId() + "번 고객정보가 추가되지 않았습니다.");

        }
        return map;
    }
    @PostMapping("sub13")
    @ResponseBody
    public Map<String, Object> method13 (@RequestBody JavaBean19 supplier) {
        Map<String, Object> map = new HashMap<>();
        int cnt = mapper1.insertSupplier(supplier);
        if(cnt == 1) {
            map.put("message", supplier.getId() + "번 공급자정보가 추가되었습니다.");
        } else {
            map.put("message", supplier.getId() + "번 공급자정보가 추가되지 않았습니다.");

        }
        return map;
    }
    @DeleteMapping("sub14/{id}")
    @ResponseBody
    public Map<String, Object> method14 (@PathVariable int id) {
        Map<String, Object> map = new HashMap<>();
        int cnt = mapper1.removeCustomerById(id);
        if(cnt == 1) {
            map.put("message", id + "번 고객정보가 삭제되었습니다.");
        } else {
            map.put("message", id + "번 고객정보가 삭제되지 않았습니다.");

        }
        return map;
    }
    @DeleteMapping("sub15/{id}")
    @ResponseBody
    public Map<String, Object> method15 (@PathVariable int id) {
        Map<String, Object> map = new HashMap<>();
        int cnt = mapper1.removeCustomerById(id);
        if(cnt == 1) {
            map.put("message", id + "번 고객정보가 삭제되었습니다.");
        } else {
            map.put("message", id + "번 고객정보가 삭제되지 않았습니다.");

        }
        return map;
    }



}

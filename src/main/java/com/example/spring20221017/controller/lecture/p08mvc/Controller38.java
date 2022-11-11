package com.example.spring20221017.controller.lecture.p08mvc;

import com.example.spring20221017.domain.lecture.JavaBean18;
import com.example.spring20221017.service.Service01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex38")
public class Controller38 {

    @Autowired
    private Service01 service;
    @RequestMapping("sub01")
    public void method1() {
        // 레퀘스트파라미터 수집 / 가공
        int id = 5;
        // 비지니스 로직
        JavaBean18 customer = service.getCustomer(id);
        System.out.println(customer);
    }

    @RequestMapping("sub02")
    public void method2() {
        // 리퀘스트 파람 수집/가공

        // 비지니스 로직
        service.transferMoney();

        // 모델에 추가

        // 포워드 / 리다이렉트
    }
}

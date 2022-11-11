package com.example.spring20221017.service;

import com.example.spring20221017.domain.lecture.JavaBean18;
import com.example.spring20221017.mapper.lecture.Mapper11;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// @Service 안에 component가 있다
@Service
@Transactional
public class Service01 {
    @Autowired
    private Mapper11 mapper;
    public JavaBean18 getCustomer(int id) {
        // 비지니스 로직
        return mapper.getCustoemrById(id);
    }
// @Transactional이 자동으로 rollback 처리

    public void transferMoney() {
        // 1번 고객의 돈을 2번 고객에게 전달 (500원)
        int cnt = mapper.updateBank(1, -500);
        System.out.println(cnt + "건 성공");
        int a = 3/0; // exception이 났을때 1번에서 돈이 빠져나가지 말아야 한다(rollback)
        mapper.updateBank(2, +500);
    }
}

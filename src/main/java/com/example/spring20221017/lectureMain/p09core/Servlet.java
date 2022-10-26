package com.example.spring20221017.lectureMain.p09core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Servlet {
    private Dao dao; // Servlet이 Dao를 의존하고 있음

    @Autowired // 주입 가능한 빈이 있다면 이 메소드 사용해서 주입해라
    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public Dao getDao() {
        return dao;
    }
}

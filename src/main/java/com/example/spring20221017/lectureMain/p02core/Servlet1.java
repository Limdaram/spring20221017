package com.example.spring20221017.lectureMain.p02core;

import lombok.Setter;

public class Servlet1 {
    @Setter
    private ProductDao productDao;

    public void doGet() {
        productDao.getProductName();
    }
}

package com.example.spring20221017.lectureMain.p11core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }
}

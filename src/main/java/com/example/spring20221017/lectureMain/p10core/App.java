package com.example.spring20221017.lectureMain.p10core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        String config = "file:src/main/java/lecture/p10core/context.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        Controller c = context.getBean(Controller.class);
        Service s = context.getBean(Service.class);

        System.out.println(c);
        System.out.println(s);
        System.out.println(c.getService());

        System.out.println("프로그램 계속 실행");
    }
}

package com.example.spring20221017.lectureMain.p04core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        String config = "file:src/main/java/lecture/p04core/context.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        Servlet s = context.getBean(Servlet.class);
        Dao d = context.getBean(Dao.class);

        System.out.println(s);
        System.out.println(d);

        System.out.println(s.getDao()); // null이 아니여야함

        System.out.println("프로그램 계속 실행");
                



    }
}

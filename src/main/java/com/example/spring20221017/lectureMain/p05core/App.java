package com.example.spring20221017.lectureMain.p05core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        String loc = "file:src/main/webapp/WEB-INF/spring/root-context.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(loc);

        Service s = context.getBean(Service.class);
        Repository r1 =  context.getBean(Repository.class);
        Repository r2 = s.getRepository();

        System.out.println(s);
        System.out.println(r1);
        System.out.println(r2);

        System.out.println("프로그램 실행 계속");
    }
}

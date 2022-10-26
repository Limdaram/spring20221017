package com.example.spring20221017.lectureMain.p11core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        String loc = "file:src/main/java/lecture/p11core/context.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(loc);

        Servlet s = context.getBean(Servlet.class);
        Dao d = context.getBean(Dao.class);

        System.out.println(s);
        System.out.println(d);
        System.out.println(s.getDao());

        System.out.println("프로그램 계속 생성");

        Controller c = context.getBean(Controller.class);
        Service service = context.getBean(Service.class);

        System.out.println(c);
        System.out.println(service);

        System.out.println("프로그램 계속 생성");

        Example1 e1 = context.getBean(Example1.class);
        Example2 e2 = context.getBean(Example2.class);

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e1.getEx2());


    }
}

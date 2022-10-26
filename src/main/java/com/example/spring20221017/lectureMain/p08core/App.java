package com.example.spring20221017.lectureMain.p08core;

import com.example.spring20221017.lectureMain.p07core.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

public class App {
    public static void main(String[] args) {
        String loc = "/com/example/spring20221017/lectureMain/p08core/context.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(loc);

        System.out.println(context.getBean(Controller.class));
        System.out.println(context.getBean(Service.class));
        System.out.println(context.getBean(Repository.class));

        System.out.println(context.getBean(Dao.class));

        System.out.println("프로그램 실행");
    }
}

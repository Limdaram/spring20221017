package com.example.spring20221017.lectureMain.p01lombok;

public class App {
    public static void main(String[] args) {
        JavaBean2 j2 = new JavaBean2();
        JavaBean1 j1 = new JavaBean1();
        JavaBean4 j4 = new JavaBean4();

        j1.setName("daram");
        j1.setAddress("seoul");

        j2.setCompany("choongang");
        j2.setScore(100);

        j4.setAddress("서울");
        j4.setScore(100);

        System.out.println(j4.toString());


    }
}

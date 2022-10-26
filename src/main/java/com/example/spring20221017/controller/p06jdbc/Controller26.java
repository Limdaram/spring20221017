package com.example.spring20221017.controller.p06jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.mariadb.jdbc.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex26")
public class Controller26 {
    // 세션에서 최종으로 사용된 id값을 가져올 수 있는 방법 (getGeneratedKeys - ResultSet)
    @Autowired
    private DataSource dataSource;

    @RequestMapping("sub01")
    public void method1() throws Exception {
        String sql = "INSERT INTO Customers (CustomerName) VALUES (?) ";
        try (Connection con = dataSource.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            pstmt.setString(1, "SON HM");

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int newKey = rs.getInt(1);
                System.out.println(newKey + "번 고객입력됨"); // 새로 출력할때마다 그때의 최종 id값이 출력된다
            }
        }
    }

    // sub02 : 요청 경로
    // method2()
    // 새 직원을 입력하고 생성된 키를 sysout으로 출력하는 코드 작성
    @RequestMapping("sub02")
    public void method2() throws Exception {
        String sql = "INSERT INTO Employees (FirstName, LastName) VALUES (?, ?) ";
        try (Connection con = dataSource.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            pstmt.setString(1, "Lim");
            pstmt.setString(2, "daram");

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int newKey = rs.getInt(1);
                System.out.println(newKey + "번 직원");
            }
        }
    }
}













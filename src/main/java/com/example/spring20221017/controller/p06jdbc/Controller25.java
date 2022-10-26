package com.example.spring20221017.controller.p06jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.*;

@Controller
@RequestMapping("ex25")
public class Controller25 {
    @Autowired
    private DataSource dataSource;

    @RequestMapping("sub01")
    public void method1() throws SQLException {
        String sql = "INSERT INTO myTable07 (col1, col2, col3, col4, col5, col6) " +
                "VALUES (?, ?, ?, ?, ?, ?) ";

        try (
                Connection con  = dataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ) {
            pstmt.setInt(1, 99999);
            pstmt.setDouble(2, 1234567.089);
            pstmt.setString(3, "Limdaram");
            pstmt.setString(4, "LDR");
            pstmt.setDate(5, java.sql.Date.valueOf("2022-10-21"));
            pstmt.setTimestamp(6, java.sql.Timestamp.valueOf("2022-10-21 11:14:00"));

            int cnt = pstmt.executeUpdate();

            System.out.println(cnt + "개 레코드 입력 성공");
        }
    }

    @RequestMapping("sub02")
    public void method2() throws SQLException {
        String sql = "INSERT INTO myTable08 (name, age, score, address, birthDate, inserted) " +
                "VALUES (?, ?, ?, ?, ?, ?) ";

        try (
                Connection con  = dataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, "daram");
            pstmt.setInt(2, 26);
            pstmt.setDouble(3, 12345678.99);
            pstmt.setString(4, "seoul gangnam choongang 602");
            pstmt.setDate(5, java.sql.Date.valueOf("1997-08-21"));
            pstmt.setTimestamp(6, java.sql.Timestamp.valueOf("2022-10-21 11:26:00"));

            int cnt = pstmt.executeUpdate();

            System.out.println(cnt + "개 레코드 입력 성공");
        }
    }

    @RequestMapping("sub03")
    public void method3 () throws SQLException {
        String sql = "SELECT col1, col2, col3, col4, col5, col6 " +
                "FROM myTable07";
        try(Connection con = dataSource.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                int col1 = rs.getInt("col1");
                double col2 = rs.getDouble("col2");
                String col3 = rs.getString("col3");
                String col4 = rs.getString("col4");
                java.sql.Date col5 = rs.getDate("col5");
                java.sql.Timestamp col6 = rs.getTimestamp("col6");

                System.out.println(col1);
                System.out.println(col2);
                System.out.println(col3);
                System.out.println(col4);
                System.out.println(col5);
                System.out.println(col6);
                System.out.println();
            }
        }
    }

    @RequestMapping("sub04")
    public void method04() throws SQLException {
        String sql = "SELECT name, age, score, address, birthDate, inserted " +
                "FROM myTable08";
        try(Connection con = dataSource.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double score = rs.getDouble("score");
                String address = rs.getString("address");
                java.sql.Date birthDate = rs.getDate("birthDate");
                java.sql.Timestamp inserted = rs.getTimestamp("inserted");

                System.out.println(name);
                System.out.println(age);
                System.out.println(score);
                System.out.println(address);
                System.out.println(birthDate);
                System.out.println(inserted);
                System.out.println();
            }
        }
    }
}

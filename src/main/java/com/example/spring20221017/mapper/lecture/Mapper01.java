package com.example.spring20221017.mapper.lecture;

import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.Date;


public interface Mapper01 {
    @Select("SELECT NOW()")
    public String getCurrentTime();

    @Select("SELECT CustomerName FROM w3schools.Customers WHERE CustomerId=77")
    public String getCustomerName();

    public String getEmployeeName();

    public String getProductName();

    public double getPrice();

    public int getQuantity();

//    public Date getBirthDate();

    public LocalDate getBirthDate();
}

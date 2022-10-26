package com.example.spring20221017.mapper;


import com.example.spring20221017.domain.JavaBean05;
import com.example.spring20221017.domain.JavaBean06;

import java.util.List;

public interface Mapper04 {
    List<JavaBean06> getProductList();

    List<JavaBean05> getEmployeeList();
}

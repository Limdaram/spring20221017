package com.example.spring20221017.mapper.lecture;

import com.example.spring20221017.domain.lecture.JavaBean18;
import com.example.spring20221017.domain.lecture.JavaBean19;

public interface Mapper10 {
    public int removeCustomer();
    public int removeEmployee();
    public int removeCustomerById(int id);
    public int removeEmployeeId(int id);
    public int addCustomer();
    public int addSupplier();
    public int insertCustomer(JavaBean18 customer);
    public int insertSupplier(JavaBean19 supplier);

    int insertCustomerAndGetKey(JavaBean18 customer);

    int insertSupplierAndGetKey(JavaBean19 supplier);
}


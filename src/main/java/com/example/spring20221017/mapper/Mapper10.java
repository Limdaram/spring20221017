package com.example.spring20221017.mapper;

import com.example.spring20221017.domain.JavaBean18;
import com.example.spring20221017.domain.JavaBean19;

public interface Mapper10 {
    public int removeCustomer();
    public int removeEmployee();
    public int removeCustomerById(int id);
    public int removeEmployeeId(int id);
    public int addCustomer();
    public int addSupplier();
    public int insertCustomer(JavaBean18 customer);
    public int insertSupplier(JavaBean19 supplier);
}


package com.example.spring20221017.mapper.lecture;

import com.example.spring20221017.domain.lecture.JavaBean18;
import com.example.spring20221017.domain.lecture.JavaBean19;

import java.util.List;

public interface Mapper11 {
    int updateCustomer(JavaBean18 customer);
    JavaBean18 getCustoemrById(int id);

    int updateSupplier(JavaBean19 supplier);
    JavaBean19 getSupplierById(int id);

    int updateBank(int account, int money);

    List<JavaBean18> getCustomers();

    List<JavaBean19> getSuppliers();
}

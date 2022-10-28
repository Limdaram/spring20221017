package com.example.spring20221017.mapper;

import com.example.spring20221017.domain.JavaBean18;
import com.example.spring20221017.domain.JavaBean19;

public interface Mapper11 {
    int updateCustomer(JavaBean18 customer);
    JavaBean18 getCustoemrById(int id);

    int updateSupplier(JavaBean19 supplier);
    JavaBean19 getSupplierById(int id);

    int updateBank(int account, int money);
}

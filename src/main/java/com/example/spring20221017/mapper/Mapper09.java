package com.example.spring20221017.mapper;

import com.example.spring20221017.domain.JavaBean04;
import com.example.spring20221017.domain.JavaBean16;
import com.example.spring20221017.domain.JavaBean17;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Mapper09 {
    public String getCustomerNameById(int id);
    public String getEmployeeFirstNameById(int id);
//    List<String> getCustomerNameByCityAndCountry (String city, String country);
    List<String> getCustomerNameByCityAndCountry (String country, String city);
    String getSupplierNameByCityAndCountry(String country, String city);
    String getContactName(JavaBean04 bean1);

    String getSupplierContactName(JavaBean04 bean2);
    List<String> getProductName(JavaBean16 arg1, JavaBean17 arg2);
}

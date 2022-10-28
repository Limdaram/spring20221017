package com.example.spring20221017.mapper;

import com.example.spring20221017.domain.sample.CoffeeDto;

import java.util.List;

public interface CoffeeMapper {
    List<CoffeeDto> getCoffeeList();
    int update(CoffeeDto coffee);
}

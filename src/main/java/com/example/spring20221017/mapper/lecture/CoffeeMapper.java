package com.example.spring20221017.mapper.lecture;

import com.example.spring20221017.domain.lecture.CoffeeDto;

import java.util.List;

public interface CoffeeMapper {
    List<CoffeeDto> getCoffeeList();
    int update(CoffeeDto coffee);
}

package com.example.spring20221017.domain.lecture;

import lombok.Data;

import java.util.List;

@Data
public class JavaBean11 { // CategoryDTO
    private int id;
    private String name;
    private List<String> productName;
}

package com.example.spring20221017.domain;

import lombok.Data;

import java.util.List;

@Data
public class JavaBean15 {
    private int id;
    private String name;
    private List<JavaBean14> product;
}

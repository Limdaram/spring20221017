package com.example.spring20221017.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JavaBean08 {
    private int id;
    private LocalDate date;
    private JavaBean05 employee;
}

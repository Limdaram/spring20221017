package com.example.spring20221017.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

// date, dateTime 은 배열로 나타나기 때문에
// String으로 바꿔주기
@Data
public class JavaBean27 {
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateTime;
}

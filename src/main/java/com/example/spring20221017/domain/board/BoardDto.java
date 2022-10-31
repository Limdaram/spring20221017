package com.example.spring20221017.domain.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDto {
    private int id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime inserted;
}

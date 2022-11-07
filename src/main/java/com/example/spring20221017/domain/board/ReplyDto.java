package com.example.spring20221017.domain.board;

import lombok.Data;

@Data
public class ReplyDto {
    private int boardId;
    private String content;
}

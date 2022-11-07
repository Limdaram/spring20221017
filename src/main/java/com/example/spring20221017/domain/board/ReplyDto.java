package com.example.spring20221017.domain.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReplyDto {
    private int id;
    private int boardId;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime inserted;
}
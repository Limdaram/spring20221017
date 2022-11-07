package com.example.spring20221017.mapper.board;

import com.example.spring20221017.domain.board.ReplyDto;

import java.util.List;

public interface ReplyMapper {
    int insert(ReplyDto reply);

    List<ReplyDto> selectReplyByBoardId(int boardId);
}


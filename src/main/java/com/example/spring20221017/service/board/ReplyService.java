package com.example.spring20221017.service.board;

import com.example.spring20221017.domain.board.ReplyDto;
import com.example.spring20221017.mapper.board.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    private ReplyMapper mapper;
    public int addReply(ReplyDto reply) {
        return mapper.insert(reply);
    }

    public List<ReplyDto> listReplyByBoard(int boardId) {
        return mapper.selectReplyByBoardId(boardId);
    }
}

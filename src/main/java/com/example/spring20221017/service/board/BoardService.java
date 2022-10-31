package com.example.spring20221017.service.board;

import com.example.spring20221017.domain.board.BoardDto;
import com.example.spring20221017.mapper.board.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper mapper;
    public int register(BoardDto board) {
        return mapper.insert(board);
    }

    public List<BoardDto> listBoard() {
        return mapper.list();
    }

    public BoardDto get(int id) {
        return mapper.select(id);
    }

    public int update(BoardDto board) {
        return mapper.update(board);
    }

    public int remove(int id) {
        return mapper.delete(id);
    }
}

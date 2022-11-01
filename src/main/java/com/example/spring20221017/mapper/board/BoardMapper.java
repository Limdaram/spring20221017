package com.example.spring20221017.mapper.board;

import com.example.spring20221017.domain.board.BoardDto;

import java.util.List;

public interface BoardMapper {
    int insert(BoardDto board);

    List<BoardDto> list();

    BoardDto select(int id);

    int update(BoardDto board);

    int delete(int id);

    List<BoardDto> list(int offset, int records, String type, String keyword);

    int countAll(String type, String keyword);

}

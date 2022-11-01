package com.example.spring20221017.service.board;

import com.example.spring20221017.domain.board.BoardDto;
import com.example.spring20221017.domain.board.PageInfo;
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

    public List<BoardDto> listBoard(int page, String type, String keyword, PageInfo pageInfo) {
        int records = 10;
        int offset = (page - 1) * records;

        int countAll = mapper.countAll(type, "%" + keyword + "%"); // SELECT COUNT(*) FROM Board
        int lastPage = (countAll -1) / records + 1;

        int leftPageNumber = (page - 1) / 10 * 10 + 1;
        int rightPageNumber = leftPageNumber + 9;
        rightPageNumber = Math.min(rightPageNumber, lastPage);

        boolean hasPreviousButton = page > 10;
        boolean hasNextButton = page <= ((lastPage - 1) / 10 * 10);

        int previousPageNumber = (page - 1) / 10 * 10 - 9;
        int nextPageNumber = (page - 1) / 10 * 10 + 11;

        pageInfo.setHasPreviousButton(hasPreviousButton);
        pageInfo.setHasNextButton(hasNextButton);
        pageInfo.setNextPageNumber(nextPageNumber);
        pageInfo.setPreviousPageNumber(previousPageNumber);
        pageInfo.setCurrentPageNumber(page);
        pageInfo.setLeftPageNumber(leftPageNumber);
        pageInfo.setRightPageNumber(rightPageNumber);
        pageInfo.setLastPageNumber(lastPage);

        return mapper.list(offset, records, type, "%" + keyword + "%");

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

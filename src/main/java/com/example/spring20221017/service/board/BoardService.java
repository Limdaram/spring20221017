package com.example.spring20221017.service.board;

import com.example.spring20221017.domain.board.BoardDto;
import com.example.spring20221017.domain.board.PageInfo;
import com.example.spring20221017.mapper.board.BoardMapper;
import com.example.spring20221017.mapper.board.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private ReplyMapper replyMapper;
    public int register(BoardDto board) {
        return boardMapper.insert(board);
    }

    public List<BoardDto> listBoard(int page, String type, String keyword, PageInfo pageInfo) {
        int records = 10;
        int offset = (page - 1) * records;

        int countAll = boardMapper.countAll(type, "%" + keyword + "%"); // SELECT COUNT(*) FROM Board
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

        return boardMapper.list(offset, records, type, "%" + keyword + "%");

    }

    public BoardDto get(int id) {
        return boardMapper.select(id);
    }

    public int update(BoardDto board) {
        return boardMapper.update(board);
    }

    public int remove(int id) {
        // 게시물의 댓글 지우기
        replyMapper.deleteByBoardId(id);

        // int a = 3 / 0; // runtime exception

        // 게시물 지우기
        return boardMapper.delete(id);
    }
}

package com.example.spring20221017.service.board;

import com.example.spring20221017.domain.board.BoardDto;
import com.example.spring20221017.domain.board.PageInfo;
import com.example.spring20221017.mapper.board.BoardMapper;
import com.example.spring20221017.mapper.board.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.List;

@Service
@Transactional
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private S3Client s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public int register(BoardDto board, MultipartFile[] files) {
        // db에 게시물 정보 저장
        int cnt = boardMapper.insert(board);

        for (MultipartFile file : files) {
            if (file != null && file.getSize() > 0) {
                // db에 파일 정보 저장
                boardMapper.insertFile(board.getId(), file.getOriginalFilename());

                uploadFile(board.getId(), file);
            }
        }

        return cnt;
    }

    private void uploadFile(int id, MultipartFile file) {
        try {
            // S3에 파일 저장
            // 키 생성
            String key = "prj1/board/" + id + "/" + file.getOriginalFilename();

            // putObjectRequest
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .acl(ObjectCannedACL.PUBLIC_READ)
                    .build();

            // requestBody
            RequestBody requestBody = RequestBody.fromInputStream(file.getInputStream(), file.getSize());

            // object(파일) 올리기
            s3Client.putObject(putObjectRequest, requestBody);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<BoardDto> listBoard(int page, String type, String keyword, PageInfo pageInfo) {
        int records = 10;
        int offset = (page - 1) * records;

        int countAll = boardMapper.countAll(type, "%" + keyword + "%"); // SELECT COUNT(*) FROM Board
        int lastPage = (countAll - 1) / records + 1;

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

    public int update(BoardDto board, MultipartFile[] addFiles, List<String> removeFiles) {
        int boardId = board.getId();

        // removeFiles 에 있는 파일명으로

        if (removeFiles != null) {
            for (String fileName : removeFiles) {
                // 1. File 테이블에서 record 지우기
                boardMapper.deleteFileByBoardIdAndFileName(boardId, fileName);

                // 2. sw 저장소의 실제 파일 지우기
                deleteFile(boardId, fileName);
            }
        }


        for (MultipartFile file : addFiles) {
            if (file != null && file.getSize() > 0) {
                String name = file.getOriginalFilename();

                // File table에 해당파일명 지우기
                boardMapper.deleteFileByBoardIdAndFileName(boardId, name);

                // File table에 파일명 추가
                boardMapper.insertFile(boardId, name);

                // s3 저장소에 실제 파일 추가 (Object)
                uploadFile(boardId, file);

            }

        }
        return boardMapper.update(board);
    }

    public int remove(int id) {

        BoardDto board = boardMapper.select(id);

        List<String> fileNames = board.getFileName();

        if (fileNames != null) {
            for(String fileName : fileNames) {
                // s3 저장소 파일 지우기
                deleteFile(id, fileName);
            }
        }


        // 게시물 첨부 파일 지우기
        boardMapper.deleteFileByBoardId(id);

        // 게시물의 댓글 지우기
        replyMapper.deleteByBoardId(id);

        // 게시물 지우기
        return boardMapper.delete(id);
    }

    private void deleteFile(int id, String fileName) {
        String key = "prj1/board/" + id + "/" + fileName;
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();
        s3Client.deleteObject(deleteObjectRequest);
    }
}

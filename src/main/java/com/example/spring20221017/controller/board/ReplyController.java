package com.example.spring20221017.controller.board;

import com.example.spring20221017.domain.board.ReplyDto;
import com.example.spring20221017.service.board.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("reply")
public class ReplyController {
    @Autowired
    private ReplyService service;

    @GetMapping("list/{boardId}")
    @ResponseBody
    private List<ReplyDto> list(@PathVariable int boardId) {
        return service.listReplyByBoard(boardId);
    }

    @PostMapping("add")
    @ResponseBody
    public Map<String, Object> add (@RequestBody ReplyDto reply) {
        // System.out.println(reply);
        Map<String, Object> map = new HashMap<>();
        int cnt = service.addReply(reply);
        if (cnt == 1) {
            map.put("message", "새 댓글이 등록되었습니다.");
        } else {
            map.put("message", "새 댓글이 등록되지 않았습니다.");
        }
        return map;
    }
}

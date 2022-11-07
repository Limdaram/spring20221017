package com.example.spring20221017.controller.board;

import com.example.spring20221017.domain.board.ReplyDto;
import com.example.spring20221017.service.board.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reply")
public class ReplyController {
    @Autowired
    private ReplyService service;

    @PostMapping("add")
    public void add (@RequestBody ReplyDto reply) {
        // System.out.println(reply);
        service.addReply(reply);
    }
}

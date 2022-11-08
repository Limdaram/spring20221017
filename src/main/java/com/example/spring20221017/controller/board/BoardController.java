package com.example.spring20221017.controller.board;

import com.example.spring20221017.domain.board.BoardDto;
import com.example.spring20221017.domain.board.PageInfo;
import com.example.spring20221017.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("register")
    public void register() {
        // 게시물 작성 view로 포워드 (register.jsp)

    }

    @PostMapping("register")
    public String register(BoardDto board,
                           MultipartFile[] files,
                           RedirectAttributes rttr) {
        // * 파일업로드
        // 1. web.xml
        //    dispatcherServlet 설정에 multipart-config 추가
        // 2. form 에 enctype="multipart/form-data" 속성 추가
        // 3. Controller의 메소드 argument type : MultipartFile

        // request param 수집/가공
//        System.out.println(files.length);
//        for (MultipartFile file : files) {
//            System.out.println(file.getOriginalFilename());
//        }
        // busines  logic
        // int cnt = service.register(board, files);
        int cnt = service.register(board, files);
        if (cnt == 1) {
            rttr.addFlashAttribute("message", "새 게시물이 등록되었습니다.");
        } else {
            rttr.addFlashAttribute("message", "새 게시물이 등록되지 않았습니다.");
        }

        // /board/list로 redirect
        return "redirect:/board/list";
    }

    @GetMapping("list")
    public void list(@RequestParam(name = "page", defaultValue = "1") int page,
                     @RequestParam(name = "t", defaultValue="all") String type,
                     @RequestParam(name= "q", defaultValue = "") String keyword,
                     PageInfo pageInfo,
                     Model model) {
        // request param 수집
        // busines logic
        List<BoardDto> list = service.listBoard(page, type, keyword, pageInfo);
        // add attribute
        model.addAttribute("boardList", list);
        // forward
    }

    @GetMapping("get")
    public void get(@RequestParam(name = "id") int id, Model model) {
        // request param
        // business logic (게시물 db에서 가져오기)
        BoardDto board = service.get(id);
        // add attribute
        model.addAttribute("board", board);
        // forward / redirect
    }

    @GetMapping("modify")
    public void modify(int id, Model model) {
        BoardDto board = service.get(id);
        model.addAttribute("board", board);
    }

    @PostMapping("modify")
    public String modify(BoardDto board, RedirectAttributes rttr) {
        int cnt = service.update(board);
        if (cnt == 1) {
            rttr.addFlashAttribute("message", board.getId() + "번 게시물을 수정하였습니다.");
        } else {
            rttr.addFlashAttribute("message", board.getId() + "번 게시물을 수정하지 못했습니다.");
        }
        return "redirect:/board/list";
    }

    @PostMapping("remove")
    public String remove(int id, RedirectAttributes rttr) {
        int cnt = service.remove(id);
        if (cnt == 1) {
            rttr.addFlashAttribute("message", id + "번 게시물이 삭제되었습니다.");
        } else {
            rttr.addFlashAttribute("message", id + "번 게시물이 삭제되지 않았습니다.");
        }
        return "redirect:/board/list";
    }
}

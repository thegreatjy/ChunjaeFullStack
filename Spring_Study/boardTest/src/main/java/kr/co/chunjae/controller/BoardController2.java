package kr.co.chunjae.controller;

import kr.co.chunjae.dto.BoardDTO;
import kr.co.chunjae.service.BoardService;
import kr.co.chunjae.service.BoardService2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board2")
@RequiredArgsConstructor
public class BoardController2 {
    private final BoardService2 boardService2;

    // 글 목록
    @GetMapping("/")
    public String listAll(Model model){
        List<BoardDTO> list = boardService2.listAll();
        model.addAttribute("boardList", list);
        return "list";
    }
}

package kr.co.chunjae.controller;

import kr.co.chunjae.dto.CommentDTO;
import kr.co.chunjae.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/save")
    public @ResponseBody List<CommentDTO> save(@ModelAttribute CommentDTO commentDTO){
        // @ResponseBody : return 자바 객체를 하면 json 객체로 변환하여 전달된다.
        System.out.print("commentDTO:"+commentDTO);
        commentService.save(commentDTO);      /// 댓글 insert

        // 헤당 게시글의 댓글 목록을 조회
        List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId());
        return commentDTOList;
    }

    @GetMapping("/list")
    public @ResponseBody List<CommentDTO> findAll(@ModelAttribute CommentDTO commentDTO){
        // @ResponseBody : return 자바 객체를 하면 json 객체로 변환하여 전달된다.

        // 헤당 게시글의 댓글 목록을 조회
        List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId());
        return commentDTOList;
    }
}

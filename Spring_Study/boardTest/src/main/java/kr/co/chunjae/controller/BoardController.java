package kr.co.chunjae.controller;

import kr.co.chunjae.dto.BoardDTO;
import kr.co.chunjae.dto.CommentDTO;
import kr.co.chunjae.dto.PageDTO;
import kr.co.chunjae.service.BoardService;
import kr.co.chunjae.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j
public class BoardController {
    private final BoardService boardService;
    private final CommentService commentService;

    // 등록
    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        int saveResult = boardService.save(boardDTO);

        if(saveResult > 0){ // 성공
            return "redirect:/board/paging";
        }else { // 실패
            return "save";
        }
    }

    // 목록 조회
    @GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }

    // 상세 조회
    @RequestMapping
    public String findById(@RequestParam("id") Long id, @RequestParam(value="page", required = false, defaultValue = "1") int page, Model model){
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        model.addAttribute("page", page);   // 이전 목록 페이지로 돌아가기 위함

        // 댓글 목록 조회
        List<CommentDTO> commentDTOList = commentService.findAll(boardDTO.getId());
        model.addAttribute("commentList", commentDTOList);

        return "detail";
    }

    // 게시글 삭제
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        boardService.delete(id);
        return "redirect:/board/paging";
    }

    // 게시글 수정
    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model){
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board", dto);
        return "detail";
    }


    // /board/paging?page=2
    @GetMapping("/paging")
    public String paging(Model model, @RequestParam(value="page", required=false, defaultValue = "1") int page){
        log.info("page : "+page);
        // 해당 페이지에 보여줄 글 목록
        List<BoardDTO> pagingList = boardService.pageList(page);
        log.info(pagingList);

        // 해당 페이지 하단의 페이징
        PageDTO pageDTO = boardService.pagingParam(page);
        model.addAttribute("boardList", pagingList);
        model.addAttribute("paging", pageDTO);

        return "paging";
    }


}

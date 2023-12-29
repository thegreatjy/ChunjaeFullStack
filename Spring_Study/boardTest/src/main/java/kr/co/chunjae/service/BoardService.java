package kr.co.chunjae.service;

import kr.co.chunjae.dto.BoardDTO;
import kr.co.chunjae.dto.PageDTO;
import kr.co.chunjae.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;


    public int save(BoardDTO boardDTO) {
        return boardRepository.save(boardDTO);
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id);
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    int pageLimit = 3; // 한 페이지당 보여줄 글 갯수
    int blockLimit = 3; // 하단에 보여줄 페이지 번호 갯수

    public List<BoardDTO> pageList(int page) {
        // int pageLimit = 3;
        /*
        1페이지당 보여지는 글 갯수 3
        1page => 0 2page => 3 3page => 6
        */
        int pagingStart = (page - 1) * pageLimit;

        Map<String, Integer> pagingParams = new HashMap<>();
        pagingParams.put("start", pagingStart);
        pagingParams.put("limit", pageLimit);

        // 현재 페이지인 page에 출력될 게시글 리스트
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
        return pagingList;
    }

    public PageDTO pagingParam(int page){
        // 전체 글 개수 조회
        int boardCount = boardRepository.boardCount();
        // 전체 페이지 개수 계산 (전체 글 개수/한 페이지당 글 개수의 올림, 10/3 = 4)
        int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
        // 시작 페이지 값 (현재 페이지에서 맨 위 게시글 번호) 계산
        int startPage = ((int)(Math.ceil((double)page/blockLimit)) - 1) * blockLimit + 1;
        // 끝 페이지 값 (현재 페이지에서 맨 아래 게시글 번호) 계산
        int endPage = startPage + blockLimit - 1;

        if(endPage > maxPage){
            endPage = maxPage;
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStartPage(startPage);
        pageDTO.setEndPage(endPage);
        return pageDTO;
    }
}

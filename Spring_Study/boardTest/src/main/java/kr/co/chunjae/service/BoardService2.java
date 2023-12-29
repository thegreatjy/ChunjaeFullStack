package kr.co.chunjae.service;

import kr.co.chunjae.dto.BoardDTO;
import kr.co.chunjae.repository.BoardRepository;
import kr.co.chunjae.repository.BoardRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService2 {
    private final BoardRepository2 boardRepository2;

    public List<BoardDTO> listAll() {
        return boardRepository2.listAll();
    }
}

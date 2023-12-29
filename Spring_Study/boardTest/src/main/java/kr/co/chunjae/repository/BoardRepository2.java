package kr.co.chunjae.repository;

import kr.co.chunjae.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository2 {
    private final SqlSessionTemplate sql;

    public List<BoardDTO> listAll() {
        return sql.selectList("Board2.listAll");
    }
}

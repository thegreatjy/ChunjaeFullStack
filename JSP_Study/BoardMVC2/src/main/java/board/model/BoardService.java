package board.model;

import org.apache.ibatis.session.SqlSession;
import repository.mapper.BoardMapper;

import java.util.List;
import java.util.Map;

public class BoardService {
    // DAO
    SqlSession sqlSession;
    BoardMapper mapper;


    // 생성자
    public BoardService(){
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = sqlSession.getMapper(BoardMapper.class);
    }

    // 검색 조건에 맞는 게시물의 개수를 반환
    public int selectCount(Map<String, Object> map){
        return mapper.selectCount(map);
    }

    // 검색 조건에 맞는 게시물 목록을 반환 (페이징)
    public List<BoardVO> selectListPage(Map<String, Object> map){
        return mapper.selectListPage(map);
    }
}

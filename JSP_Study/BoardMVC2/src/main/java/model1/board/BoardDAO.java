package model1.board;

import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class BoardDAO {
    // DAO
    SqlSession sqlSession;
    board.model.BoardDAO mapper;

    // 기본 생성자
    public BoardDAO(){}

    // 검색 조건에 맞는 게시글 개수 반환
    public int selectCount(Map<String, Object> map){
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(board.model.BoardDAO.class);
        int result = mapper.selectCount(map);
        sqlSession.close();
        return result;
    }

    // 게시물 목록 가져오기
    public List<BoardDTO> selectList(){
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(board.model.BoardDAO.class);

        List<BoardDTO> list = mapper.selectList();

        sqlSession.close();
        return list;
    }


}

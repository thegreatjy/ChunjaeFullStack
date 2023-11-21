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
    public BoardService(){}

    // 검색 조건에 맞는 게시물의 개수를 반환
    public int selectCount(Map<String, Object> map){
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardMapper.class);
        int result = mapper.selectCount(map);
        sqlSession.close();
        return result;
    }

    // 검색 조건에 맞는 게시물 목록을 반환 (페이징)
    public List<BoardVO> selectListPage(Map<String, Object> map){
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardMapper.class);
        // offset 시작 위치 계산 후 map에 넣어준다.
        int pageSize = (int)map.get("pageSize");
        int pageNum = (int)map.get("pageNum");
        map.put("offsetStart", pageSize * (pageNum-1));

        List<BoardVO> list = mapper.selectListPage(map);
        sqlSession.close();
        return list;
    }

    // 게시물 데이터를 받아 DB에 추가 (파일 업로드 지원)
    public int insertWrite(BoardVO board){
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardMapper.class);
        int result = mapper.insertWrite(board);
        if(result == 1){
            // insert 성공
            sqlSession.commit();
        }else{
            // insert 실패
        }
        sqlSession.close();
        return result;
    }
}

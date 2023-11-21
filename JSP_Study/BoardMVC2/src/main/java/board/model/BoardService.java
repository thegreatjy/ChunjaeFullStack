package board.model;

import org.apache.ibatis.session.SqlSession;
import repository.mapper.BoardDAO;

import java.util.List;
import java.util.Map;

public class BoardService {
    // DAO
    SqlSession sqlSession;
    BoardDAO mapper;

    // 생성자
    public BoardService(){}

    // 검색 조건에 맞는 게시물의 개수를 반환
    public int selectCount(Map<String, Object> map){
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardDAO.class);
        int result = mapper.selectCount(map);
        sqlSession.close();
        return result;
    }

    // 검색 조건에 맞는 게시물 목록을 반환 (페이징)
    public List<BoardVO> selectListPage(Map<String, Object> map){
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardDAO.class);
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
        mapper = this.sqlSession.getMapper(BoardDAO.class);
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

    // 게시물 번호에 해당하는 게시물을 반환
    public BoardVO selectView(String idx){
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardDAO.class);
        BoardVO board = null;
        try {
            board = mapper.selectView(idx);
        }catch (Exception e){
            // null을 반환하게 된다.
            System.out.println("selectView 오류");
        }finally {
            sqlSession.close();
            return board;
        }
    }

    // 게시물 번호에 해당하는 게시물의 조회수를 1 증가
    public void updateVisitCount(String idx){
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardDAO.class);

        int result = mapper.updateVisitCount(idx);
        if(result == 1){
            // update 성공
            sqlSession.commit();
        }else{
            // update 실패
            System.out.println("updateVisitCount 실패");
        }

        sqlSession.close();
    }

    // 다운로드 횟수 1 증가
    public void downCountPlus(String idx) {
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardDAO.class);

        int result = mapper.downCountPlus(idx);
        if(result == 1){
            // 성공
            sqlSession.commit();
        }else{
            // 실패
            System.out.println("downCountPlus 실패");
        }
        sqlSession.close();
    }

    // 입력한 비밀번호가 지정한 일련번호의 게시물 비밀번호와 일치하는지 확인
    public boolean confirmPassword(String pass, String idx){
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardDAO.class);

        boolean result = mapper.confirmPassWord(pass, idx);
        return result;
    }

    // 게시물 번호에 해당하는 게시물 삭제
    public int deletePost(String idx){
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardDAO.class);

        int result = mapper.deletePost(idx);
        if(result == 1){
            // 성공
            sqlSession.commit();
        }else{
            // 실패
            System.out.println("deletePost 실패");
        }
        return result;
    }
}

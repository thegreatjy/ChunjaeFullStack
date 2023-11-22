package board.model;

import auth.SHA256;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
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

        String encryptedPass = "";
        try {
            // controller로부터 pass 값을 받아온다.
            String pass = board.getPass();
            encryptedPass = SHA256.encrypt(pass);
        }catch (Exception e){
            System.out.println("insertWrite - encrypt 오류 발생");
        }
        // 암호화된 비밀번호로 변경
        board.setPass(encryptedPass);

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

        HashMap<String, String> map = new HashMap<>();

        boolean isEqual = false; // 일치 여부를 반환한다.
        int result = 0;
        try {
            // 암호화된 비밀번호
            String encryptedPass = SHA256.encrypt(pass);
            System.out.println(pass + ", " + encryptedPass + ", " + idx);
            map.put("pass", encryptedPass);
            map.put("idx", idx);

            result = mapper.confirmPassword(map);
        }catch (Exception e){
            System.out.println("confirmPassword - encryptedPass 오류 발생");
            return isEqual;
        }

        if(result == 1){
            // 일치
            isEqual = true;
        }

        return isEqual;
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

    // 게시글 데이터를 받아 DB에 저장되어 있던 내용을 갱신합니다(파일 업로드 지원).
    public int updatePost(BoardVO dto) {
        this.sqlSession = factory.MyBatisFactory.getSqlSession();
        mapper = this.sqlSession.getMapper(BoardDAO.class);

        int result = mapper.updatePost(dto);
        if(result == 1){
            // 성공
            sqlSession.commit();
        }else{
            // 실패
            System.out.println("updatePost 실패");
        }
        return result;

    }
}

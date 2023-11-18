package model1.board;

import common.JDBConnect;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class BoardDAO extends JDBConnect {
    // 기본 생성자
    public BoardDAO(){}
    // 생성자
    // application 내장 객체를 통해 web.xml에 정의해 둔 접속 정보를 통해 DB 연결
    public BoardDAO(ServletContext application){
        super(application);
    }

    // 검색 조건에 맞는 게시글 개수 반환
    public int selectCount(Map<String, Object> map){
        int totalCount = 0;

        // 게시물 개수를 받아오는 쿼리
        String query = "select count(*) from board ";
        if (map.get("searchWord") != null) {
            query += "where " + map.get("searchField") + " like '%" + map.get("searchWord") + "%'";
        }

        try{
            stmt = con.createStatement();   // 쿼리 생성
            rs = stmt.executeQuery(query);  // 쿼리 실행
            rs.next();  // 커서를 첫 번째 행으로 이동
            totalCount = rs.getInt(1);  // 첫 번째 컬럼 값을 가져온다. DB 인덱스는 1부터 시작.
        }catch (Exception e){
            System.out.println("게시물 수를 구하는 중 예외 발생");
            e.printStackTrace();
        }

        return totalCount;
    }

    // 게시물 목록 가져오기
    public List<BoardDTO> selectList(Map<String, Object>map){
        List<BoardDTO> bbs = new Vector<BoardDTO>(); // 데이터 순서가 있는 List 타입의 컬렉션 사용

        // 쿼리
        String query = "select * from board ";
        if(map.get("searchWord") != null){
            query += "where " + map.get("searchField") + " like '%" + map.get("searchWord") + "%' "
                    + "order by num desc";
        }

        try{
            // 정적 쿼리 = Statement 객체
            // 정적 쿼리 실행 = executeQuery(query)
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while(rs.next()){
                BoardDTO board = new BoardDTO();

                board.setNum(rs.getString("num"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setPostdate(rs.getDate("postdate"));
                board.setId(rs.getString("id"));
                board.setVisitcount(rs.getString("visitcount"));

                bbs.add(board);
            }
        }catch(Exception e){
            System.out.println("게시물 수를 구하는 중 예외 발생");
            e.printStackTrace();
        }

        return bbs;
    }

    // 검색 조건에 맞는 게시물 목록을 반환 (페이징 지원)
    public List<BoardDTO> selectListPage(Map<String, Object> map){
        List<BoardDTO> bbs = new Vector<>();

        // 쿼리
        //String query = "select A.* from (select CONVERT(@rownum:=@rownum+1, SIGNED) rownumber, t.* from board as t where (@rownum:=0) = 0) as A where rownumber >= 1 and rownumber <= 10 order by A.rownumber desc";
        String query = "select * from board order by num desc limit ";
        int limit = (int)map.get("pageSize");
        int offset = (int)map.get("totalCount") - (int)map.get("start");
        query += Integer.toString(limit)+" offset " + Integer.toString(offset);
        // 검색 조건 추가
        /* if(map.get("searchWord") != null){
            query += "where "+map.get("searchField")+
                    " like '%"+map.get("searchWord")+"%' ";
        }*/
        //query += " order by num desc limit ? offset ?";

        try {
            System.out.println("1");
            // 쿼리문 완성
            psmt = con.prepareStatement(query);

            System.out.println(limit+", "+offset);

            // 쿼리문 실행
            rs = psmt.executeQuery();

            System.out.println("2");
            while (rs.next()) {  // 결과를 순화하며...
                // 한 행(게시물 하나)의 내용을 DTO에 저장
                System.out.println("3");
                BoardDTO dto = new BoardDTO();

                dto.setNum(rs.getString("num"));          // 일련번호
                dto.setTitle(rs.getString("title"));      // 제목
                dto.setContent(rs.getString("content"));  // 내용
                dto.setPostdate(rs.getDate("postdate"));  // 작성일
                dto.setId(rs.getString("id"));            // 작성자 아이디
                dto.setVisitcount(rs.getString("visitcount"));  // 조회수

                bbs.add(dto);  // 결과 목록에 저장
            }
        }
        catch (Exception e) {
            System.out.println("게시물 조회 중 예외 발생");
            e.printStackTrace();
        }
        System.out.println("4");
        return bbs;
    }

    // 게시글 작성하여 DB에 추가 후, 해당 게시글 행 리턴
    public int insertWrite(BoardDTO board){
        int result = 0;

        // 쿼리
        String query = "INSERT INTO board (title, content, id, visitcount) VALUES (?, ?, ?, 0)";   // 인파라미터 ? 로 설정

        try {
            // 동적 쿼리 = PreparedStatement 객체
            // 동적 쿼리 실행 = executeUpdate()
            psmt = con.prepareStatement(query);
            psmt.setString(1, board.getTitle());
            psmt.setString(2, board.getContent());
            psmt.setString(3, board.getId());
            result = psmt.executeUpdate();  // 쿼리 실행 결과의 행 개수를 리턴

        }catch (Exception e){
            System.out.println("게시물 작성 중 예외 발생");
            e.printStackTrace();
        }

        return result;
    }

    // 특정 게시물 조회 및 리턴
    public BoardDTO selectView(String num){
        BoardDTO board = new BoardDTO();

        // 쿼리
        String query = "select b.*, m.name from member m join board b on m.id = b.id where num=?";

        try{
            psmt = con.prepareStatement(query);
            psmt.setString(1, num); // 인파라미터에 num 넣음
            rs = psmt.executeQuery();   // 쿼리 실행

            // 결과 처리
            if(rs.next()){
                board.setNum(rs.getString(1));
                board.setTitle(rs.getString(2));
                board.setContent(rs.getString("content"));
                board.setPostdate(rs.getDate("postdate"));
                board.setId(rs.getString("id"));
                board.setVisitcount(rs.getString(6));
                board.setName(rs.getString("name"));
            }
        }catch (Exception e){
            System.out.println("게시물 상세보기 중 예외 발생");
            e.printStackTrace();
        }

        return board;
    }

    // 조회수 1 증가
    public void updateVisitCount(String num){
        // 쿼리
        String query = "update board set visitcount = visitcount + 1 where num=?";

        try{
            psmt = con.prepareStatement(query);
            psmt.setString(1, num);
            psmt.executeQuery();    // 쿼리 실행
        }catch(Exception e){
            System.out.println("게시물 조회수 증가 중 예외 발생");
            e.printStackTrace();
        }
    }

    // 게시물 수정
    public int updateEdit(BoardDTO board){
        int result = 0;

        try{
            // 쿼리
            String query = "update board set title=?, content=? where num=?";

            psmt = con.prepareStatement(query);
            psmt.setString(1, board.getTitle());
            psmt.setString(2, board.getContent());
            psmt.setString(3, board.getNum());

            result = psmt.executeUpdate(); // 쿼리 실행 결과의 행 개수를 리턴. 즉, 업데이트된 행의 개수 (num은 유일하므로 1 리턴)
        }catch (Exception e){
            System.out.println("게시물 수정 중 예외 발생");
            e.printStackTrace();
        }

        return result;
    }

    // 게시물 삭제
    public int deletePost(BoardDTO board){
        int result = 0;

        try{
            // 쿼리
            String query = "delete from board where num=?";

            psmt = con.prepareStatement(query);
            psmt.setString(1, board.getNum());

            result = psmt.executeUpdate();
        }catch (Exception e){
            System.out.println("게시물 삭제 중 예외 발생");
            e.printStackTrace();
        }

        return result; // 쿼리 실행 결과의 행 개수를 리턴. 즉, 삭제된 행의 개수 (num은 유일하므로 1 리턴)
    }
}

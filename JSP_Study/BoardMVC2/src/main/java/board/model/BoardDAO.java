package board.model;

import board.model.BoardVO;

import java.util.Map;
import java.util.List;

public interface BoardDAO {
    // 검색 조건에 맞는 게시물의 개수를 반환
    public int selectCount(Map<String, Object> map);
    // 검색 조건에 맞는 게시물 목록을 반환 (페이징)
    public List<BoardVO> selectListPage(Map<String, Object> map);
    // 게시물 데이터를 받아 DB에 추가 (파일 업로드 지원)
    public int insertWrite(BoardVO board);
    // 게시물 번호에 해당하는 게시물을 반환
    public BoardVO selectView(String idx);
    // 게시물 번호에 해당하는 게시물의 조회수를 1 증가
    public int updateVisitCount(String idx);
    // 다운로드 횟수 1 증가
    public int downCountPlus(String idx);
    // 입력한 비밀번호가 지정한 일련번호의 게시물 비밀번호와 일치하는지 확인
    public int confirmPassword(Map<String, String> map);
    // 게시물 번호에 해당하는 게시물 삭제
    public int deletePost(String idx);
    // 게시글 데이터를 받아 DB에 저장되어 있던 내용을 갱신합니다(파일 업로드 지원).
    public int updatePost(BoardVO dto);
}

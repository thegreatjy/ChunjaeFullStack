package board;

import account.Account;
import account.AccountMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Timestamp;
import java.util.ArrayList;

public class BoardDAO {
    SqlSessionFactory sqlSessionFactory;

    public void init(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    // 게시글 전부를 리턴한다.
    public ArrayList<Board> getBoards() {
        // sql session: conn+stmt, jdbc 처리를 함 (sql문 처리, 조회 결과를 받아온다)
        // sql문 + 메서드 + 데이터 타입(스키마) 을 알려줘야 한다.

        // openSession: MyBatis에서 실제 SQL 실행을 담당하는 컴포넌트
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        ArrayList<Board> objectsList;

        objectsList = mapper.getBoards();

        return objectsList;
    }

    public void insertBoard(String btitle, String bcontent, String bwriter) {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = new Board(btitle, bcontent, bwriter);
        mapper.insertBoard(board);
        // 데이터 변경이 있을 때, session.commit()을 해주어야 한다. select(검색)할 때에는 안 해줘도 됨.
        session.commit(); // update, delete, insert
    }

    public void updateBoard(String btitle, String bcontent, String bwriter){
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = new Board(btitle, bcontent, bwriter);
        mapper.updateBoard(board);
        // 데이터 변경이 있을 때, session.commit()을 해주어야 한다. select(검색)할 때에는 안 해줘도 됨.
        session.commit(); // update, delete, insert
    }

    public void deleteBoard(int bno){
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        mapper.deleteBoard(bno);
        // 데이터 변경이 있을 때, session.commit()을 해주어야 한다. select(검색)할 때에는 안 해줘도 됨.
        session.commit(); // update, delete, insert
    }
}

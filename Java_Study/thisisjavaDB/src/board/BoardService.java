package board;

import thisisjava.DBUtil;

public class BoardService {

    public void init(){
        DBUtil db = new DBUtil();
        // DB 연결 초기화
        db.init();

        BoardDAO boardDB = new BoardDAO();
        boardDB.init(db.getSession());
    }
    public void boardsList(){

    }
}

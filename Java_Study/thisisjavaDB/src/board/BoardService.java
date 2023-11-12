package board;

import resources.MyBatisConfig;

public class BoardService {

    public void init(){
        MyBatisConfig db = new MyBatisConfig();
        // DB 연결 초기화
        db.init();

        BoardDAO boardDB = new BoardDAO();
        boardDB.init(db.getSession());
    }
    public void boardsList(){

    }
}

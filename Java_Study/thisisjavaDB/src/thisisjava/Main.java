package thisisjava;

import account.Account;
import board.Board;
import board.BoardDAO;
import user.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


// 트랜잭션 -> 커밋, 롤백 exception 처리
// 사용자-게시글 연결해서 가입된 사용자만 게시글 등록

public class Main {
    public static void main(String[] args) throws Exception {
        DBUtil db = new DBUtil();
        // DB 연결 초기화
        db.init();

        BoardDAO boardDB = new BoardDAO();
        boardDB.init(db.getSession());

        // 명령 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = 0;

        // 콘솔 뷰 객체 생성
        View view = new View();

        // 프로그램 지속 여부
        boolean flag = true;

        while(flag){
            // 게시글 전체 보여주기
            ArrayList<Board> boardList = boardDB.getBoards();
            view.readBoards(boardList);

            // 메인 메뉴 선택 (1.Create | 2.Read | 3.Clear | 4.Exit)
            view.mainMenu();
            input = Integer.parseInt(br.readLine());

            switch (input){
                // create
                case 1:
                    view.createBoardHeader();

                    System.out.print("* 제목 : ");
                    String btitle = br.readLine();
                    System.out.print("* 내용 : ");
                    String bcontent = br.readLine();
                    System.out.print("* 작성자 : ");
                    String bwriter = br.readLine();

                    boardDB.insertBoard(btitle, bcontent, bwriter);

                    view.createBoardFooter();
                    break;
                // read
                case 2:

                    break;
                // clear
                case 3:

                    break;
                // exit
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    flag = false;
                    break;
                default:
                    System.out.println("다시 입력해주세요.");
            }
        }

        return;
    }
}
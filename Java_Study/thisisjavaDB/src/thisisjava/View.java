package thisisjava;

import board.Board;

import java.util.ArrayList;

public class View {

	public void printMain() {
		System.out.println();
	}

	public void printBoardsHeader(){
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-----------------------------------------------------------------------");
	}

	public void printBoardsList(){

	}

	public void mainMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택: ");
		System.out.println();
	}

	public void createBoardHeader(){
		System.out.println("[ 새 게시글 입력 ]");
	}
	public void createBoardFooter(){
		System.out.println("[ 게시글 올리기 완료 ]");
	}

	public void readBoards(ArrayList<Board> boards){
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-----------------------------------------------------------------------");

		for(Board board:boards) {
			System.out.printf("%-6s%-12s%-16s%-40s \n",
					board.getBno(), board.getBwriter(), board.getBdate(), board.getBtitle());
		}

		System.out.println("-----------------------------------------------------------------------");
	}

	public void readBoardHeader(){
		System.out.println("[ 게시글 읽기 ]");
	}
	public void readBoardContent(Board board){
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("번호 : " + board.getBno());
		System.out.println("제목 : " + board.getBtitle());
		System.out.println("내용 : " + board.getBcontent());
		System.out.println("작성자 : " + board.getBwriter());
		System.out.println("날짜 : " + board.getBdate());
		System.out.println("-----------------------------------------------------------------------");
	}

	public void updateBoardMenu(){
		System.out.println("보조 메뉴 : 1.Update | 2.Delete | 3.List");
	}
	public void updateCancel(){
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
	}
}

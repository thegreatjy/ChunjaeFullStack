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

	public void readBoard(){

	}
}

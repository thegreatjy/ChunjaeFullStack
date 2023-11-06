package board;

import thisisjava.ObjectMapper;

import java.util.ArrayList;

public interface BoardMapper {
    public ArrayList<Board> getBoards();
    public Board getBoard (int bno);
    public void insertBoard (Board board);
    public void updateBoard (Board board);
    public void deleteBoard (int id);
}

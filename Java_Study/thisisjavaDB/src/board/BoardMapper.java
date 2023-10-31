package board;

import thisisjava.ObjectMapper;

import java.util.ArrayList;

public interface BoardMapper extends ObjectMapper {
    public ArrayList<Board> getBoards();
    public void insertBoard (Board board);
    public void updateBoard (Board board);
    public void deleteBoard (int id);
}
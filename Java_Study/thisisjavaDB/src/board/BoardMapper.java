package board;

import java.util.ArrayList;

public interface BoardMapper {
    public ArrayList<Board> getBoards();
    public void insertBoards (Board board);
    public void updateBoards (Board board);
    public void deleteBoards (int id);
}

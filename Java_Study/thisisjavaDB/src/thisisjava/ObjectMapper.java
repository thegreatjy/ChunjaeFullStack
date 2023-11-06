package thisisjava;

import java.util.ArrayList;

// DAO

public interface ObjectMapper <T> {
    public ArrayList<T> getAccounts();
    public void insertAccount (T t);
    public void updateAccount (T t);
    public void deleteOAccount (int id);

    public ArrayList<T> getBoards();
    public void insertBoard (T t);
    public void updateBoard (T t);
    public void deleteBoard (int id);

    public ArrayList<T> getUsers();
    public void insertUser (T t);
    public void updateUser (T t);
    public void deleteUser (int id);
}

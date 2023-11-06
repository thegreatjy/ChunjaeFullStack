package user;

import java.util.ArrayList;

public interface UserMapper {
    public ArrayList<User> getUsers();
    public void insertUser (User user);
    public void updateUser (User user);
    public void deleteUser (int id);
}

package user;

import java.util.ArrayList;

public interface UserMapper {
    public ArrayList<User> getUsers();
    public void insertUsers (User user);
    public void updateUsers (User user);
    public void deleteUsers (int id);
}

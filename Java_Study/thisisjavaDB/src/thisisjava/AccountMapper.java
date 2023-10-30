package thisisjava;

import java.util.*;

public interface AccountMapper {
    public ArrayList<Account> getAddresses();
    public void insertAddress(Account addr);
    public void updateAddress(Account addr);
    public void deleteAddress(int id);
}

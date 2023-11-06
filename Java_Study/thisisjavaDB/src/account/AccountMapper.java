package account;

import java.util.*;

// DAO

public interface AccountMapper {
    public ArrayList<Account> getAccounts();
    public void insertAccount (Account account);
    public void updateAccount (Account account);
    public void deleteAccount (int id);
}

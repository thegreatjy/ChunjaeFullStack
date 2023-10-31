package account;

import java.util.*;

public interface AccountMapper {
    public ArrayList<Account> getAccounts();
    public void insertAccounts(Account account);
    public void updateAccounts(Account account);
    public void deleteAccounts(int id);
}

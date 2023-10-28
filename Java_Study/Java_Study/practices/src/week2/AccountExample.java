package week2;

public class AccountExample {
    public static void main(String[] args) {
        Account account = new Account();
        // 예금
        account.deposit(10000);
        System.out.println("예금액 : "+account.getBalance());
        // 출금
        try{
            account.withdraw(30000);
        }catch (InsufficientException e){
            System.out.println(e.getMessage());
        }

    }
}

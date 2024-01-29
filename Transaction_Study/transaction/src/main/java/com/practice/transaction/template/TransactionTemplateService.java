package com.practice.transaction.template;

import com.practice.transaction.Account;
import com.practice.transaction.TransactionMapper;
import com.practice.transaction.Transfer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@RequiredArgsConstructor
public class TransactionTemplateService {
    @Autowired
    private final TransactionMapper txMapper;

    @Autowired
    PlatformTransactionManager txManager;

    @Autowired
    TransactionDefinition txDefinition;

    @Autowired
    TransactionTemplate txTemplate;

    // 계좌 정보 가져오기
    public Account getAccountById(long accountId) {
        return txMapper.getAccountById(accountId);
    }

    // 계좌이체
    public Transfer transfer(long senderId, Long receiverId, long amount) {
        TransactionStatus status = txManager.getTransaction(txDefinition);

/*        Transfer transfer = null;
        try {
            transfer = new Transfer().builder()
                    .sender(send(senderId, amount))
                    .receiver(receive(receiverId, amount))
                    .build();

            txManager.commit(status);
        }catch (Exception e){
            txManager.rollback(status);
        }*/

        Transfer transfer = null;
        try{
            txTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus status) {
                    send(senderId, amount);
                    receive(receiverId, amount);
                }
            });
            Account sender = txMapper.getAccountById(senderId);
            Account receiver = txMapper.getAccountById(receiverId);
            transfer = new Transfer().builder()
                    .sender(sender)
                    .receiver(receiver)
                    .amount(amount)
                    .build();
        }catch (Exception e){
            System.err.println("이체 실패");
        }
        return transfer;
    }

    /**
     * senderId 보내는 사람이 amount의 돈을 보낸다.
     * @param senderId
     * @param amount
     * @return
     */
    private Account send(Long senderId, Long amount) {
        Account sender = txMapper.getAccountById(senderId);
        sender.setBalance(sender.getBalance() - amount);

        txMapper.updateAccountBalance(sender);

        return sender;
    }

    /**
     *
     * @param receiverId
     * @param amount
     * @return
     */
    private Account receive(Long receiverId, Long amount) {


        if(901L == receiverId) {
            Account receiver = txMapper.getAccountByIdWrongSql(receiverId);
        }


        Account receiver = txMapper.getAccountById(receiverId);
        receiver.setBalance(receiver.getBalance() + amount);

        txMapper.updateAccountBalance(receiver);

        return receiver;
    }

}

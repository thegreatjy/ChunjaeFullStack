package com.practice.transaction.noTransaction;

import com.practice.transaction.TransactionMapper;
import com.practice.transaction.Account;
import com.practice.transaction.Transfer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NoTransactionService {

    @Autowired
    private final TransactionMapper txMapper;

    // 계좌 정보 가져오기
    public Account getAccountById(long accountId) {
        return txMapper.getAccountById(accountId);
    }

    // 계좌이체
    public Transfer transfer(long senderId, Long receiverId, long amount) {
        Transfer transfer = new Transfer().builder()
                .sender(send(senderId, amount))
                .receiver(receive(receiverId, amount))
                .build();

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

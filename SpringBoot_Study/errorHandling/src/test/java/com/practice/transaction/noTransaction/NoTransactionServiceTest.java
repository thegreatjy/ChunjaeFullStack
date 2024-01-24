package com.practice.transaction.noTransaction;

import com.practice.transaction.Account;
import com.practice.transaction.TransactionMapper;
import com.practice.transaction.Transfer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoTransactionServiceTest {
    private Long SENDER_ID = 1L;
    private Long RECEIVER_ID = 2L;
    private Long AMOUNT = 5000L;

    @Autowired
    private NoTransactionService service;
    @Autowired
    private TransactionMapper mapper;

    // 테스트 진행 시, 각각 테스트를 진행하기 전에 무조건 실행하는 메서드
    // 초기값 셋팅용. 모든 테스트 전 공통적으로 처리할 내용의 메서드
    @BeforeEach
    void before(){
        Account sender = service.getAccountById(SENDER_ID);
        Account receiver = service.getAccountById(RECEIVER_ID);
        sender.setBalance(10000L);
        receiver.setBalance(0L);
        mapper.updateAccountBalance(sender);
        mapper.updateAccountBalance(receiver);
    }

    @Test
    @DisplayName("이체 테스트 001: 정상 이체")
    void testTransfer_001(){
        Transfer transfer = service.transfer(SENDER_ID, RECEIVER_ID, AMOUNT);   // sender -> receiver, amount 돈을 입금
        assertEquals(5000L, transfer.getSender().getBalance());
        assertEquals(5000L, transfer.getReceiver().getBalance());
    }

    @Test
    @DisplayName("이체 테스트 002: send ok, ")
    void testTransfer_002(){
        Exception e = assertThrows(Exception.class, () -> {
            service.transfer(SENDER_ID, 901L, AMOUNT);  // receiverId 에러
        });

        assertEquals(e.getClass().getSimpleName(), "BadSqlGrammarException");
        // @transactional 있으면 롤백되어 아래가 정상 수행
        /*
        assertEquals(5000L, service.getAccountById(SENDER_ID).getBalance());
        assertEquals(5000L, service.getAccountById(RECEIVER_ID).getBalance());
        */

        // @transactional 없어 롤백 안 되어 아래와 같음
        assertEquals(5000L, service.getAccountById(SENDER_ID).getBalance());
        assertEquals(0L, service.getAccountById(RECEIVER_ID).getBalance());
    }
}
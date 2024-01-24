package kr.co.chunjae.startspringboot.repository;

import org.springframework.stereotype.Repository;

@Repository
public class StatisticRepository {
    public Exception makeExceptionInRepository() throws ArrayIndexOutOfBoundsException{
        throw new ArrayIndexOutOfBoundsException();
    }
}

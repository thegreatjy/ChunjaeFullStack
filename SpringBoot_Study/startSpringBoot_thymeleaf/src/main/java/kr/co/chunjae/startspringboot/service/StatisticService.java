package kr.co.chunjae.startspringboot.service;

import kr.co.chunjae.startspringboot.repository.StatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticService {
    StatisticRepository statisticRepository;

    public void makeException() throws ArrayIndexOutOfBoundsException{
        throw new ArrayIndexOutOfBoundsException();
    }

    public void makeExceptionInRepository() throws ArrayIndexOutOfBoundsException{
        try {
            statisticRepository.makeExceptionInRepository();
        }catch (Exception e){
            throw new ArrayIndexOutOfBoundsException();
        }finally {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}

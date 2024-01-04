package kr.co.chunjae.service;

import kr.co.chunjae.domain.MemberDTO;
import kr.co.chunjae.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public boolean login(MemberDTO memberDTO) {
        int result = memberRepository.login(memberDTO);

        if(result == 1){
            return true;
        }else{
            return false;
        }
    }
}

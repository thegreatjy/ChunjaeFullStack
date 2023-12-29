package kr.co.chunjae.service;

import kr.co.chunjae.domain.MemberDTO;
import kr.co.chunjae.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Service
@Log4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public int save(MemberDTO memberDTO) {
        return memberRepository.save(memberDTO);
    }

    public boolean login(MemberDTO memberDTO) {
        MemberDTO result = memberRepository.login(memberDTO);

        if(result == null){ // 로그인 시도한 이메일, 비밀번호에 해당하는 member가 DB에 존재하지 않음
            return false;
        }else{
            return true;
        }
    }
}

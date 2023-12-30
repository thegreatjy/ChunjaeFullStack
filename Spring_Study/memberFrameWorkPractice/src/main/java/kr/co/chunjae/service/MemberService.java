package kr.co.chunjae.service;

import kr.co.chunjae.domain.MemberDTO;
import kr.co.chunjae.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean searchEmail(String email){
        int result = memberRepository.searchEmail(email);

        if(result == 1){    // 이메일이 이미 존재한다면 true
            return true;
        }else{  // 이메일이 존재하지 않음
            return false;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberDTO> memberDTOList = memberRepository.findAll();
        return memberDTOList;
    }

    public MemberDTO findById(int id) {
        MemberDTO memberDTO = memberRepository.findById(id);
        return memberDTO;
    }

    public void delete(int id) {
        memberRepository.delete(id);
    }

    public MemberDTO findByEmail(String email) {
        MemberDTO memberDTO = memberRepository.findByEmail(email);
        return memberDTO;
    }

    public boolean update(MemberDTO memberDTO) {
        int result = memberRepository.update(memberDTO);
        if(result == 1){
            return true;
        }else{
            return false;
        }
    }
}

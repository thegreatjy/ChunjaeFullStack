package kr.co.chunjae.service;

import kr.co.chunjae.dto.MemberDTO;
import kr.co.chunjae.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public int save(MemberDTO memberDTO){
        return memberRepository.save(memberDTO);
    }

    public boolean login(MemberDTO memberDTO) {
        MemberDTO loginMember = memberRepository.login(memberDTO);
        if(loginMember != null){
            return true;
        }else{
            return false;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberDTO> list = memberRepository.findAll();
        return list;
    }

    public MemberDTO findById(Long id) {
        MemberDTO memberDTO = memberRepository.findById(id);
        return memberDTO;
    }
}

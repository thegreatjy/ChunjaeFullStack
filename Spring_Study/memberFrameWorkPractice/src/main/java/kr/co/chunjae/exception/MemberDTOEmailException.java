package kr.co.chunjae.exception;

@SuppressWarnings("serial")
public class MemberDTOEmailException extends RuntimeException {
    private String email;

    public MemberDTOEmailException(String email){
        this.email = email;
    }
    public String getMemberDTOEmail(){
        return email;
    }
}
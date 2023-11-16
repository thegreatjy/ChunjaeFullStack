package membership;

import common.JDBConnect;

public class MemberDAO extends JDBConnect {
    // DB 연결하는 MemberDAO 객체 생성자
    public MemberDAO(String drive, String url, String id, String pw){
        super(drive, url, id, pw);
    }

    // uid, upass 갖는 회원 정보를 반환
    public MemberDTO getMemberDTO(String uid, String upass){
        MemberDTO dto = new MemberDTO();
        String query = "select * from member where id=? and pass=?";

        try{
            // 쿼리 실행
            psmt = con.prepareStatement(query);         // 동적 쿼리문 준비
            psmt.setString(1, uid);       // 쿼리문의 첫 번째 인파라미터에 값 설정
            psmt.setString(2, upass);     // 쿼리문의 두 번째 인파라미터에 값 설정
            rs = psmt.executeQuery();   // 쿼리문 실행. rs = 쿼리 결과

            // 결과 처리
            if(rs.next()){
                // 쿼리 결과인 회원 정보를 DTO 객체에 저장
                dto.setId(rs.getString("id"));
                dto.setPass(rs.getString("pass"));
                dto.setName(rs.getString(3));
                dto.setRegidate(rs.getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return dto;
    }
}

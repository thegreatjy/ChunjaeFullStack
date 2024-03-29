package servlet;

import membership.MemberDAO;
import membership.MemberDTO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/12Servlet/MemberAuth.mvc")
public class MemberAuth extends HttpServlet {
    private static final long serialVersionID = 1L;
    MemberDAO dao;

    @Override
    public void init() throws ServletException {

        // application 내장객체 얻기
        ServletContext application = this.getServletContext();

        // web.xml에서 DB연결 정보 얻기
        String driver = application.getInitParameter("MySQL_Driver");
        String connectUrl = application.getInitParameter("MySQL_URL");
        String oId = application.getInitParameter("MySQL_Id");
        String oPass = application.getInitParameter("MySQL_Pwd");

        // dao 생성
        dao = new MemberDAO(driver, connectUrl, oId, oPass);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 서블릿 초기화 매개변수에서 관리자 id 받기
        String admin_id = this.getInitParameter("admin_id");

        // 인증을 요청한 id, 패스워드
        String id = req.getParameter("id");
        String pass = req.getParameter("pass");

        // 회원 테이블에서 인증 요청한 id,password에 해당하는 회원 찾기
        MemberDTO memberDTO = dao.getMemberDTO(id, pass);

        // 찾은 회원의 이름에 따른 처리
        String memberName = memberDTO.getName();
        if(memberName != null){ // 일치하는 회원 찾음
            req.setAttribute("authMessage", memberName + "회원님 환영합니다.");
        }else{ // 일치하는 회원 없음
            if(admin_id != null && id.equals(admin_id)){    // 관리자
                req.setAttribute("authMessage", admin_id+"는 최고 관리자입니다.");
            }else { // 비회원
                req.setAttribute("authMessage", "귀하는 회원이 아닙니다.");
            }
        }

        // 다시 이동
        req.getRequestDispatcher("/12Servlet/MemberAuth.jsp").forward(req, resp);
    }

    @Override
    public void destroy(){
        dao.close();
    }
}

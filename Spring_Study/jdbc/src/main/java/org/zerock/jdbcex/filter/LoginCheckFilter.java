package org.zerock.jdbcex.filter;

import lombok.extern.log4j.Log4j2;
import org.zerock.jdbcex.dto.MemberDTO;
import org.zerock.jdbcex.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Log4j2
@WebFilter(urlPatterns = {"/todo/*"})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Login Check Filter");

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        HttpSession session = req.getSession();

        // 로그인 되어 있음
        if(session.getAttribute("loginInfo") != null){
            chain.doFilter(request, response);
            return;
        }

        // 로그인 되어 있지 않음
        Cookie cookie = findCookie(req.getCookies(), "remember-me");

        if(cookie == null){ // 이전에 자동 로그인이 되어 있지 않음
            resp.sendRedirect("/login");
            return;
        }

        // 자동 로그인 쿠키가 존재
        log.info("cookie는 존재하는 상황");
        // uuid
        String uuid = cookie.getValue();
        try{
            MemberDTO memberDTO = MemberService.INSTANCE.getByUUID(uuid);

            log.info("쿠키의 값으로 조회한 사용자 정보 : " + memberDTO);
            if(memberDTO == null){
                throw new Exception("Cookie value is not valid");
            }

            // 회원정보를 세션에 추가
            session.setAttribute("loginInfo", memberDTO);
            chain.doFilter(request, response);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("/login");
        }

        chain.doFilter(request, response);
    }

    private Cookie findCookie(Cookie[] cookies, String name){
        if(cookies == null || cookies.length == 0){
            return null;
        }

        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(ck -> ck.getName().equals(name))
                .findFirst();

        return result.isPresent() ? result.get() : null;
    }
}

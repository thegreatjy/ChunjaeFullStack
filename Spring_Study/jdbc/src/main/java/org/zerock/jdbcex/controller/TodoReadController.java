package org.zerock.jdbcex.controller;

import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.C;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name="todoReadController", value="/todo/read")
public class TodoReadController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Long tno = Long.parseLong(req.getParameter("tno"));
            TodoDTO todoDTO = todoService.get(tno);

            // 데이터 담기
            req.setAttribute("dto", todoDTO);

            // 쿠키 찾기 혹은 생성
            // 방문한 todo 목록을 가져온다.
            Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos");
            String todoListStr = viewTodoCookie.getValue();
            boolean exist = false;

            // tno가 방문한 todo 목록에 있는지 확인
            if(todoListStr != null && todoListStr.indexOf(tno + "-") >= 0){
                exist = true;
            }

            log.info("exist" + exist);

            // tno를 방문한 todo 목록에 추가
            if(!exist){
                todoListStr += tno + "-";
                viewTodoCookie.setValue(todoListStr);
                viewTodoCookie.setMaxAge(60*60*24);
                viewTodoCookie.setPath("/");
                resp.addCookie(viewTodoCookie);
            }

            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ServletException("read error");
        }
    }

    // cookies 배열에서 cookieName 이름의 쿠키 확인 후 반환
    private Cookie findCookie(Cookie[] cookies, String cookieName){
        Cookie targetCookie = null;

        // cookieName 이름의 쿠키 확인
        if(cookies != null && cookies.length > 0){
            for(Cookie cookie: cookies){
                if(cookie.getName().equals(cookieName)){
                    targetCookie = cookie;
                    break;
                }
            }
        }

        // cookieName 이름의 쿠키가 없다면 생성 후 반환
        if(targetCookie == null){
            targetCookie = new Cookie(cookieName, "");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60*60*24);
        }

        return targetCookie;
    }
}

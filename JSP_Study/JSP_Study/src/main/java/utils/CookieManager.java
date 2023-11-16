package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
    // 새로운 쿠키 생성
    public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime){
        Cookie cookie = new Cookie(cName, cValue);  // 쿠키 생성
        cookie.setPath("/");    // 경로 설정. 쿠키가 적용될 경로 설정
        cookie.setMaxAge(cTime);    // 유지 기간
        response.addCookie(cookie); // 응답 객체에 쿠키를 추가
    }

    // 쿠키의 이름을 이용하여 쿠키를 찾고 그 값을 반환
    public static String readCookie(HttpServletRequest request, String cName){
        String cookieValue = ""; // 반환값

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                String cookieName = c.getName();
                if(cookieName.equals(cName)){
                    cookieValue = c.getValue(); // 반환값 갱신
                }
            }
        }

        return cookieValue;
    }

    public static void deleteCookie(HttpServletResponse response, String cName){
        // 유지 기간이 0, 값은 빈 문자열인 쿠키 생성
        makeCookie(response, cName, "", 0);
    }

}

package utils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.PrintWriter;

public class JSFunction {
    // 메세지 알림창을 띄운 후, url로 이동한다.
    public static void alertLocation(String msg, String url, JspWriter out){
        // out 출력 스트림에 자바 스크립트 코드를 삽입한다.
        try{
            String script = ""
                    +"<script>"
                    + "alert('" + msg + "');"
                    + " location.href='" + url +"';"
                    + "</script>";
            out.println(script);
        }catch (Exception e){}
    }

    public static void alertLocation(HttpServletResponse resp, String msg, String url) {
        try {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            String script = "<script>"
                    + "    alert('" + msg + "');"
                    + "    location.href='" + url + "';"
                    + "</script>";
            writer.print(script);
            writer.flush();
            writer.close();
        }
        catch (Exception e) {}
    }

    // 메세지 알림창을 띄운 후, 이전 페이지로 돌아간다.
    public static void alertBack(HttpServletResponse resp, String msg) {
        try {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            String script = "<script>"
                    + "    alert('" + msg + "');"
                    + "    history.back();"
                    + "</script>";
            writer.print(script);
        }
        catch (Exception e) {}
    }
}

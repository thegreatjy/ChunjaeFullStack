package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/12Servlet/AnnoMapping.do")
public class AnnoMapping extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "@WebServlet으로 맵핑");
        req.getRequestDispatcher("/12Servlet/AnnoMapping.jsp").forward(req, resp);
    }
}

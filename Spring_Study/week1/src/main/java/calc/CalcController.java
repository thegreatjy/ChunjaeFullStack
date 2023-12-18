package calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="calcController", urlPatterns = "/calc/makeResult")
public class CalcController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        System.out.println(num1);
        System.out.println(num2);

        req.setAttribute("num1", num1);
        req.setAttribute("num2", num2);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/calc/calcResult.jsp");
        dispatcher.forward(req, resp);
    }
}

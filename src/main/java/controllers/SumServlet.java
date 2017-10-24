package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SumServlet", urlPatterns = "/sum")
public class SumServlet extends HttpServlet {
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        int a, b;
        a = Integer.parseInt(request.getParameter("num1"));
        b = Integer.parseInt(request.getParameter("num2"));

        request.setAttribute("sum", a + b);
        //sumServlet.doGet(request, response);
        request.getRequestDispatcher("sum.jsp").forward(request, response);
    }
}

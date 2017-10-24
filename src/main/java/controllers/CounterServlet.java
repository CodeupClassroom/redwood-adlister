package controllers;/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlets.CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int counter = 0;

    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        if (request.getParameter("reset") != null) {
            counter = 0;
        }

        counter++;

        request.setAttribute("counter", counter);
        request.getRequestDispatcher("counter.jsp").forward(request, response);
    }
}

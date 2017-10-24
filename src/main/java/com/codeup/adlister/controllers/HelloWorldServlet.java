package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "hello", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(
        HttpServletRequest request, //input
        HttpServletResponse response // output
    ) throws IOException, ServletException {
        String name = request.getParameter("name");
        String greeting;
        if (name == null || name.trim().isEmpty()) {
            greeting = "Hello, world!";
        } else {
            greeting = "Hello, " + name + "!";
        }
        request.setAttribute("greeting", greeting);
        request.getRequestDispatcher("hello-world.jsp").forward(request, response);
    }
}

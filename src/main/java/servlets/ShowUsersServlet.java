package servlets;/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
import Daos.DaoFactory;
import interfaces.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlets.ShowUsersServlet", urlPatterns = "/users")
public class ShowUsersServlet extends HttpServlet {
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        Users users = DaoFactory.getUsersDao(); //new Daos.UsersArrayList(); // DAO

        request.setAttribute("users", users.all()  /* Real collection (list) */);

        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}

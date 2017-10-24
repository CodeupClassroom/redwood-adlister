package com.codeup.adlister.controllers;/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

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
        Users users = DaoFactory.getUsersDao(); //new dao.UsersArrayList(); // DAO

        // Test to see if it inserts the user correctly.
        Long insertId = users.insert(new User("fmendozaro", "fer@codeup.com", "pass"));
        if(insertId == 0L){
            System.out.println("The user was not inserted");
        }else{
            System.out.println("The user was inserted and the id: " + insertId);
        }

        // This gets a particular user from the query string.
        Long id = Long.parseLong(request.getParameter("id"));
        System.out.println("id" + id);
        System.out.println(users.all( id ).get(0).getUsername());

        // This gets the list of all the users.
        request.setAttribute("users", users.all()  /* Real collection (list) */);

        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}

package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "servlets.ShowAdsServlet", urlPatterns = "/ad")
public class ShowAdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<Ad> ads = DaoFactory.getAdsDao().all();

        session.setAttribute("firstAd", ads.get(0).getTitle());

        request.setAttribute("ads", ads);

        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);
    }
}

package edu.matc.controller;


import edu.matc.persistence.UserData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * a simple servlet to search for salon users
 * @author mhill
 *
 */
@WebServlet(
        urlPatterns = {"/searchSalons"}
)
public class SearchUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserData userData  = new UserData();
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("users", userData.getUsersByLastName(req.getParameter("searchTerm")));
        } else {
            req.setAttribute("users", userData.getAllUsers());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }



}

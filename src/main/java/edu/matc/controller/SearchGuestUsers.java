package edu.matc.controller;


import edu.matc.persistence.GuestUserData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * a simple servlet to search for guest users
 * @author mhill
 *
 */
@WebServlet(
        urlPatterns = {"/searchGuests"}
)
public class SearchGuestUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GuestUserData guestUserData  = new GuestUserData();
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("users", guestUserData.getGuestUsersByLastName(req.getParameter("searchTerm")));
        } else {
            req.setAttribute("users", guestUserData.getAllGuestUsers());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }



}

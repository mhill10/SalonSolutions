package edu.matc.controller;


import edu.matc.persistence.UserDao;

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
        urlPatterns = {"/searchUsers"}
)
public class SearchUsers extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao  = new UserDao();
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("users", userDao.getByPropertyLike("userLastName", req.getParameter(("userSearchTerm"))));
        } else {
            req.setAttribute("users", userDao.getAllUsers());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }


}

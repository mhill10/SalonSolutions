package com.mysalonsolutions.controller;

import com.mysalonsolutions.entity.User;
import com.mysalonsolutions.persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;


/**
 * a simple servlet to search for salon users
 * @author mhill
 *
 */
@WebServlet(
        urlPatterns = {"/editUser"}
)
class EditUser extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao dao = new GenericDao(User.class);

        User selectedUser = (User) dao.getById(parseInt(req.getParameter("userId")));

        req.setAttribute("selectedUser", selectedUser);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/adminResources/editUser.jsp");
        dispatcher.forward(req, resp);
    }


}

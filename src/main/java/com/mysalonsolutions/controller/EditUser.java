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
 * a simple servlet to edit salon users
 * @author mhill
 *
 */
@WebServlet(
        urlPatterns = {"/editUser"}
)
class EditUser extends HttpServlet {

    /**
     * This method determines which user was selected to be edited and forwards the request accordingly
     *
     * @param req - the request to edit a specific user
     * @param resp - the result of the request
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

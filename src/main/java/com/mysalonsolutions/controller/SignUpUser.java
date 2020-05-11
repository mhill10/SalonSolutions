package com.mysalonsolutions.controller;

import com.mysalonsolutions.entity.Role;
import com.mysalonsolutions.entity.User;
import com.mysalonsolutions.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * a simple servlet to sign up a new salon user
 * @author mhill
 *
 */
@WebServlet(
        urlPatterns = {"/signUpUser"}
)
public class SignUpUser extends HttpServlet {

    private final String ROLE_NAME = "guest";

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Logger logger = LogManager.getLogger(this.getClass());

        // Check whether email address already in use
        GenericDao userDao = new GenericDao(User.class);
        List<User> userEmailMatched = userDao.getByPropertyEqual("userEmailAddress", req.getParameter("userEmailAddress"));

        // If email address already in use, set message and return to sign up page
        if (userEmailMatched.size() > 0) {
            req.setAttribute("messageError", "There is already an account with this email address.  Please use a different email address.");
            req.setAttribute("errorClass", "alert-danger");

            RequestDispatcher dispatcher = req.getRequestDispatcher("/signUp.jsp");
            dispatcher.forward(req, resp);

        // Check whether passwords match
        } else if (!req.getParameter("passwordOriginal").equals(req.getParameter("passwordConfirmation"))) {

            req.setAttribute("messageError", "Your passwords do not match.  Please Try Again.");
            req.setAttribute("errorClass", "alert-danger");

            String chosenEmailAddress = req.getParameter("userEmailAddress");
            req.setAttribute("userEmailAddress", chosenEmailAddress);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/signUp.jsp");
            dispatcher.forward(req, resp);

        // If email is unique and passwords match, then register new user
        } else {
            GenericDao roleDao = new GenericDao(Role.class);

            User user = new User();
            user.setUserEmailAddress(req.getParameter("userEmailAddress"));
            user.setUserPassword(req.getParameter("passwordOriginal"));
            user.setUserFirstName(req.getParameter("userFirstName"));
            user.setUserLastName(req.getParameter("userLastName"));

            logger.info("Creating New User: " + user);

            // Assign the role of "guest" to new user
            Role role = new com.mysalonsolutions.entity.Role();
            role.setUser(user);
            role.setRoleName(ROLE_NAME);
            role.setUserEmailAddress(req.getParameter("userEmailAddress"));


            userDao.insert(user);
            roleDao.insert(role);

            // Forward to registration success page
            RequestDispatcher dispatcher = req.getRequestDispatcher("/guestResources/registrationSuccess.jsp");
            dispatcher.forward(req, resp);
        }

    }

}
package com.mysalonsolutions.controller;

import com.mysalonsolutions.entity.Reservation;
import com.mysalonsolutions.entity.User;
import com.mysalonsolutions.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * a simple servlet to search for salon reservations
 * @author mhill
 *
 */
@WebServlet(
        urlPatterns = {"/viewAllReservations"}
)
public class ViewAllReservations extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Reservation.class);

        //TODO Add necessary logic here for retrieving all reservations!

        RequestDispatcher dispatcher = req.getRequestDispatcher("/adminResources/allReservations.jsp");
        dispatcher.forward(req, resp);
    }


}

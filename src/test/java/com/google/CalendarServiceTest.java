package com.google;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.mysalonsolutions.entity.ClientServices;
import com.mysalonsolutions.entity.Reservation;
import com.mysalonsolutions.persistence.GenericDao;
import com.mysalonsolutions.test.util.Database;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

import static java.time.ZonedDateTime.now;
import static org.junit.jupiter.api.Assertions.*;

class CalendarServiceTest {

    /** Global instance of default Time Zone **/
    String DEFAULT_TIME_ZONE = "America/Chicago";

    /** Declare remaining global instance variables **/
    CalendarService calendarService;
    Reservation reservation;
    EventDateTime startTime;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        calendarService = new CalendarService();
    }

    @Test
    void configure() {
        assertNotNull(calendarService.configure());
    }

    @Test
    void generateEndTime() {
        startTime = new EventDateTime();
        startTime.setTimeZone(DEFAULT_TIME_ZONE);
        startTime.setDateTime(DateTime.parseRfc3339("2020-04-17T09:00:00-05:00"));


        GenericDao clientServiceDao = new GenericDao(ClientServices.class);
        ClientServices clientServiceToDetermineEndTimeNeeded = (ClientServices) clientServiceDao.getById(1);
        EventDateTime returnedEndTime = calendarService.generateEndTime(clientServiceToDetermineEndTimeNeeded, startTime);
        assertNotNull(returnedEndTime);
        assertEquals("2020-04-17T09:45:00.000-05:00", returnedEndTime.getDateTime().toString());
    }

    @Test
    void createEvent() throws IOException {
        GenericDao reservationDao = new GenericDao(Reservation.class);
        reservation = (Reservation) reservationDao.getById(1);

        String reservationId = calendarService.createEvent(reservation);
        assertNotNull(reservationId);

    }

    @Test
    void getEvents() throws IOException {
        List<Event> upcomingEvents = calendarService.getEvents();
        assertNotNull(upcomingEvents);
        assertEquals(9, upcomingEvents.size());

    }
}
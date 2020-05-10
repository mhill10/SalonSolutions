package com.google;

import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.Events;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import static java.time.Year.now;

public class CalendarServiceTest {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Event event = new Event();
        Calendar service = null;

        event.setSummary("Calendar Testing");
        event.setLocation("US");
        event.setDescription("Bang Trim - Test Subject");

        // Adding Attendees for Event, unfortunately, does not work with service-account level authorization
//        ArrayList<EventAttendee> attendees = new ArrayList<EventAttendee>();
//        attendees.add(new EventAttendee().setEmail("mysalonsolutions@mysalonsolutions.iam.gserviceaccount.com"));
//        event.setAttendees(attendees);


        // set the number of days
        java.util.Calendar startCal = java.util.Calendar.getInstance();
        startCal.set(java.util.Calendar.YEAR, 2020);
        startCal.set(java.util.Calendar.MONTH, 4);
        startCal.set(java.util.Calendar.DATE, 17);
        startCal.set(java.util.Calendar.HOUR_OF_DAY, 9);
        startCal.set(java.util.Calendar.MINUTE, 0);
        Date startDate = startCal.getTime();

        java.util.Calendar endCal = java.util.Calendar.getInstance();
        endCal.set(java.util.Calendar.YEAR, 2020);
        endCal.set(java.util.Calendar.MONTH, 4);
        endCal.set(java.util.Calendar.DATE, 17);
        endCal.set(java.util.Calendar.HOUR_OF_DAY, 9);
        endCal.set(java.util.Calendar.MINUTE, 45);
        Date endDate = endCal.getTime();


        DateTime start = new DateTime(startDate);
        event.setStart(new EventDateTime().setDateTime(start));
        DateTime end = new DateTime(endDate);
        event.setEnd(new EventDateTime().setDateTime(end));


        service = new CalendarService().configure();
        Event createdEvent = service.events().insert("thehandyhairdresser@gmail.com", event).execute();

        String newEventId = createdEvent.getId();

        System.out.println("Data is :" + newEventId + ", " + createdEvent.getDescription());

        CalendarServiceTest newService = new CalendarServiceTest();

        List<Event> upcomingEvents = newService.getEvents();

        System.out.println("Upcoming Events: " + upcomingEvents);

//        Working Delete Function - USE THIS!!!
//        service.events().delete("thehandyhairdresser@gmail.com", "q0s794kk1v6om3j7t0guq9t9t4").execute();

        // UPDATE EVENT TEST
        Event updatedEvent = new Event();

        updatedEvent.setSummary("Update Test");
        updatedEvent.setLocation("US");
        updatedEvent.setDescription("Foil-Color-Style - Same Test Subject");

        // set the number of days
        java.util.Calendar updatedStartCal = java.util.Calendar.getInstance();
        updatedStartCal.set(java.util.Calendar.YEAR, 2020);
        updatedStartCal.set(java.util.Calendar.MONTH, 4);
        updatedStartCal.set(java.util.Calendar.DATE, 17);
        updatedStartCal.set(java.util.Calendar.HOUR_OF_DAY, 12);
        updatedStartCal.set(java.util.Calendar.MINUTE, 0);
        Date updatedStartDate = updatedStartCal.getTime();

        java.util.Calendar updatedEndCal = java.util.Calendar.getInstance();
        updatedEndCal.set(java.util.Calendar.YEAR, 2020);
        updatedEndCal.set(java.util.Calendar.MONTH, 4);
        updatedEndCal.set(java.util.Calendar.DATE, 17);
        updatedEndCal.set(java.util.Calendar.HOUR_OF_DAY, 12);
        updatedEndCal.set(java.util.Calendar.MINUTE, 45);
        Date updatedEndDate = updatedEndCal.getTime();


        DateTime updatedStart = new DateTime(updatedStartDate);
        updatedEvent.setStart(new EventDateTime().setDateTime(updatedStart));
        DateTime updatedEnd = new DateTime(updatedEndDate);
        updatedEvent.setEnd(new EventDateTime().setDateTime(updatedEnd));
        service.events().patch("thehandyhairdresser@gmail.com", newEventId, updatedEvent);


        List<Event> updatedUpcomingEvents = newService.getEvents();

    }

    public List<Event> getEvents() throws IOException {

        Calendar service = new CalendarService().configure();

        DateTime now = new DateTime(System.currentTimeMillis());
        Events events = service.events().list("thehandyhairdresser@gmail.com")
                .setMaxResults(15)
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
        List<Event> items = events.getItems();
        if (items.isEmpty()) {
            System.out.println("No upcoming events found.");
        } else {
            System.out.println("Upcoming events");
            for (Event event : items) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                System.out.printf("%s (%s)\n", event.getSummary(), start);
            }

        }


        return items;
    }


}
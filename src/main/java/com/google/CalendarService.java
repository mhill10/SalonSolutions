package com.google;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;
import com.google.common.io.Files;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.mysalonsolutions.entity.Event_Id;

import java.util.Collections;
import java.util.List;


/**
 * @author Yaniv Inbar and Matthew Hill
 */
public class CalendarService {

    /**
     * Name of application, as implemented for demo. Suggested format from Google is "MyCompany-ProductName/1.0".
     */
    private static final String APPLICATION_NAME = "HandyHairdresser-MySalonSolutions/1.0";

    /** Calendar Id of private Gmail Calendar being accessed via Service Account **/
    private static final String CALENDAR_ID = "thehandyhairdresser@gmail.com";

    /** E-mail address of the service account. */
    private static final String SERVICE_ACCOUNT_EMAIL = "mysalonsolutions@mysalonsolutions.iam.gserviceaccount.com";

    /** Credentials Path **/
    private static final String CREDENTIALS_PATH = "/mysalonsolutions-0c004414cf68.p12";

    /** Default Location **/
    private static final String DEFAULT_LOCATION = "US";

    /** Global instance of the HTTP transport. */
    private static HttpTransport httpTransport;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    /** Global instance of maximum results to return **/
    private static final int MAX_RESULTS = 30;

    /** Global instance of default Time Zone **/
    private static final String DEFAULT_TIME_ZONE = "America/Chicago";


    public  Calendar configure() {
        try {
            try {
                httpTransport = new NetHttpTransport();
                // check for valid setup
                URL loc = this.getClass().getResource(CREDENTIALS_PATH);
                String path = loc.getPath();
                File file = new File(path);
                String credentialsContent = Files.readFirstLine(file, Charset.defaultCharset());
                if (credentialsContent.startsWith("Please")) {
                    System.err.println(credentialsContent);
                    System.exit(1);
                }
                // service account credential (uncomment setServiceAccountUser for domain-wide delegation)
                GoogleCredential credential = new GoogleCredential.Builder()
                        .setTransport(httpTransport)
                        .setJsonFactory(JSON_FACTORY)
                        .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
                        .setServiceAccountPrivateKeyFromP12File(file)
                        .setServiceAccountScopes(Collections.singleton(CalendarScopes.CALENDAR))
                        .build();


                Calendar client = new com.google.api.services.calendar.Calendar.Builder(
                        httpTransport, JSON_FACTORY, credential)
                        .setApplicationName(APPLICATION_NAME).build();
                System.out.println("Client : " + client);
                return client;

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.exit(1);
        return null;
    }

    public Event_Id generateEventId() {

        return new Event_Id();
    }

    public EventDateTime generateEndTime(int userId, int serviceId, EventDateTime eventDateTime) {
        EventDateTime endTime = new EventDateTime();
        endTime.setTimeZone(DEFAULT_TIME_ZONE);





    }


    public String createEvent(int userId, int serviceId, EventDateTime eventDateTime, String eventSummary, String eventDescription) {

        Event event = new Event();
        Event_Id eventIdToInsert = generateEventId();
        event.setId(String.valueOf(eventIdToInsert));
        Calendar service = null;
        event.setLocation(DEFAULT_LOCATION);
        event.setSummary(eventSummary);
        event.setDescription(eventDescription);
        event.setStart(eventDateTime);

        event.setEnd(generateEndTime(userId, serviceId, eventDateTime));

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
        Event createdEvent = service.events().insert(CALENDAR_ID, event).execute();

        String newEventId = createdEvent.getId();

        System.out.println("Data is :" + newEventId + ", " + createdEvent.getDescription());

        CalendarServiceTest newService = new CalendarServiceTest();

        List<Event> upcomingEvents = newService.getEvents();
//
//        System.out.println("Upcoming Events: " + upcomingEvents);

//        Working Delete Function - USE THIS!!!
//        service.events().delete("thehandyhairdresser@gmail.com", newEventId).execute();

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
                .setMaxResults(MAX_RESULTS)
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
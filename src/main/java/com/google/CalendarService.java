package com.google;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.temporal.ChronoUnit;
import java.util.*;
import com.google.api.client.util.DateTime;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;
import com.google.common.io.Files;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.mysalonsolutions.entity.*;
import com.mysalonsolutions.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import java.util.Collections;
import java.util.List;


/**
 * @author Yaniv Inbar (of Google) and Matthew Hill
 *
 * This Class will configure a Calendar Object with predetermined credentials for the Stylist's
 * Google Calendar that is shared with the linked "Google Service Account" which the webapp
 * Salon Solutions is authorized to use, in order to add and delete events from Stylist's
 * private aforementioned Google Calendar.  This class will also be able to add and delete said
 * events using same aforementioned credentials.
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

    /** Logger for this class **/
    final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Configures a Calendar Object, loads credentials for service account, identifies Calendar to be modified,
     *
     * @return client - the client Calendar Object
     */
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
                    logger.error(credentialsContent);
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
               logger.debug("Client : " + client);
                return client;

            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.exit(1);
        return null;
    }


    /**
     * Determines the time a service will end, based on start time criteria specified by guest,
     * as well as time the service will likely take (specified by the Stylist)
     *
     * @param clientServiceToSchedule - the service requested by the guest to be scheduled
     * @param eventStartDateTime - the time the guest desires service to begin
     * @return - the ending time for the service
     */
    public EventDateTime generateEndTime(ClientServices clientServiceToSchedule, EventDateTime eventStartDateTime) {
        EventDateTime endTime = new EventDateTime();
        endTime.setTimeZone(DEFAULT_TIME_ZONE);

        int visitDurationInMinutes = clientServiceToSchedule.getServiceDefaultStartDuration()
                + clientServiceToSchedule.getServiceDefaultProcessDuration()
                + clientServiceToSchedule.getServiceDefaultEndDuration();


        DateTime endTimeToSchedule = new DateTime(eventStartDateTime.getDateTime().getValue() + (long) visitDurationInMinutes * 60L * 1000L);
        endTime.setDateTime(endTimeToSchedule);

        return endTime;
    }


    /**
     * Creates an event on Stylist's Google Calendar via the authentication method (configure()) above,
     * using information specified by user and stylist to determine start and end times
     *
     * @param reservationToMake - the reservation details already present within MySQLDatabase to be parsed into Google Readable format for scheduling
     * @return
     * @throws IOException
     */
    public String createEvent(Reservation reservationToMake) throws IOException {

        // Declare Local Variables
        Event event = new Event();
        EventDateTime eventDateTime = new EventDateTime();
        Calendar service = null;

        // Assign default values accordingly
        event.setLocation(DEFAULT_LOCATION);
        eventDateTime.setTimeZone(DEFAULT_TIME_ZONE);
        eventDateTime.setDateTime(reservationToMake.getResDateTime());

        // Fetch User Info
        GenericDao userDao = new GenericDao(User.class);
        User userToSchedule = (User) userDao.getById(reservationToMake.getResSalonId());

        // Fetch Info about the amount of time the service takes for this particular client
        GenericDao clientServicesDao = new GenericDao(ClientServices.class);
        ClientServices clientServiceToSchedule = (ClientServices) clientServicesDao.getById(reservationToMake.getResServiceId());

        // Fetch Info about the Service - Its Name and Description
        GenericDao serviceDao = new GenericDao(Service.class);
        Service serviceToSchedule = (Service) serviceDao.getById(clientServiceToSchedule.getAllServiceId());

        String eventSummary = userToSchedule.getUserFirstName() + ", " + userToSchedule.getUserLastName() + ": "
                + serviceToSchedule.getServiceName();

        // Set event Summary (visible in Google Calendar overview) and Set Description (visible in single Event view)
        event.setSummary(eventSummary);
        event.setDescription(serviceToSchedule.getServiceDescription());

        // Set start and end times
        event.setStart(eventDateTime);
        event.setEnd(generateEndTime(clientServiceToSchedule, eventDateTime));

        // Configure Calendar Service Object with credentials
        service = new CalendarService().configure();
        Event createdEvent = service.events().insert(CALENDAR_ID, event).execute();

        // Receive Google Confirmation String
        String newEventId = createdEvent.getId();
        logger.debug("Data is :" + newEventId + ", " + createdEvent.getSummary());

        // Save Google Confirmation String alongside Reservation in MySQL
        GenericDao reservationDao = new GenericDao(Reservation.class);
        Reservation scheduledReservation = reservationToMake;
        scheduledReservation.setGoogleConfirmation(newEventId);
        reservationDao.saveOrUpdate(scheduledReservation);

        return newEventId;
    }


    /**
     * This method will fetch the next events on the calendar (determined by value of MAX_RESULTS constant)
     *
     * @return items - the list of Events coming up on the Stylist's Google calendar
     * @throws IOException
     */
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
            logger.debug("No upcoming events found.");
        } else {
            logger.debug("Upcoming events");
            for (Event event : items) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                logger.debug("%s (%s)\n", event.getSummary(), start);
            }

        }

        return items;
    }
}
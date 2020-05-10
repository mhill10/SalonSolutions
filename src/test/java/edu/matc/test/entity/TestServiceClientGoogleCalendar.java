//package edu.matc.test.entity;
//
//        import com.fasterxml.jackson.databind.ObjectMapper;
//        import com.google.UpcomingEventsItem;
//        import com.google.api.services.calendar.model.Event;
//        import com.google.gson.Gson;
//        import org.junit.Test;
//        import com.google.*;
//        import javax.ws.rs.client.*;
//        import javax.ws.rs.core.MediaType;
//        import java.util.List;
//
//        import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TestServiceClientGoogleCalendar {
//
//    @Test
//    public void testGoogleCalendarJSON() throws Exception {
//        CalendarQuickstart quickstartCalendar = new CalendarQuickstart();
//        List<Event> nextTenEvents = CalendarQuickstart.getEvents();
//        String parsedEvents = new Gson().toJson(nextTenEvents);
//
//        System.out.println("Parsed Events: \n " + parsedEvents);
//
//        //ObjectMapper mapper = new ObjectMapper();
//        //UpcomingEventsItem calendarItems = mapper.readValue(parsedEvents, UpcomingEventsItem.class);
//        //assertEquals("???", parsedEvents);
//
//        String parsedEventsBest = parsedEvents.substring(1, parsedEvents.length() -1);
//
//        ObjectMapper mapper = new ObjectMapper();
//        BestResponseClass nextTenEventsResponse = mapper.readValue(parsedEventsBest, BestResponseClass.class);
//        String expectedCreator = "Creator{displayName = 'Matthew Hill',self = 'true',email = 'matthewbhill@gmail.com'}";
//        assertEquals(expectedCreator, (nextTenEventsResponse.getCreator().toString()));
//
//    }
//}
//
//

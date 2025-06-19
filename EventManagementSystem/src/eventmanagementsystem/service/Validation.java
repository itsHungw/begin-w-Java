package eventmanagementsystem.service;

import eventmanagementsystem.data.Event;
import eventmanagementsystem.data.Organizer;
import eventmanagementsystem.data.Venue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Validation {
    public static boolean isUniqueEventId(int eventID, List<Event> events) {
        for (Event event : events) {
            if (event.getEventID() == eventID) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidName(String eventName) {
        return eventName.length() > 3 && eventName != null;
    }

    public static boolean isOrganizerIdExist(int organizerID, List<Organizer> organizers) {
        for (Organizer org : organizers) {
            if (org.getOrganizerID() == organizerID) {
                return true;
            }
        }
        return false;
    }
    public static boolean isVenueIdExist(int venueID, List<Venue> venues) {
        for (Venue org : venues) {
            if (org.getVenueID() == venueID) {
                return true;
            }
        }
        return false;
    }
    public static boolean isValidDate(String startDate, String endDate){
        try {
            DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate start = LocalDate.parse(startDate, dft);
            LocalDate end = LocalDate.parse(endDate, dft);
            return end.isAfter(start);
        }catch (DateTimeParseException e){
            return false;
        }catch (NullPointerException e) {
            return false;
        }
    }
    public static boolean isAttendeesPositive(int expectedAttendees){
        return expectedAttendees > 0;
    }
    public static String validateEvent(Event event, List<Event> events, List<Organizer> organizers, List<Venue> venues) {
        if (!isUniqueEventId(event.getEventID(), events)) {
            return "Error :ID event already exist";
        }
        if (!isValidName(event.getEventName())) {
            return "Error :Name must at least 3 character long!";
        }
        if (!isOrganizerIdExist(event.getOrganizerID(), organizers)) {
            return "Error :ID of Organizer not exist!";
        }
        if (!isVenueIdExist(event.getVenueID(), venues)) {
            return "Error :ID of Venues not exist!";
        }
        if (!isValidDate(event.getStartDate(), event.getEndDate())){
            return "Error :Invalid date format or START date is AFTER END date!";
        }
        if (!isAttendeesPositive(event.getExpectedAttendees())){
            return "Error :Attendees must greater than 0!";
        }
        return null;
    }
}


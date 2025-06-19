package eventmanagementsystem.service;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import eventmanagementsystem.data.Event;
import eventmanagementsystem.data.Organizer;
import eventmanagementsystem.data.Venue;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * @author vinhu
 */
public class EventManagementSystem implements EventOperations {
    Scanner sc = new Scanner(System.in);
    List<Event> events = new ArrayList<>();
    List<Organizer> organizers = new ArrayList<>();
    List<Venue> venues = new ArrayList<>();

    public void initialData() {
        //Initsl Organizers
        organizers.add(new Organizer(1, "EventPro Solutions"));
        organizers.add(new Organizer(2, "Green Light Agency"));
        organizers.add(new Organizer(3, "University Youth Union"));
        organizers.add(new Organizer(4, "TechWorld Group"));
        organizers.add(new Organizer(5, "Community Council"));
        organizers.add(new Organizer(6, "City Entertainment Co."));
        organizers.add(new Organizer(7, "Art & Culture Center"));

        //Initial Venues
        venues.add(new Venue(1, "Grand Hall"));
        venues.add(new Venue(2, "City Conference Center"));
        venues.add(new Venue(3, "Open Air Park"));
        venues.add(new Venue(4, "Exhibition Pavilion"));
        venues.add(new Venue(5, "Downtown Auditorium"));
        venues.add(new Venue(6, "Community House"));
        venues.add(new Venue(7, "University Main Hall"));
    }


    @Override
    public void creatEvent(Event event) {
        String validationError = Validation.validateEvent(event, events, organizers, venues);
        if (validationError != null){
            System.out.println(validationError);
            return;
        }
        events.add(event);
        System.out.println("Create event successfully");
    }

    @Override
    public void updateEvent(int eventID, Event event) {
        Event exsitEvent = searchEventByID(eventID);
        if (exsitEvent == null) {
            System.out.println("Event not found!");
            return;
        }
        System.out.println("Left Enter to keep the value");
        try {
            System.out.print("Enter new Event ID: ");
            String IdEvent = sc.nextLine();
            if (!IdEvent.isEmpty()) {
                int newID = Integer.parseInt(IdEvent);
                if (Validation.isUniqueEventId(newID, events) || newID == eventID) {
                    exsitEvent.setEventID(newID);
                } else {
                    System.out.println("Error :new ID already exist");
                    return;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid type of input");
        }

        System.out.print("Enter new Event name: ");
        String newName = sc.nextLine();
        if (!newName.isEmpty()) {
            if (Validation.isValidName(newName)) {
                exsitEvent.setEventName(newName);
            } else {
                System.out.println("Error: Name event must long above 3 character!");
                return;
            }
        }

        try {
            System.out.print("Enter new Organizer ID of Event : ");
            String newIdO = sc.nextLine();
            if (!newIdO.isEmpty()) {
                int newIdOrg = Integer.parseInt(newIdO);
                if (!Validation.isOrganizerIdExist(newIdOrg, organizers)) {
                    exsitEvent.setOrganizerID(newIdOrg);
                } else
                    System.out.println("Error: ID of Organizer does not exist");
            }

            System.out.print("Enter new Venue ID of Event : ");
            String newIdVen = sc.nextLine();
            if (!newIdVen.isEmpty()) {
                int newIdVenue = Integer.parseInt(newIdVen);
                if (!Validation.isVenueIdExist(newIdVenue, venues)) {
                    exsitEvent.setVenueID(newIdVenue);
                } else
                    System.out.println("Error: ID of Venue does not exist");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid type of input");
        }

        System.out.print("Enter new start date (yyyy-MM-dd, Enter to keep the value): ");
        String newStartDate = sc.nextLine();
        if (newStartDate.isEmpty())
            newStartDate = exsitEvent.getStartDate();
        System.out.print("Nhập ngày kết thúc mới (yyyy-MM-dd, nhấn Enter để giữ nguyên): ");
        String newEndDate = sc.nextLine();
        if (newEndDate.isEmpty())
            newEndDate = exsitEvent.getEndDate();
        if (Validation.isValidDate(newStartDate, newEndDate)) {
            exsitEvent.setStartDate(newStartDate);
            exsitEvent.setEndDate(newEndDate);
        } else {
            System.out.println("Error: Invalid format day or start date after end date!");
        }

        try {
            System.out.print("Enter new Expected Attendees of Event : ");
            String newAttend = sc.nextLine();
            if (!newAttend.isEmpty()) {
                int newAttendees = Integer.parseInt(newAttend);
                if (Validation.isAttendeesPositive(newAttendees))
                    exsitEvent.setExpectedAttendees(newAttendees);
                else
                    System.out.println("Attendees must be greater than 0");
            }
        } catch (NumberFormatException e) {
            System.out.println("Attendees must be number!");
        }

    }

    @Override
    public boolean deleteEvent(int eventID) {
        System.out.println("1. Yes");
        System.out.println("2. No");
        String choice = sc.nextLine();
        do {
            switch (choice.toLowerCase()) {
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    System.out.println("Invalid input!");
            }
        } while (choice.equalsIgnoreCase("n"));
        return true;
    }

    public void deleteEvent() {
        try {
            System.out.print("Enter ID event you want to  delete: ");
            int eventID = Integer.parseInt(sc.nextLine());
            Event event = searchEventByID(eventID);
            System.out.println("Do you want to DELETE event " + event.getEventName() + " with ID: " + event.getEventID() + " ?");
            if (deleteEvent(eventID)) {
                events.remove(event);
            } else System.out.println("Exit DELETE!..");
            System.out.println("Deleted successfully..");
        } catch (NumberFormatException e) {
            System.out.println("ID input must be number!..");
        }

    }

    @Override
    public List<Event> findEventsByName(String name) {
        return events.stream().filter((e -> e.getEventName().toLowerCase().contains(name)))
                .sorted(Comparator.comparing(Event::getEventName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> listAllEvents() {
        return events.stream().sorted(Comparator.comparing(Event::getEventName).thenComparing(Event::getEventID)).collect(Collectors.toList());

    }

    public Event searchEventByID(int eventID) {
        for (Event event : events) {
            if (eventID == event.getEventID())
                return event;
        }
        return null;
    }

    public Organizer findOrganizerByID(int organizerID) {
        for (Organizer organizer : organizers) {
            if (organizerID == organizer.getOrganizerID())
                return organizer;
        }
        return null;
    }

    public Venue findVenueByID(int venueID) {
        for (Venue venue : venues) {
            if (venueID == venue.getVenueID())
                return venue;
        }
        return null;
    }

    public List<Organizer> getOrganizers() {
        return organizers;
    }

    public List<Venue> getVenues() {
        return venues;
    }
    //public ArrayList<Event> getEvents(){return events;}
}

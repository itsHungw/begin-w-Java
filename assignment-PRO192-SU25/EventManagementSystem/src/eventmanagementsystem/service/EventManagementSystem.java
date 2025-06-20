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
    public void creatEvent() {
        int organizerID;
        int venueID;
        while (true) {
            try {
                System.out.println("\nAvailable Organizers:");
                for (Organizer org : getOrganizers()) {
                    System.out.println(org);
                }
                System.out.print("Enter organizer ID you want to choose: ");
                organizerID = Integer.parseInt(sc.nextLine());
                if (!Validation.isOrganizerIdExist(organizerID, organizers)) {
                    System.out.println("\nError: ID of Organizer does not exist\n");
                    continue;
                }
                System.out.println("\nAvailable Venues:");
                for (Venue ven : getVenues()) {
                    System.out.println(ven);
                }
                System.out.print("Enter venue ID you want to choose: ");
                venueID = Integer.parseInt(sc.nextLine());
                if (!Validation.isVenueIdExist(venueID, venues)) {
                    System.out.println("\nError: ID of Venue does not exist\n");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int eventID;
        while (true) {
            try {
                System.out.print("Enter event ID: ");
                eventID = Integer.parseInt(sc.nextLine());
                if (!Validation.isUniqueEventId(eventID, events)) {
                    System.out.println("Error: ID of Event already exist");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: event ID must be number! Please try again.");
                ;
            }
        }
        String eventName;
        while (true) {
            System.out.print("Enter event Name: ");
            eventName = sc.nextLine();
            if (!Validation.isValidName(eventName)) {
                System.out.println("Error: Event name must be longer than 3 characters! Please try again.");
                continue;
            }
            break;
        }
        String startDate;
        String endDate;
        while (true) {
            System.out.print("Enter start Date (YYYY-MM-DD): ");
            startDate = sc.nextLine();
            System.out.print("Enter end Date (YYYY-MM-DD): ");
            endDate = sc.nextLine();
            if (!Validation.isValidDate(startDate, endDate)) {
                System.out.println("Error: Invalid format of start date and end date! Please try again.");
                continue;
            }
            break;
        }

        int expectedAttendees;
        while (true) {
            try {
                System.out.print("Enter expected Attendees: ");
                expectedAttendees = Integer.parseInt(sc.nextLine());
                if (!Validation.isAttendeesPositive(expectedAttendees)) {
                    System.out.println("Error: Attendees must be greater than 0! Please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Input must be number! Please try again.");
            }
        }

        Event event = new Event(eventID, eventName, organizerID, venueID, startDate, endDate, expectedAttendees);

        String validationError = Validation.validateEvent(event, events, organizers, venues);
        if (validationError != null) {
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
        while (true) {
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
                }break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid type of input. Try again.!");
            }
        }

        while (true) {
            System.out.print("Enter new Event name: ");
            String newName = sc.nextLine();
            if (!newName.isEmpty()) {
                if (Validation.isValidName(newName)) {
                    exsitEvent.setEventName(newName);
                    break;
                } else {
                    System.out.println("Error: Name event must long above 3 character!");
                }
            }break;
        }

        while (true) {
            try {
                System.out.print("Enter new Organizer ID of Event : ");
                String newIdO = sc.nextLine();
                if (!newIdO.isEmpty()) {
                    int newIdOrg = Integer.parseInt(newIdO);
                    if (Validation.isOrganizerIdExist(newIdOrg, organizers)) {
                        exsitEvent.setOrganizerID(newIdOrg);
                        break;
                    } else
                        System.out.println("Error: ID of Organizer does not exist");
                }break;
            } catch (NumberFormatException e) {
                System.out.println("ID MUST BE NUMBER. Try again.!");
            }
        }

        while (true) {
            try {
                System.out.print("Enter new Venue ID of Event : ");
                String newIdVen = sc.nextLine();
                if (!newIdVen.isEmpty()) {
                    int newIdVenue = Integer.parseInt(newIdVen);
                    if (Validation.isVenueIdExist(newIdVenue, venues)) {
                        exsitEvent.setVenueID(newIdVenue);
                        break;
                    } else
                        System.out.println("Error: ID of Venue does not exist");
                }break;
            } catch (NumberFormatException e) {
                System.out.println("ID MUST BE NUMBER. Try again.!");
            }
        }

        while (true) {
            System.out.print("Enter new START date (yyyy-MM-dd, Enter to keep the value): ");
            String newStartDate = sc.nextLine();
            if (newStartDate.isEmpty())
                newStartDate = exsitEvent.getStartDate();
            System.out.print("Enter new END date (yyyy-MM-dd, Enter to keep the value): ");
            String newEndDate = sc.nextLine();
            if (newEndDate.isEmpty())
                newEndDate = exsitEvent.getEndDate();
            if (Validation.isValidDate(newStartDate, newEndDate)) {
                exsitEvent.setStartDate(newStartDate);
                exsitEvent.setEndDate(newEndDate);
                break;
            } else {
                System.out.println("Error: Invalid format day or start date after end date!");
            }
        }

    while (true) {
        try {
            System.out.print("Enter new Expected Attendees of Event : ");
            String newAttend = sc.nextLine();
            if (!newAttend.isEmpty()) {
                int newAttendees = Integer.parseInt(newAttend);
                if (Validation.isAttendeesPositive(newAttendees))
                    exsitEvent.setExpectedAttendees(newAttendees);
                else
                    System.out.println("Attendees must be greater than 0");
            }break;
        } catch (NumberFormatException e) {
            System.out.println("Attendees must be number!");
        }
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


    public void main(String[] args) {
        initialData();
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    creatEvent();
                    break;
                case "2":
                    System.out.printf("|%-10s|%-20s|%-25s|%-25s|%-15s|%-15s|%-24s\n",
                            "Event ID", "Event Name", "Organizer", "Venue", "Start Date", "End Date", "Expected Attendance");
                    if (listAllEvents().isEmpty()) {
                        System.out.println("No events Available!");
                    }
                    for (Event x : listAllEvents())
                        System.out.printf("|%-10s|%-20s|%-25s|%-25s|%-15s|%-15s|%-24s\n",
                                x.getEventID(),
                                x.getEventName(),
                                findOrganizerByID(x.getOrganizerID()).getOrganizerName(),
                                findVenueByID(x.getVenueID()).getVenueName(),
                                x.getStartDate(),
                                x.getEndDate(),
                                x.getExpectedAttendees());
                    break;
                case "3":
                    while (true) {
                        try {
                            System.out.print("Enter ID Event you want to UPDATE: ");
                            int id = Integer.parseInt(sc.nextLine());
                            updateEvent(id, searchEventByID(id));
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Error! ID must be a number! Try again.!");
                        }
                    }
                    break;
                case "4":
                    while (true) {
                        try {
                            System.out.print("Enter ID event you want to  delete: ");
                            int eventID = Integer.parseInt(sc.nextLine());
                            Event event = searchEventByID(eventID);

                            System.out.println("Do you want to DELETE event " + event.getEventName() + " with ID: " + event.getEventID() + " ?");
                            if (deleteEvent(eventID)) {
                                events.remove(event);
                                break;
                            } else System.out.println("Exiting DELETE feature!..");
                            System.out.println("Deleted successfully..");
                        } catch (NumberFormatException e) {
                            System.out.println("ID input must be number!..");
                        }catch (NullPointerException e) {
                            System.out.println("Event not found!");
                            break;
                        }
                    }
                    break;
                case "5":
                    System.out.print("Enter name event you want to find: ");
                    String name = sc.nextLine();
                    if (!(findEventsByName(name).isEmpty())) {
                        for (Event eventsFounded : findEventsByName(name)) {
                            System.out.println(eventsFounded);
                        }
                    }else System.out.println("Error! Event not found!");

                    break;
                case "7":
                    System.out.println("Thank you for using Event Management System!");
                    System.out.println("Exiting!...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println("\nPress Enter to continue...");
            sc.nextLine();
        }

    }


    private static void displayMenu() {
        System.out.println("\n========== EVENT MANAGEMENT SYSTEM ==========");
        System.out.println("1. Create Event");
        System.out.println("2. List All Events ");
        System.out.println("3. Update Event");
        System.out.println("4. Delete Event");
        System.out.println("5. Search Events by Name");
        System.out.println("7. Exit");
        System.out.println("=============================================");
    }
}



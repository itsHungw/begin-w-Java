/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import eventmanagementsystem.data.Event;
import eventmanagementsystem.data.Organizer;
import eventmanagementsystem.data.Venue;
import eventmanagementsystem.service.EventManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author vinhu
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final EventManagementSystem eventManagementSystem = new EventManagementSystem();


    public static void main(String[] args) {
        eventManagementSystem.initialData();
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    creatEvent();
                    break;
                case "2":
                    displayAllEvent();
                    break;
                case "3":
                    updateEvent();

                    break;
                case "4":
                    deleteEvent();
                    break;
                case "5":
                    findEventByName();
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
        System.out.println("2. Update Event");
        System.out.println("3. Delete Event");
        System.out.println("4. Search Events by Name");
        System.out.println("5. List All Events");
        System.out.println("6. Display All Organizers");
        System.out.println("7. Display All Venues");
        System.out.println("8. Add New Organizer");
        System.out.println("9. Add New Venue");
        System.out.println("0. Exit");
        System.out.println("=============================================");
    }

    public static void creatEvent() {
        try {
            System.out.println("Available Organizers: ");
            for (Organizer org : eventManagementSystem.getOrganizers()) {
                System.out.println(org);
            }
            System.out.print("Enter organizer ID you want to choose: ");
            int organizerID = Integer.parseInt(sc.nextLine());

            System.out.println("Available Venues: ");
            for (Venue ven : eventManagementSystem.getVenues()) {
                System.out.println(ven);
            }
            System.out.print("Enter venue ID you want to choose: ");
            int venueID = Integer.parseInt(sc.nextLine());

            System.out.print("Enter event ID: ");
            int eventID = Integer.parseInt(sc.nextLine());
            System.out.print("Enter event Name: ");
            String eventName = sc.nextLine();
            System.out.print("Enter start Date: ");
            String startDate = sc.nextLine();
            System.out.print("Enter end Date: ");
            String endDate = sc.nextLine();
            System.out.print("Enter expected Attendees: ");
            int expectedAttendees = Integer.parseInt(sc.nextLine());

            Event event = new Event(eventID, eventName, organizerID, venueID, startDate, endDate, expectedAttendees);
            eventManagementSystem.creatEvent(event);
        } catch (NumberFormatException e) {
            System.out.println("Invalid type of input!!!");
        }
    }

    public static void displayAllEvent() {
        System.out.printf("|%-10s|%-20s|%-25s|%-25s|%-15s|%-15s|%-24s\n",
                "Event ID", "Event Name", "Organizer", "Venue", "Start Date", "End Date", "Expected Attendance");
        for (Event x : eventManagementSystem.listAllEvents())
            System.out.printf("|%-10s|%-20s|%-25s|%-25s|%-15s|%-15s|%-24s\n",
                    x.getEventID(),
                    x.getEventName(),
                    eventManagementSystem.findOrganizerByID(x.getOrganizerID()).getOrganizerName(),
                    eventManagementSystem.findVenueByID(x.getVenueID()).getVenueName(),
                    x.getStartDate(),
                    x.getEndDate(),
                    x.getExpectedAttendees());
    }

    public static void findEventByName() {
        System.out.print("Enter name event you want to find: ");
        String name = sc.nextLine();
        for (Event eventsFounded : eventManagementSystem.findEventsByName(name)) {
            System.out.println(eventsFounded);
        }
    }

    public static void updateEvent() {
        System.out.print("Enter ID Event you want to UPDATE: ");
        int id = Integer.parseInt(sc.nextLine());
        eventManagementSystem.updateEvent(id, eventManagementSystem.searchEventByID(id));
    }

    public static void deleteEvent() {
        eventManagementSystem.deleteEvent();
    }

}

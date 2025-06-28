/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventmanagementsystem.models;



/**
 *
 * @author vinhu
 */
public class Event {
    private int eventID;
    private String eventName;
    private int organizerID;
    private int venueID;
    private String startDate;
    private String endDate;
    private int expectedAttendees;
    
    

    public Event(int eventID, String eventName, int organizerID, int venueID, String startDate, String endDate, int expectedAttendees) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.organizerID = organizerID;
        this.venueID = venueID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.expectedAttendees = expectedAttendees;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getOrganizerID() {
        return organizerID;
    }

    public void setOrganizerID(int organizerID) {
        this.organizerID = organizerID;
    }

    public int getVenueID() {
        return venueID;
    }

    public void setVenueID(int venueID) {
        this.venueID = venueID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getExpectedAttendees() {
        return expectedAttendees;
    }

    public void setExpectedAttendees(int expectedAttendees) {
        this.expectedAttendees = expectedAttendees;
    }

    @Override
    public String toString() {
        String format = "|%-10s|%-15s|%-15s|%-15s|%-15s|%-15s|%-24s|";
        return String.format(format,eventID, eventName,organizerID,venueID,startDate,endDate,expectedAttendees);

    }
    
    
}

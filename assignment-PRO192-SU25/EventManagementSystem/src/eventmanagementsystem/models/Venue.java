/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventmanagementsystem.models;



/**
 *
 * @author vinhu
 */
public class Venue {
    private int venueID;
    private String venueName;
    

    public Venue(int venueID, String venueName) {
        this.venueID = venueID;
        this.venueName = venueName;
    }
    
    public int getVenueID() {
        return venueID;
    }

    public void setVenueID(int venueID) {
        this.venueID = venueID;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    @Override
    public String toString() {
        return venueID +":" +venueName;
    }
    
}

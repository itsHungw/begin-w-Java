/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventmanagementsystem.models;



/**
 *
 * @author vinhu
 */
public class Organizer {
    private int organizerID;
    private String organizerName;
    

    public Organizer(int organizerID, String organizerName) {
        this.organizerID = organizerID;
        this.organizerName = organizerName;
    }
    
    
    public int getOrganizerID() {
        return organizerID;
    }

    public void setOrganizerID(int organizerID) {
        this.organizerID = organizerID;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    @Override
    public String toString() {
        return organizerID +". " +organizerName;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package eventmanagementsystem.service;
import eventmanagementsystem.data.Event;
import java.util.List;

/**
 * @author vinhu
 */
public interface EventOperations {

    public void creatEvent(Event event);

    public void updateEvent(int eventID, Event event);

    public boolean deleteEvent(int eventID);

    public List<Event> findEventsByName(String name);

    public List<Event> listAllEvents();


}

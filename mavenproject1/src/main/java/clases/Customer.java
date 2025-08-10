/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
import java.util.ArrayList;
import java.util.List;
import comportamental.EventObserver;
public class Customer implements EventObserver {
    private String contactInfo;
    private List<Reservation> reservations = new ArrayList<>();

    public Customer(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
    @Override
    public void update(String eventName, String message) {
        System.out.println("Notificación para " + contactInfo + 
                         " sobre " + eventName + ": " + message);
    }
}
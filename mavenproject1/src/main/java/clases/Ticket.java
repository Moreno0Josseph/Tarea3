/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
public class Ticket {
    private Reservation reservation;
    private double price;

    public Ticket(Reservation reservation, double price) {
        this.reservation = reservation;
        this.price = price;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public double getPrice() {
        return price;
    }

    public String getETicket() {
        return "PDF_DATA_SIMULATED";
    }
}

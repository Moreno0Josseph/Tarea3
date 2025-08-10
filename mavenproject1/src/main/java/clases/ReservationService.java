/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
import java.util.List;

public class ReservationService {
    public Reservation reserveSeats(Customer customer, List<Seat> seats) {
        Reservation reservation = new Reservation();
        for (Seat seat : seats) {
            reservation.addSeat(seat);
        }
        customer.addReservation(reservation);
        return reservation;
    }

    public void releaseSeats(Reservation reservation) {
        reservation.cancel();
    }
}

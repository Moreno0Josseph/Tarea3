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

public class Reservation {
    private List<Seat> seats = new ArrayList<>();
    private List<Option> options = new ArrayList<>();
    private boolean confirmed = false;

    public void addSeat(Seat seat) {
        seats.add(seat);
        seat.reserve();
    }

    public void removeSeat(Seat seat) {
        seats.remove(seat);
        seat.release();
    }

    public void confirm() {
        confirmed = true;
    }

    public void cancel() {
        for (Seat seat : seats) {
            seat.release();
        }
        seats.clear();
        confirmed = false;
    }

    public void addOption(Option option) {
        options.add(option);
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public List<Option> getOptions() {
        return options;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
<<<<<<< HEAD
 * @author Manue
=======
 * @author gutav
>>>>>>> ccce021478907634743578f0380fdf29b0f2e3c6
 */
public class EscalatedState implements TicketState {
    @Override
    public void handle(SupportTicket ticket) {
        System.out.println("Ticket escalado al equipo especializado.");
    }

    @Override
    public TicketStatus getStatus() {
        return TicketStatus.ESCALATED;
    }
}
<<<<<<< HEAD

=======
>>>>>>> ccce021478907634743578f0380fdf29b0f2e3c6

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
<<<<<<< HEAD
 * @author Manue
 */
public class OpenState implements TicketState{
=======
 * @author gutav
 */
public class OpenState implements TicketState {
>>>>>>> ccce021478907634743578f0380fdf29b0f2e3c6
    @Override
    public void handle(SupportTicket ticket) {
        System.out.println("Ticket abierto. En espera de atención.");
    }

    @Override
    public TicketStatus getStatus() {
        return TicketStatus.OPEN;
    }
}
<<<<<<< HEAD
=======

>>>>>>> ccce021478907634743578f0380fdf29b0f2e3c6

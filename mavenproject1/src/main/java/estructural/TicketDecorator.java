/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructural;
import clases.Ticket;
/**
 *
 * @author Joseph
 */
public abstract class TicketDecorator extends Ticket {
    protected Ticket decoratedTicket;
    
    public TicketDecorator(Ticket decoratedTicket) {
        super(decoratedTicket.getReservation(), decoratedTicket.getPrice());
        this.decoratedTicket = decoratedTicket;
    }
    
    @Override
    public String getETicket() {
        return decoratedTicket.getETicket();
    }
}

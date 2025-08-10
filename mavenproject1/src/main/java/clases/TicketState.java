/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clases;

/**
 *
 * @author gutav
 */
public interface TicketState {

    void handle(SupportTicket ticket);

    TicketStatus getStatus();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
public class TicketService {
    private PaymentProcessor paymentProcessor;
    private PricePolicy pricePolicy;

    public TicketService(PaymentProcessor paymentProcessor, PricePolicy pricePolicy) {
        this.paymentProcessor = paymentProcessor;
        this.pricePolicy = pricePolicy;
    }

    public Ticket purchase(Reservation reservation) {
        double price = pricePolicy.calculatePrice(reservation);
        PaymentResult result = paymentProcessor.processPayment(price);
        if (result.isSuccess()) {
            reservation.confirm();
            return new Ticket(reservation, price);
        }
        return null;
    }

    public boolean refund(Ticket ticket) {
        return true;
    }
}
package clases;

import comportamental.EventNotifier;
import creacional.EventFactory;
import creacional.TheatreEventFactory;
import estructural.BeverageDecorator;
import estructural.TicketDecorator;
import java.lang.foreign.Linker.Option;
import java.util.List;

public class TicketEnVivo {
    public static void main(String[] args) {
        // 1. Configuración inicial usando Factory Method para crear eventos
        EventFactory eventFactory = new TheatreEventFactory();
        Event event = eventFactory.createEvent();
        System.out.println("Evento creado: " + event.getEventDetails());

        // 2. Configuración del show y asientos
        Show show = new Show();
        event.addShow(show);
        
        Selection platea = new Selection();
        for (int i = 0; i < 5; i++) {
            platea.addSeat(new Seat());
        }
        show.addSection(platea);

        // 3. Creación de cliente y sistema de notificación (Observer)
        Customer customer = new Customer("cliente@email.com");
        EventNotifier eventNotifier = new EventNotifier();
        eventNotifier.addObserver(customer);

        // 4. Selección de asientos y creación de reserva
        List<Seat> selectedSeats = platea.getAvailableSeats().subList(0, 2);
        ReservationService reservationService = new ReservationService();
        Reservation reservation = reservationService.reserveSeats(customer, selectedSeats);

        // 5. Añadir opciones usando Decorator
        Option bebida = new Option("Bebida", 5.0);
        Option estacionamiento = new Option("Estacionamiento", 10.0);
        reservation.addOption(bebida);
        reservation.addOption(estacionamiento);

        // 6. Configuración de políticas y procesadores (Strategy)
        PricePolicy pricePolicy = r -> {
            double base = r.getSeats().size() * 100; // $100 por asiento
            for (Option o : r.getOptions()) {
                base += o.getPrice();
            }
            return base;
        };

        PaymentProcessor paymentProcessor = amount -> {
            System.out.println("Procesando pago por $" + amount + "...");
            return new PaymentResult(true);
        };

        RefundStrategy refundStrategy = new StandardRefundStrategy();
        
        // 7. Creación del servicio de tickets y compra
        TicketService ticketService = new TicketService(paymentProcessor, pricePolicy, refundStrategy);
        Ticket baseTicket = ticketService.purchase(reservation);
        
        if (baseTicket != null) {
            // Aplicar Decorator para añadir extras al ticket
            Ticket decoratedTicket = new BeverageDecorator(
                new ParkingDecorator(baseTicket, estacionamiento.getPrice()), 
                bebida.getPrice());
            
            System.out.println("\n--- Ticket Final ---");
            System.out.println(decoratedTicket.getETicket());
            System.out.println("Precio total: $" + decoratedTicket.getPrice());
            
            // Notificar al cliente (Observer)
            eventNotifier.notifyObservers(event.getType().toString(), 
                "Su compra ha sido confirmada. Detalles en su email.");
            
            // 8. Simulación de soporte técnico (State Pattern)
            SupportTicket supportTicket = new SupportTicket(IssueType.PAYMENT, customer);
            System.out.println("\nEstado inicial del ticket de soporte: " + supportTicket.getStatus());
            
            supportTicket.escalate();
            System.out.println("Estado después de escalar: " + supportTicket.getStatus());
            
            supportTicket.close();
            System.out.println("Estado final: " + supportTicket.getStatus());
            
            // 9. Prueba de reembolso (Strategy Pattern)
            System.out.println("\nIntentando reembolso...");
            boolean refundResult = ticketService.refund(decoratedTicket);
            System.out.println("Resultado del reembolso: " + (refundResult ? "Éxito" : "Fallido"));
        } else {
            System.out.println("Error en la compra. No se generó ticket.");
        }
    }
}

// Clases adicionales necesarias para la implementación completa

class ParkingDecorator extends TicketDecorator {
    private double parkingPrice;
    
    public ParkingDecorator(Ticket decoratedTicket, double parkingPrice) {
        super(decoratedTicket);
        this.parkingPrice = parkingPrice;
    }
    
    @Override
    public double getPrice() {
        return super.getPrice() + parkingPrice;
    }
    
    @Override
    public String getETicket() {
        return super.getETicket() + "\nIncluye: Estacionamiento (+$" + parkingPrice + ")";
    }
}

 
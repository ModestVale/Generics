package manager;

import domain.Ticket;
import repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private final TicketRepository ticketRepository;

    public TicketManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    public Ticket[] findAll(String from, String to) {
        Ticket[] allTickets = ticketRepository.findAll();
        Ticket[] outputTickets = new Ticket[0];
        for (Ticket currentTicket : allTickets) {
            if (currentTicket.getArrivalAirport() == to && currentTicket.getDepartureAirport() == from) {
                int length = outputTickets.length + 1;
                Ticket[] tmp = new Ticket[length];
                System.arraycopy(outputTickets, 0, tmp, 0, outputTickets.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = currentTicket;
                outputTickets = tmp;
            }
        }

        Arrays.sort(outputTickets);
        return outputTickets;
    }
}

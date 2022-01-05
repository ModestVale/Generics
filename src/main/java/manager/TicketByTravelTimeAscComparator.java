package manager;

import domain.Ticket;

import java.util.Comparator;

public class TicketByTravelTimeAscComparator implements Comparator<Ticket> {
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}

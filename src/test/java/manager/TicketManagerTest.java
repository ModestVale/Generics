package manager;

import domain.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class TicketManagerTest {

    @Mock
    private TicketRepository repository;

    @InjectMocks
    private TicketManager productManager;

    private Ticket ticket1 = new Ticket(1, 300, "REN", "SVO", 150);
    private Ticket ticket2 = new Ticket(2, 200, "REN", "SVO", 124);
    private Ticket ticket3 = new Ticket(3, 100, "REN", "SVO", 126);
    private Ticket ticket4 = new Ticket(4, 100, "REN", "DME", 133);
    private Ticket ticket5 = new Ticket(5, 10000, "SVO", "REN", 140);

    @Test
    public void shouldFindAllReturnRelatedTicketIfExist() {
        createRepositoryMock();
        Ticket[] expectedTickets = new Ticket[3];
        expectedTickets[0] = ticket3;
        expectedTickets[1] = ticket2;
        expectedTickets[2] = ticket1;

        Ticket[] actualTickets = productManager.findAll("SVO", "REN", new TicketByPriceAscComparator());

        assertArrayEquals(expectedTickets, actualTickets);
    }

    @Test
    public void shouldFindAllReturnEmptyArrayIfNotExist() {
        createRepositoryMock();
        Ticket[] expectedTickets = new Ticket[0];
        Ticket[] actualTickets = productManager.findAll("SVO", "VKO", new TicketByPriceAscComparator());

        assertArrayEquals(expectedTickets, actualTickets);
    }

    @Test
    public void shouldFindAllReturnRelatedSortedByTravelTimeTicketIfExist() {
        createRepositoryMock();
        Ticket[] expectedTickets = new Ticket[3];
        expectedTickets[0] = ticket2;
        expectedTickets[1] = ticket3;
        expectedTickets[2] = ticket1;

        Ticket[] actualTickets = productManager.findAll("SVO", "REN", new TicketByTravelTimeAscComparator());

        assertArrayEquals(expectedTickets, actualTickets);
    }

    private void createRepositoryMock() {
        Ticket[] tickets = new Ticket[5];
        tickets[0] = ticket1;
        tickets[1] = ticket2;
        tickets[2] = ticket3;
        tickets[3] = ticket4;
        tickets[4] = ticket5;

        doReturn(tickets).when(repository).findAll();
    }
}

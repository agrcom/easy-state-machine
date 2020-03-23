import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {

    @Test
    public void initialState(){
        Ticket ticket = new Ticket();

        Ticket.State initialTicketState = ticket.getState();
        assertThat(initialTicketState).isEqualTo(Ticket.State.INITIAL);
    }

    @Test
    public void setState(){
        Ticket ticket = new Ticket();

        ticket.setState(Ticket.State.IN_DEVELOPMENT);
        assertThat(ticket.getState()).isEqualTo(Ticket.State.IN_DEVELOPMENT);
    }


    @Test
    public void fullLifeCycle(){
        Ticket ticket = new Ticket();

        while (!ticket.getState().equals(Ticket.State.CLOSED)){
            ticket.proceed();
        }

        assertThat(ticket.getState()).isEqualTo(Ticket.State.CLOSED);

    }
}
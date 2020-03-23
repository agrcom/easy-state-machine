import lombok.extern.java.Log;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log
public class TicketStateTest {

    @Test
    public void basic_initTicket_success(){
        Ticket ticket = Ticket.builder().id("FSM1").topic("Test").build();

        TicketState actual = TicketState.initial;

        actual.setTicket(ticket);
        actual.proceed();
        actual = actual.nextState();

        assertThat(actual).isEqualTo(TicketState.open);
        assertThat(actual.getTicket().getStatus()).isEqualTo(TicketState.open);
    }

    @Test
    public void fullFlow_success(){
        Ticket ticket = Ticket.builder().id("FSM1").topic("Test").build();
        TicketState actual = TicketState.initial;
        actual.setTicket(ticket);

        while (actual != TicketState.close){
            actual.proceed();
            actual = actual.nextState();
            log.info("Current State: "+ actual.name());
        }

        assertThat(actual).isEqualTo(TicketState.close);
        assertThat(actual.getTicket().getStatus()).isEqualTo(TicketState.close);
    }

}
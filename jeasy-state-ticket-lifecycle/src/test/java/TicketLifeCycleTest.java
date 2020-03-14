import events.CreateEvent;
import events.StartDevelopmentEvent;
import org.jeasy.states.api.FiniteStateMachine;
import org.jeasy.states.api.FiniteStateMachineException;
import org.jeasy.states.api.State;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketLifeCycleTest {

    @Test
    public void createTicket_success() throws FiniteStateMachineException {
        TicketLifeCycle lifeCycle = new TicketLifeCycle();
        FiniteStateMachine stateMachine = lifeCycle.configure();

        State returnedState = stateMachine.fire(new CreateEvent());
        State currentState = stateMachine.getCurrentState();

        assertThat(returnedState).isEqualTo(currentState);
    }

    @Test
    public void createToInDev_success() throws FiniteStateMachineException {
        TicketLifeCycle lifeCycle = new TicketLifeCycle();
        FiniteStateMachine stateMachine = lifeCycle.configure();

        State created = stateMachine.fire(new CreateEvent("Ticket"));

        assertThat(stateMachine.getLastEvent().getName()).isEqualTo("Ticket");

        State startDev = stateMachine.fire(new StartDevelopmentEvent());

        assertThat(startDev).isNotEqualTo(created);

    }

    @Test
    public void createToTest_success() throws FiniteStateMachineException {}

}
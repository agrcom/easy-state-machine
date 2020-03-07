import actions.CreateEH;
import com.google.common.collect.ImmutableSet;
import events.OpenEvent;
import org.jeasy.states.api.FiniteStateMachine;
import org.jeasy.states.api.State;
import org.jeasy.states.api.Transition;
import org.jeasy.states.core.FiniteStateMachineBuilder;
import org.jeasy.states.core.TransitionBuilder;

import java.util.Set;

public class TicketLifeCycle {


    State none = new State("None");
    State open = new State("Open");
    State inDevelopment = new State("InDevelopment");
    State testing = new State("Testing");
    State close = new State("Close");

    Set<State> states = ImmutableSet.of(none, open, inDevelopment, testing, close);

    Transition openTransition = new TransitionBuilder()
            .name("open")
            .sourceState(none)
            .eventType(OpenEvent.class)
            .eventHandler(new CreateEH())
            .targetState(inDevelopment)
            .build();

            /*                .name("unlock")
                .sourceState(locked)
                .eventType(CoinEvent.class)
                .eventHandler(new Unlock())
                .targetState(unlocked)
                .build();*/

    FiniteStateMachine turnstileStateMachine = new FiniteStateMachineBuilder(states, none)
            .registerTransition(openTransition)

            .registerFinalState(close)
            .build();


}

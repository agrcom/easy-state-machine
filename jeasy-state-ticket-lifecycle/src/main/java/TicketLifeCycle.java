import actions.CloseTicketEH;
import actions.CreateEH;
import actions.ReOpenEH;
import actions.StartDevelopmentEH;
import com.google.common.collect.ImmutableSet;
import events.*;
import org.jeasy.states.api.FiniteStateMachine;
import org.jeasy.states.api.State;
import org.jeasy.states.api.Transition;
import org.jeasy.states.core.FiniteStateMachineBuilder;
import org.jeasy.states.core.TransitionBuilder;

import java.util.Set;

public class TicketLifeCycle {


    State initial = new State("Initial");
    State open = new State("Open");
    State inDevelopment = new State("InDevelopment");
    State testing = new State("Testing");
    State close = new State("Close");

    Set<State> states = ImmutableSet.of(initial, open, inDevelopment, testing, close);

    Transition openTransition = new TransitionBuilder()
            .name("open")
            .sourceState(initial)
            .eventType(CreateEvent.class)
            .eventHandler(new CreateEH())
            .targetState(open)
            .build();

    Transition inDevTransition = new TransitionBuilder()
            .name("inDevelopment")
            .sourceState(open)
            .eventType(StartDevelopmentEvent.class)
            .eventHandler(new StartDevelopmentEH())
            .targetState(inDevelopment)
            .build();

    Transition inTestTransition = new TransitionBuilder()
            .name("inTesting")
            .sourceState(inDevelopment)
            .eventType(StopDevelopmentEvent.class)
            .eventHandler(new StartDevelopmentEH())
            .targetState(testing)
            .build();

    Transition testToCloseTransition = new TransitionBuilder()
            .name("testToClose")
            .sourceState(testing)
            .eventType(CloseTicketEH.class)
            .eventHandler(new StartDevelopmentEH())
            .targetState(close)
            .build();

    Transition reopenTransition = new TransitionBuilder()
            .name("reopen")
            .sourceState(testing)
            .sourceState(close)
            .eventType(ReOpenEvent.class)
            .eventHandler(new ReOpenEH())
            .targetState(open)
            .build();

    public FiniteStateMachine configure() {
        return new FiniteStateMachineBuilder(states, initial)
                .registerTransition(openTransition)
                .registerTransition(inDevTransition)
                .registerTransition(inTestTransition)
                .registerTransition(testToCloseTransition)
                .registerTransition(reopenTransition)
                .registerFinalState(close)
                .build();
    }
}

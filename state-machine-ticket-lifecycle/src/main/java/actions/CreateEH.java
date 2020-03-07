package actions;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.states.api.Event;
import org.jeasy.states.api.EventHandler;

@Slf4j
public class CreateEH implements EventHandler {

    @Override
    public void handleEvent(Event event) throws Exception {
        System.out.println("Handle Event");

    }
}

package actions;

import events.StopDevelopmentEvent;
import lombok.extern.java.Log;
import org.jeasy.states.api.Event;
import org.jeasy.states.api.EventHandler;

@Log
public class StartTestingEH implements EventHandler {

    public void handleEvent(StopDevelopmentEvent event) throws Exception {
        log.info("Start Testing Event Handler catch StopDevelopment Event");

    }

    @Override
    public void handleEvent(Event event) throws Exception {
        log.info("Start Testing Event Handler catch Event");
    }
}

package actions;

import lombok.extern.java.Log;
import org.jeasy.states.api.Event;
import org.jeasy.states.api.EventHandler;

@Log
public class CreateEH implements EventHandler {

    public void handleEvent(Event event) throws Exception {
        log.info("Create Event handler!");
    }
}

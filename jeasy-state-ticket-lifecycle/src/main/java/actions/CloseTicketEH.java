package actions;

import events.CloseEvent;
import lombok.extern.java.Log;
import org.jeasy.states.api.Event;
import org.jeasy.states.api.EventHandler;

@Log
public class CloseTicketEH implements EventHandler {

    public void handleEvent(CloseEvent event) throws Exception {
        log.info("Close ticket event handler");
    }

    @Override
    public void handleEvent(Event event) throws Exception {

    }
}

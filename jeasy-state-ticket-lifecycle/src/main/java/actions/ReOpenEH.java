package actions;

import events.ReOpenEvent;
import lombok.extern.java.Log;
import org.jeasy.states.api.Event;
import org.jeasy.states.api.EventHandler;

@Log
public class ReOpenEH implements EventHandler {
    @Override
    public void handleEvent(Event event) throws Exception {

    }

    public void handleEvent(ReOpenEvent event) throws Exception {
        log.info("Event Handler triggered by Reopen Event");
    }


}

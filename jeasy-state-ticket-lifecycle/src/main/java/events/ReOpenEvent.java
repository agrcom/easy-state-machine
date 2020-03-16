package events;

import lombok.extern.java.Log;
import org.jeasy.states.api.Event;

@Log
public class ReOpenEvent extends Event {

    public ReOpenEvent(String name) {
        super(name);
        log.info("Reopen Event with name: " + name);
    }
}

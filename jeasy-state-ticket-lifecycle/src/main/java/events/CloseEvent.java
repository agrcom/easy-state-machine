package events;

import lombok.extern.java.Log;
import org.jeasy.states.api.Event;

@Log
public class CloseEvent extends Event {
    public CloseEvent() {
        log.info("Close Event!");
    }
}

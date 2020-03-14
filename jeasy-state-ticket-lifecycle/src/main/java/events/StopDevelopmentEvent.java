package events;

import lombok.extern.java.Log;
import org.jeasy.states.api.Event;

@Log
public class StopDevelopmentEvent extends Event {
    public StopDevelopmentEvent() {
        log.info("Development has been finished");
    }
}

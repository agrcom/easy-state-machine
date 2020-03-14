package events;

import lombok.extern.java.Log;
import org.jeasy.states.api.Event;

import java.util.logging.Level;

@Log
public class CreateEvent extends Event {

    public CreateEvent() {
        log.info("Create Event fired!");
    }

    public CreateEvent(String name) {
        super(name);
        log.log(Level.INFO, "Create {} Event fired!", name);
    }
}

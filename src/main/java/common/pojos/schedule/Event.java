package common.pojos.schedule;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Event {

    ArrayList<Events> events;

    public ArrayList<Events> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Events> events) {
        this.events = new ArrayList<>();
        this.events.addAll(events);
    }

}

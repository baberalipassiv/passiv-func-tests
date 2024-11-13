package common.pojos.schedule;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Layers extends Schedule{

    Event week;
    Override override;

    public Event getWeek() {
        return week;
    }

    public void setWeek(Event week) {
        this.week = week;
    }

    public Override getOverride() {
        return override;
    }

    public void setOverride(Override override) {
        this.override = override;
    }


}

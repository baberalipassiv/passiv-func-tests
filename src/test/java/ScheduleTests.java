import common.pojos.schedule.*;
import common.pojos.schedule.Override;
import common.rest.request.RequestBuilder;
import common.rest.service.ScheduleService;
import common.utils.DateTime;
import common.utils.MockProperties;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ScheduleTests extends BaseTests{

    ScheduleService scheduleService;
    @BeforeSuite
    private void setup(){
        RequestBuilder requestBuilder = new RequestBuilder(MockProperties.hubAddress);
        scheduleService = new ScheduleService(requestBuilder);
    }

    @Test(priority = 1)
    public void getScheduleTest(){
        Schedule schedule = scheduleService.getSchedule();
        schedule.getZone();
    }

    private Override setSetPoint(int temp){
        Override overideBit = new Override();
        overideBit.setStart("1970-01-01T05:42:53Z");
        overideBit.setEnd("1970-01-01T08:00:00Z");
        ArrayList<Events> eventsBit = new ArrayList<>();
        Events event = new Events();
        event.setDatetime("1970-01-01T05:42:53Z");

        event.setC(temp);
        eventsBit.add(event);
        overideBit.setEvents(eventsBit);

        return overideBit;
    }

    @Test(priority = 2)
    public void toggle_zone1_heating_performance_test(){

      //  String settf = DateTime.now();
        Schedule schedule = scheduleService.getSchedule();

        Layers setpointLayer = new Layers();
        setpointLayer.setOverride(setSetPoint(12));

        Layers firstLayer = schedule.getLayers().get(0);

        ArrayList<Layers> newLayers = new ArrayList<>();
        newLayers.add(firstLayer);
        newLayers.add(setpointLayer);

        Schedule newSched = new Schedule();
        newSched.setLayers(newLayers);
        newSched.setUri(schedule.getUri());
        newSched.setType(schedule.getType());
        newSched.setZone(schedule.getZone());
        newSched.setMode(schedule.getMode());

        int ret = scheduleService.setSchedule(newSched);
        System.out.println(ret);
    }

    @Test(priority = 2)
    public void set_zone1_setpoint_high() {
        Schedule schedule = scheduleService.getSchedule();

    }


}

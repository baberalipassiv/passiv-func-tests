package common.rest.service;

import common.pojos.DAO;
import common.pojos.loglevel.LogS;
import common.pojos.schedule.Schedule;
import common.rest.request.RequestBuilder;
import common.rest.request.RequestType;

import javax.ws.rs.core.Response;

public class ScheduleService extends Service {

    private static final String SCHEDULE = "/v/1/heating/zones/REPLACE/schedules/basic";

    public ScheduleService(RequestBuilder requestBuilder){
        super(requestBuilder);
        requestBuilder.setTargetUri(SCHEDULE.replace("REPLACE", String.valueOf(1)));
    }

    public ScheduleService(RequestBuilder requestBuilder, int zone){
        super(requestBuilder);
        requestBuilder.setTargetUri(SCHEDULE.replace("REPLACE", String.valueOf(zone)));
    }

    public Schedule getSchedule() {

        requestBuilder.setRequestType(RequestType.GET);

        Response response = requestBuilder.build().call();

        String stringJsonResponse = response.readEntity(String.class).toString();

        Schedule status = DAO.deserialize(stringJsonResponse, Schedule.class);

        status.setResponseCode(response.getStatus());

        return status;
    }

    public int setSchedule(Schedule schedule) {

        requestBuilder.setRequestType(RequestType.PUT);
        String sched = DAO.serialize(schedule);
        requestBuilder.setPayload(sched);
        Response response = requestBuilder.build().call();

        return response.getStatus();
    }
}


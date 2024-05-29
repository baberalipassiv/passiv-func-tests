package common.rest.service;

import common.pojos.DAO;
import common.pojos.schedule.Schedule;
import common.rest.request.RequestBuilder;
import common.rest.request.RequestType;

import javax.ws.rs.core.Response;

public class ScheduleService extends Service {

    private static final String SCHEDULE = "/v/1/schedule/zones/REPLACE/basic";

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
}


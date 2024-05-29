package common.rest.service;

import common.pojos.DAO;
import common.pojos.loglevel.LogS;
import common.rest.request.RequestBuilder;
import common.rest.request.RequestType;

import javax.ws.rs.core.Response;

public class LogService extends Service {

    private static final String LOGS = "/v/1/hub/log_level";

    public LogService(RequestBuilder requestBuilder){
        super(requestBuilder);
        requestBuilder.setTargetUri(LOGS);
    }


    public LogS getLogLevel(){
        requestBuilder.setRequestType(RequestType.GET);

        Response response = requestBuilder.build().call();

        String stringJsonResponse = response.readEntity(String.class).toString();

        LogS logLevel = DAO.deserialize(stringJsonResponse, LogS.class);
        logLevel.setResponseCode(response.getStatus());

        return logLevel;
    }

    public int setLogLevel(LogS level){
        requestBuilder.setRequestType(RequestType.PUT);
        String logLevel = DAO.serialize(level);
        requestBuilder.setPayload(logLevel);
        Response response = requestBuilder.build().call();
        return response.getStatus();
    }

    public int setLogLevel(String level){
        requestBuilder.setRequestType(RequestType.PUT);
        String logLevel = DAO.serialize(new LogS(level));
        requestBuilder.setPayload(logLevel);
        Response response = requestBuilder.build().call();


        return response.getStatus();

    }
}

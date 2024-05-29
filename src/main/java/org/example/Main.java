package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;
import common.pojos.Activation;
import common.pojos.loglevel.LogS;

import common.rest.request.Request;
import common.rest.request.RequestBuilder;
import common.rest.request.RequestType;
import common.rest.service.ActivationService;
import common.rest.service.LogService;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.http.HttpRequest;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
    // http://192.168.1.165:8888/*

    /*    Client client2 = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
      
        WebTarget webTarget = client2.target("http://192.168.43.139/v/1/hans/config");
      //  WebTarget webTarget = client2.target("http://192.168.1.165:8888/*");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);


        Response response = invocationBuilder.get();
*/
        RequestBuilder requestBuilder = new RequestBuilder("http://192.168.1.165/");
      //  requestBuilder.setBaseURL("http://192.168.1.165/");

        LogService logService = new LogService(requestBuilder);
        LogS level = logService.getLogLevel();
        LogS logL =  new LogS("Info");
        int sdf = logService.setLogLevel(logL);
         level = logService.getLogLevel();

        ActivationService activationService = new ActivationService(requestBuilder);
        Activation status = activationService.getHubStatus();
        String dhg = status.getMode();
        int ds = status.getResponseCode();
     /*   RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.setBaseURL("http://192.168.43.139/");
        requestBuilder.setTargetUri("v/1/hans/config");
        requestBuilder.setRequestType(RequestType.GET);

        Response response1 = requestBuilder.build().call();

        String stringJsonResponse = response1.readEntity(String.class).toString();
/*
        String stringJsonResponse = response.readEntity(String.class).toString();

        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget wt = client.target("http://192.168.43.54/v/1/hans/config");
        wt.request("text/plain");
        Response res = wt.request("text/plain").get();

*/
        System.out.println("Hello world!");
    }
}
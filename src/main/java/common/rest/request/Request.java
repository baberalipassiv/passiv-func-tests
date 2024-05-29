package common.rest.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import common.pojos.DAO;
import common.pojos.GenericResponse;
import common.rest.RestClient;


import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import java.util.HashMap;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class Request {
    private String baseURL;
    private String targetUri;
    private HashMap<String, String> queryParams;
    private HashMap<String, String> headers;
    private Entity payload;
    private RequestType requestType;
    private String username;
    private String password;
    private Cookie cookie;
    ObjectMapper mapper = new ObjectMapper();
    public Request(String baseURL, String targetUri, HashMap<String, String> queryParams,
                   HashMap<String, String> headers, Cookie cookie, Entity payload, RequestType requestType,
                   String username, String password) {
        this.baseURL = baseURL;
        this.targetUri = targetUri;
        this.queryParams = queryParams;
        this.headers = headers;
        this.payload = payload;
        this.requestType = requestType;
        this.username = username;
        this.password = password;
        this.cookie = cookie;
    }

    public Response call() {
        Response response =
                RestClient
                        .genericRestCall(this.baseURL, this.targetUri, this.queryParams, this.headers,
                                this.cookie, this.payload, this.requestType, this.username, this.password);

   /*     DAO dao = new GenericResponse();
        dao.setResponseCode(response.getStatus());
        dao.setStringJsonResponse(response.readEntity(String.class).toString());
     */   return response;
    }

}

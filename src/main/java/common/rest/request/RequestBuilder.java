package common.rest.request;

import java.util.HashMap;


import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestBuilder {
    private String baseURL;
    private String targetUri;
    private HashMap<String, String> queryParams;
    private HashMap<String, String> headers;
    private Entity payload;
    private RequestType requestType;
    private String username;
    private String password;
    private Cookie cookie;

    public RequestBuilder(String baseURL){
        setBaseURL(baseURL);
    }

    public RequestBuilder setBaseURL(String baseURL) {
        this.baseURL = baseURL;
        return this;
    }

    public RequestBuilder setTargetUri(String targetUri) {
        this.targetUri = targetUri;
        return this;
    }

    public RequestBuilder setQueryParams(HashMap<String, String> queryParams) {
        this.queryParams = queryParams;
        return this;
    }

    public RequestBuilder setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public RequestBuilder setPayload(String payload) {
        this.payload = Entity.entity(payload.toString(), MediaType.APPLICATION_JSON_TYPE);
        return this;
    }


    public RequestBuilder setPayload(Entity payload) {
        this.payload = payload;
        return this;
    }

    public RequestBuilder setRequestType(RequestType requestType) {
        this.requestType = requestType;
        return this;
    }

    public RequestBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public RequestBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public RequestBuilder setCookie(Cookie cookie) {
        this.cookie = cookie;
        return this;
    }

    public Request build() {
        return new Request(this.baseURL, this.targetUri, this.queryParams, this.headers, this.cookie,
                this.payload, this.requestType, this.username, this.password);
    }
}

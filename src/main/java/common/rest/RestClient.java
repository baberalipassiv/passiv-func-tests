package common.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.rest.request.RequestType;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Iterator;


public class RestClient {

    WebTarget service;
    ObjectMapper mapper = new ObjectMapper();

    private RestClient(String baseUrl) {

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.property("jersey.config.jetty.client.disableCookies", Boolean.TRUE);
        clientConfig.property("jersey.config.client.request.entity.processing", "BUFFERED");
        clientConfig.register(LoggingFilter.class);

        Client client = ClientBuilder.newClient(clientConfig);
        this.service = client.target(baseUrl);
    }

    private Response request(RequestType requestType, String target, Entity<?> entity,
                             HashMap<String, String> headers, HashMap<String, String> parameters, Cookie cookie) {

        WebTarget resourceWebTarget = this.service.path(target);


        Iterator localIterator;
        if (parameters != null) {
            for (localIterator = parameters.keySet().iterator(); localIterator.hasNext();) {
                String key = (String) localIterator.next();

                resourceWebTarget = resourceWebTarget.queryParam(key, new Object[] {parameters.get(key)});
            }
        }
        // String key;
        javax.ws.rs.client.Invocation.Builder invocationBuilder = resourceWebTarget.request();

        // TODO -
        // To set a cookie in REST API request,
        // first get reference of Invocation.Builder from webTarget.request() method, and then use its methods.

        if (cookie != null) {
            invocationBuilder.cookie(cookie);
        }
        if (headers != null) {
            for (String key : headers.keySet()) {
                invocationBuilder.header(key, headers.get(key));
            }
        }
        Response response = null;
        switch (requestType) {
            case GET:
                response = invocationBuilder.get();
                break;
            case PUT:
                response = invocationBuilder.put(entity);
                break;
            case POST:
                response = invocationBuilder.post(entity);
                break;
            case DELETE:
                response = invocationBuilder.delete();
                break;
            case PATCH:
                response = invocationBuilder.method("PATCH", entity);
        }
        return response;
    }

    public static Response genericRestCall(String baseURL, String targetUri,
                                           HashMap<String, String> queryParams, HashMap<String, String> headers, Cookie cookie,
                                           Entity payload, RequestType requestType, String username, String password) {
        RestClient restClient = new RestClient(baseURL);

        Response response =
                restClient.request(requestType, targetUri, payload, headers, queryParams, cookie);
        return response;
    }
}

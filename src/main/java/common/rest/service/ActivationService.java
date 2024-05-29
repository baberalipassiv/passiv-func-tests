package common.rest.service;

import common.pojos.Activation;
import common.pojos.DAO;
import common.rest.request.RequestBuilder;
import common.rest.request.RequestType;

import javax.ws.rs.core.Response;

public class ActivationService extends Service {

    private static final String ACTIVATION = "/v/1/system/activation";

    public ActivationService(RequestBuilder requestBuilder){
        super(requestBuilder);
        requestBuilder.setTargetUri(ACTIVATION);
    }

    public Activation getHubStatus() {

        requestBuilder.setRequestType(RequestType.GET);

        Response response = requestBuilder.build().call();

        String stringJsonResponse = response.readEntity(String.class).toString();


        Activation status = DAO.deserialize(stringJsonResponse, Activation.class);
        status.setResponseCode(response.getStatus());

        return status;
    }
}

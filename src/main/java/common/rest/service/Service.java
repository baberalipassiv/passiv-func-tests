package common.rest.service;

import common.rest.request.RequestBuilder;

public class Service implements IService {

    RequestBuilder requestBuilder ;

    public Service(RequestBuilder requestBuilder) {

        this.requestBuilder = requestBuilder;

    }

    @Override
    public RequestBuilder getRequestBuilder() {
        return requestBuilder;
    }

    @Override
    public void setRequestBuilder(RequestBuilder requestBuilder) {
        this.requestBuilder = requestBuilder;
    }

}

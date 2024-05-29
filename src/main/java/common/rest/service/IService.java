package common.rest.service;

import common.rest.request.RequestBuilder;

public interface IService {

     RequestBuilder getRequestBuilder();

     void setRequestBuilder(RequestBuilder requestBuilder);

}

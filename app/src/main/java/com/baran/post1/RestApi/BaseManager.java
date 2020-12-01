package com.baran.post1.RestApi;

public class BaseManager {

    protected RestApi getRestApiClient(){
        RestApiClient restApiClient = new RestApiClient(BaseUrl.BASE_URL);

        return restApiClient.getRestApi();
    }
}

package Router;

import Request.RequestBuilder;
import RequestHandling.HandleAction;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class MockHandleGet implements HandleAction {
    RequestBuilder request;
    String mockResponse;

    @Override
    public void setRequest(RequestBuilder request) {
        this.request = request;
    }

    @Override
    public String getResponse() {
        return mockResponse;
    }

    public void setMockResponse(){
        this.mockResponse = mockResponse;
    }
}

package ClientThreads;

import Controllers.MockRequest;
import Request.InfoProcessor;
import Request.RequestBuilder;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class MockRequestProcessor implements InfoProcessor {
    private MockRequest request;

    public MockRequestProcessor(){
        request = new MockRequest();
    }

    public void handleRequest(StringBuffer rawRequest) {
        request.buildRequest(rawRequest);
    }

    public RequestBuilder getRequest() {
        return request;
    }
}

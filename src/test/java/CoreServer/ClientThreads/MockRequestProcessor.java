package CoreServer.ClientThreads;

import CoreServer.Controllers.MockRequest;
import CoreServer.Request.InfoProcessor;
import CoreServer.Request.Request;

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

    public Request getRequest() {
        return request;
    }
}

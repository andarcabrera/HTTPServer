package Router;

import Request.RequestBuilder;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public class MockRouter implements RouterStrategy {
    StringBuffer requestInfo = new StringBuffer();

    @Override
    public void route(RequestBuilder request) {
        requestInfo.append(request.getRawBody());
    }

    @Override
    public byte[] getResponse() {
        return requestInfo.toString().getBytes();
    }
}

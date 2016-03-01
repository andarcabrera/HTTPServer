package RequestHandling;

import Request.InfoProcessor;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class MockRequestProcessor implements InfoProcessor {
    byte[] response;

    public void handleRequest(StringBuffer rawRequest) {
        response = rawRequest.substring(0).getBytes();
    }

    public byte[] response() {
        return response;
    }
}

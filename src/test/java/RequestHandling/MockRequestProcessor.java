package RequestHandling;

import Request.InfoProcessor;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class MockRequestProcessor implements InfoProcessor {
    String response;

    public void handleRequest(StringBuffer rawRequest) {
        System.out.println("Here");

        response = rawRequest.substring(0);
        System.out.println(response);
    }

    public String response() {
        return response;
    }
}

package Controllers;

import Response.ResponseBuilder;

/**
 * Created by andacabrera29 on 3/3/16.
 */
public class MockResponse implements ResponseBuilder {
    private String statusCode = "";
    @Override
    public void setStatusCode(String status) {
        this.statusCode = status;
    }

    @Override
    public void addHeader(String headerTitle, String headerContent) {

    }

    @Override
    public void setResponseBody(byte[] bodyContent) {

    }

    @Override
    public byte[] responseToBytes() {
        return statusCode.getBytes();
    }
}

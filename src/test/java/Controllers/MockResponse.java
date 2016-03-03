package Controllers;

import Response.ResponseBuilder;

/**
 * Created by andacabrera29 on 3/3/16.
 */
public class MockResponse implements ResponseBuilder {
    private String statusCode = "";
    @Override
    public void setStatusCode(Integer code) {
        this.statusCode = String.valueOf(code);
    }

    @Override
    public void addHeader(String header) {

    }

    @Override
    public byte[] responseToBytes() {
        return statusCode.getBytes();
    }
}
